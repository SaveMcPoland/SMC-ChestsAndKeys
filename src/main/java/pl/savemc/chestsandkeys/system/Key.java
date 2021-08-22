package pl.savemc.chestsandkeys.system;

import org.bukkit.Material;
import pl.savemc.chestsandkeys.utils.ItemBuilder;

public class Key {

    private final RoyalSet owner;
    private ItemBuilder representation;
    private double chance = 0.1D;

    public Key(RoyalSet owner) {
        this.owner = owner;
        this.representation = new ItemBuilder(Material.TRIPWIRE_HOOK);
    }

    public RoyalSet getOwner() {
        return owner;
    }

    public ItemBuilder getRepresentation() {
        return new ItemBuilder(representation.getItem());
    }

    public void setRepresentation(ItemBuilder representation) {
        this.representation = representation;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

}
