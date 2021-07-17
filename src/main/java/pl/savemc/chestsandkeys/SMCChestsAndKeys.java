package pl.savemc.chestsandkeys;

import org.bukkit.plugin.java.JavaPlugin;
import pl.savemc.chestsandkeys.Utils.ItemManager;

public final class SMCChestsAndKeys extends JavaPlugin {

    private ItemManager             itemManager;


    @Override
    public void onEnable() {
        this.itemManager = new ItemManager();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ItemManager getItemManager() {
        return itemManager;
    }
}
