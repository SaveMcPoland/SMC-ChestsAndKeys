package pl.savemc.chestsandkeys;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import panda.std.stream.PandaStream;
import pl.savemc.chestsandkeys.config.ConfigManager;
import pl.savemc.chestsandkeys.listeners.KeysDropping;
import pl.savemc.chestsandkeys.system.RoyalSetsManager;

public final class SMCChestsAndKeys extends JavaPlugin {

    private SMCLogger     smcLogger;
    private ConfigManager configManager;
    private RoyalSetsManager royalSetsManager;

    @Override
    public void onEnable() {
        this.smcLogger = new SMCLogger(this);
        this.configManager = new ConfigManager(this);
        this.configManager.loadConfigs();
        this.royalSetsManager = new RoyalSetsManager();

        PluginManager pluginManager = Bukkit.getPluginManager();
        PandaStream.of(
                new KeysDropping(this)
        ).forEach(listener -> pluginManager.registerEvents(listener, this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public SMCLogger getSmcLogger() {
        return smcLogger;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public RoyalSetsManager getRoyalSetsManager() {
        return royalSetsManager;
    }
}
