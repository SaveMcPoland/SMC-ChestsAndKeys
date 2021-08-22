package pl.savemc.chestsandkeys.config.components;

import net.dzikoysk.cdn.entity.Contextual;
import org.bukkit.Material;

import java.io.Serializable;

@Contextual
public abstract class ItemConfig implements Serializable {
    public Material material;
    public int data;

    public ItemConfig(Material material, int data) {
        this.material = material;
        this.data = data;
    }

    public ItemConfig(Material material) {
        this.material = material;
        this.data = 0;
    }
}