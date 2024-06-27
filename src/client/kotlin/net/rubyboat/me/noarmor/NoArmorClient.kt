package net.rubyboat.me.noarmor

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.network.packet.CustomPayload


object NoArmorClient : ClientModInitializer {
	override fun onInitializeClient() {
//		ClientPlayConnectionEvents.JOIN.register { handler, sender, client ->
//			run {
//				val modlist = FabricLoader.getInstance().allMods.map { mod -> mod.metadata.name }
//				sender.sendPacket(ModlistPayload(modlist))
//			}
//		}
	}
}