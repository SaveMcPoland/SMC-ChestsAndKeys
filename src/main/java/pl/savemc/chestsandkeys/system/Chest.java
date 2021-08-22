package pl.savemc.chestsandkeys.system;

import org.bukkit.Material;
import pl.savemc.chestsandkeys.utils.ItemBuilder;

public class Chest {

    private final RoyalSet owner;
    private ItemBuilder representation;

    public Chest(RoyalSet owner) {
        this.owner = owner;
        this.representation = new ItemBuilder(Material.CHEST);
    }

    public RoyalSet getOwner() {
        return owner;
    }

    public ItemBuilder getRepresentation() {
        return representation;
    }

    public void setRepresentation(ItemBuilder representation) {
        this.representation = representation;
    }
}
