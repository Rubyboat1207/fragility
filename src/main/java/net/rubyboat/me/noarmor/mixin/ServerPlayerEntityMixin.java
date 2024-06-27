package net.rubyboat.me.noarmor.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.rubyboat.me.noarmor.unformal_mixins.PlayerMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {

    @Inject(at = @At("HEAD"), method = "onDeath")
    public void onDeath(DamageSource damageSource, CallbackInfo ci) {
        PlayerEntity player = ((PlayerEntity) ((Object) this));
        PlayerMixin.INSTANCE.onDeath(player, damageSource);
    }
}
