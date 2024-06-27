package net.rubyboat.me.noarmor

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import org.slf4j.LoggerFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

object NoArmor : ModInitializer {
    private val logger = LoggerFactory.getLogger("no-armor")

	override fun onInitialize() {

	}
}