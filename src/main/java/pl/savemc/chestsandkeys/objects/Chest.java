package pl.savemc.chestsandkeys.objects;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pl.savemc.chestsandkeys.utils.ItemBuilder;

import java.util.ArrayList;
import java.util.List;

public class Chest {

    private ItemBuilder chest;
    private String name;
    private List<String> lore;
    private List<ItemStack> drops;

    public Chest(String name, List<String> lore){
        this.chest = new ItemBuilder(Material.CHEST);
        drops = new ArrayList<>();
        lore = new ArrayList<>();
        this.name = name;
        this.lore = lore;
        chest.setName(name, true);
        chest.setLore(lore);
    }

    public void setDrops(List<ItemStack> drops) {
        this.drops = drops;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<String> getLore() {
        return lore;
    }

    public String getName() {
        return name;
    }

    public List<ItemStack> getDrops() {
        return drops;
    }

    public ItemStack getItem(){
        return chest.getItem();
    }
}
