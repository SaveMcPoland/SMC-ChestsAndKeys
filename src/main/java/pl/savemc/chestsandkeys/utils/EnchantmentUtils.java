package pl.savemc.chestsandkeys.utils;

import org.bukkit.enchantments.Enchantment;
import panda.std.Option;

public class EnchantmentUtils {

    public static Option<Object> getByName(String name) {
        for (Enchantment enchantment : Enchantment.values()) {
            String key = enchantment.getKey().getKey();

            if (name.equalsIgnoreCase(key)) {
                return Option.of(enchantment);
            }
        }

        return Option.of(Enchantment.getByName(name));
    }

}
