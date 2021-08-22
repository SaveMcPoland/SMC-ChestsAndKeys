package pl.savemc.chestsandkeys.system;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoyalSet {

    private final String name;
    private final Chest chest;
    private final Key key;
    private final List<ItemStack> drops = new ArrayList<>();

    public RoyalSet(String name) {
        this.name = name;
        this.chest = new Chest(this);
        this.key = new Key(this);
    }

    public String getName() {
        return name;
    }

    public Chest getChest() {
        return chest;
    }

    public Key getKey() {
        return key;
    }

    public List<ItemStack> getDrops() {
        return Collections.unmodifiableList(drops);
    }

    public void addDrop(ItemStack item) {
        this.drops.add(item.clone());
    }

}
