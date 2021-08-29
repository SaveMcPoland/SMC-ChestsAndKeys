package pl.savemc.chestsandkeys.config.composers;

import org.bukkit.enchantments.Enchantment;
import pl.savemc.chestsandkeys.utils.EnchantmentUtils;

public class EnchantmentComposer implements MoreSimpleComposer<Enchantment> {

    @Override
    public Enchantment deserialize(String name) {
        return EnchantmentUtils.getByName(name)
                .orThrow(() -> new IllegalArgumentException("Enchant o nazwie " + name + " nie istnieje! Sprawdź poprawność konfiguracji!"));
    }

    @Override
    public String serialize(Enchantment enchantment) {
        return enchantment.getName();
    }

}
