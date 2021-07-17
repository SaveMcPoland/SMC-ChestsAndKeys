package pl.savemc.chestsandkeys;

import org.bukkit.plugin.java.JavaPlugin;
import pl.savemc.chestsandkeys.config.ConfigManager;
import pl.savemc.chestsandkeys.utils.ItemManager;

public final class SMCChestsAndKeys extends JavaPlugin {

    private SMCLogger     smcLogger;
    private ConfigManager configManager;
    private ItemManager   itemManager;

    @Override
    public void onEnable() {
        this.smcLogger = new SMCLogger(this);
        this.configManager = new ConfigManager(this);
        this.configManager.loadConfigs();

        this.itemManager = new ItemManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public SMCLogger getSmcLogger() {
        return smcLogger;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
