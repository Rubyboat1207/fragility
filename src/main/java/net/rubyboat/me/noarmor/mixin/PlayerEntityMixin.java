package net.rubyboat.me.noarmor.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.rubyboat.me.noarmor.unformal_mixins.PlayerMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
	@Inject(at = @At("HEAD"), method = "tick")
	private void tick(CallbackInfo info) {
		PlayerEntity player = ((PlayerEntity) ((Object) this));
		PlayerMixin.INSTANCE.tick(player);
	}
}