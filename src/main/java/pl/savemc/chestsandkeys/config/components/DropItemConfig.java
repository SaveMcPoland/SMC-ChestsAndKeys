package pl.savemc.chestsandkeys.config.components;

import net.dzikoysk.cdn.entity.Contextual;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import panda.std.Pair;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Contextual
public class DropItemConfig extends ItemConfig {
    public int amount;
    public Map<String, Integer> enchants;

    public DropItemConfig(Material material, int data, int amount, Map<Enchantment, Integer> enchants) {
        super(material, data);
        this.amount = amount;
        this.enchants = enchants.entrySet().stream()
                .map(entry -> Pair.of(entry.getKey().getKey().getKey(), entry.getValue()))
                .collect(Collectors.toMap(Pair::getFirst, Pair::getSecond));
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
