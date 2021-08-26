package pl.savemc.chestsandkeys.utils;

import org.bukkit.enchantments.Enchantment;
import panda.std.Option;

import java.util.HashMap;
import java.util.Map;

public class EnchantmentUtils {

    public static Option<Enchantment> getByName(String name) {
        for (Enchantment enchantment : Enchantment.values()) {
            String key = enchantment.getKey().getKey();

            if (name.equalsIgnoreCase(key)) {
                return Option.of(enchantment);
            }
        }

        return Option.of(Enchantment.getByName(name));
    }

    public static Map<Enchantment, Integer> deserialize(Map<String, Integer> enchantsToDeserialize) {
        HashMap<Enchantment, Integer> enchants = new HashMap<>();
        enchantsToDeserialize.forEach((ench, level) -> getByName(ench).peek(enchantment -> enchants.put(enchantment, level)));
        return enchants;
    }

}
