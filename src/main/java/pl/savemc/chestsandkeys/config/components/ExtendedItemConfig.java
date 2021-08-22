package pl.savemc.chestsandkeys.config.components;

import net.dzikoysk.cdn.entity.Contextual;
import org.bukkit.Material;

import java.util.Collections;
import java.util.List;

@Contextual
public class ExtendedItemConfig extends ItemConfig {
    public String name;
    public List<String> lore;

    public ExtendedItemConfig(Material material, int data, String name, List<String> lore) {
        super(material, data);
        this.name = name;
        this.lore = lore;
    }

    public ExtendedItemConfig(Material material, int data, String name) {
        super(material, data);
        this.name = name;
        this.lore = Collections.emptyList();
    }
}
