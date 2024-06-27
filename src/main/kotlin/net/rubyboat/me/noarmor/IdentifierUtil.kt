package net.rubyboat.me.noarmor

import net.minecraft.util.Identifier

class IdentifierUtil {
    companion object {
        @JvmStatic
        fun of(path: String): Identifier {
            return Identifier.of("no-armor", path);
        }
    }
}