package net.rubyboat.me.noarmor.mixin;

import net.minecraft.network.PacketCallbacks;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.ChatMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.DeathMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerListS2CPacket;
import net.minecraft.server.network.ServerCommonNetworkHandler;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerCommonNetworkHandler.class)
public class ServerCommonNetworkHandlerMixin {

    @Inject(at = @At("HEAD"), method = "sendPacket", cancellable = true)
    public void sendChatMessage(Packet<?> packet, CallbackInfo ci) {
        if(packet instanceof DeathMessageS2CPacket || packet instanceof ChatMessageS2CPacket || packet instanceof GameMessageS2CPacket || packet instanceof PlayerListS2CPacket) {
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "send", cancellable = true)
    public void sendChatMessage(Packet<?> packet, @Nullable PacketCallbacks callbacks, CallbackInfo ci) {
        if(packet instanceof DeathMessageS2CPacket || packet instanceof ChatMessageS2CPacket || packet instanceof GameMessageS2CPacket || packet instanceof PlayerListS2CPacket) {
            ci.cancel();
        }
    }
}
