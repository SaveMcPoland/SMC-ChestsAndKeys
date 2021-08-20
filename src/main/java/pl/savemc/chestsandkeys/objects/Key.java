package pl.savemc.chestsandkeys.objects;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pl.savemc.chestsandkeys.utils.ItemBuilder;

import java.util.ArrayList;
import java.util.List;

public class Key {

    private ItemBuilder key;
    private String name;
    private List<String> lore;

    public Key(String name, List<String> lore){
        this.key = new ItemBuilder(Material.TRIPWIRE_HOOK);
        lore = new ArrayList<>();
        this.name = name;
        this.lore = lore;
        key.setName(name, true);
        key.setLore(lore);
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

    public ItemStack getItem(){
        return key.getItem();
    }
}
