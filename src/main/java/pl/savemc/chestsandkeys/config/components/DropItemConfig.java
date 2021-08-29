package pl.savemc.chestsandkeys.config.components;

import net.dzikoysk.cdn.entity.Contextual;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

import java.util.Collections;
import java.util.Map;

@Contextual
public class DropItemConfig extends ItemConfig {
    public int amount;
    public Map<Enchantment, Integer> enchants;

    public DropItemConfig(Material material, int data, int amount, Map<Enchantment, Integer> enchants) {
        super(material, data);
        this.amount = amount;
        this.enchants = enchants;
    }

    public DropItemConfig(Material material, int data, int amount) {
        super(material, data);
        this.amount = amount;
        this.enchants = Collections.emptyMap();
    }

    public DropItemConfig(Material material, int amount) {
        super(material);
        this.amount = amount;
        this.enchants = Collections.emptyMap();
    }

    public DropItemConfig(Material material) {
        super(material);
        this.amount = 1;
        this.enchants = Collections.emptyMap();
    }
}
