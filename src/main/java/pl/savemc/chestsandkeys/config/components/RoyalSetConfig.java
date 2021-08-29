package pl.savemc.chestsandkeys.config.components;

import net.dzikoysk.cdn.entity.Contextual;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import panda.utilities.collection.Maps;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Contextual
public class RoyalSetConfig implements Serializable {
    public String name = "example";
    public Chest chest = new Chest();
    public Key key = new Key();
    public List<DropItemConfig> drops = Arrays.asList(
            new DropItemConfig(Material.DIAMOND, 8),
            new DropItemConfig(Material.EMERALD, 8),
            new DropItemConfig(Material.GOLDEN_APPLE, 3),
            new DropItemConfig(Material.DIAMOND_SWORD, 0, 1, Maps.of(Enchantment.KNOCKBACK, 1)),
            new DropItemConfig(Material.DIAMOND_SWORD, 0, 1, Maps.of(Enchantment.DAMAGE_ALL, 4, Enchantment.FIRE_ASPECT, 2))
    );

    @Contextual
    public static class Chest implements Serializable {
        public ExtendedItemConfig chestItem = new ExtendedItemConfig(Material.CHEST, 0, "&cChest");
    }

    @Contextual
    public static class Key implements Serializable {
        public double chance = 0.1;
        public ExtendedItemConfig keyItem = new ExtendedItemConfig(Material.TRIPWIRE_HOOK, 0, "&bKey",
                Arrays.asList("&7", "&7Może otwierać skrzynie!", "&7")
        );
    }
}