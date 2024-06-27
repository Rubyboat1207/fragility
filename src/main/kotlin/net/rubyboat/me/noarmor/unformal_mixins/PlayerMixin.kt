package net.rubyboat.me.noarmor.unformal_mixins

import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.server.BannedPlayerEntry
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.rubyboat.me.noarmor.IdentifierUtil.Companion.of

object PlayerMixin {
    private val tickTimer: HashMap<PlayerEntity, Int> = HashMap();
    private const val TIME_UNTIL_DAMAGE = 20

    fun tick(player: PlayerEntity) {
        var tookDamage = false

        for (armor in player.armorItems) {
            if (armor.isIn(TagKey.of(RegistryKeys.ITEM, of("armor_items")))) {
                tookDamage = true
            }
        }

        if(tookDamage) {
            val timeSinceLastDamage = tickTimer[player] ?: TIME_UNTIL_DAMAGE

            if(timeSinceLastDamage == TIME_UNTIL_DAMAGE) {
                player.damage(player.damageSources.magic(), 8F)
                tickTimer[player] = 0
            }else {
                tickTimer[player] = timeSinceLastDamage + 1
            }

        }
    }

    fun onDeath(player: PlayerEntity, damageSource: DamageSource) {
        if(player.world.isClient) {
            return
        }
        val entry = BannedPlayerEntry(player.gameProfile, null, "Fragility Enforcement Crew", null, "You should have been more careful")
        player.server?.playerManager?.userBanList?.add(entry)

        (player as ServerPlayerEntity).networkHandler.disconnect(Text.literal("You should have been more careful"))
    }
}