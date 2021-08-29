package pl.savemc.chestsandkeys.config;

import net.dzikoysk.cdn.Cdn;
import panda.utilities.FileUtils;
import pl.savemc.chestsandkeys.SMCChestsAndKeys;
import pl.savemc.chestsandkeys.SMCLogger;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Config<T extends Serializable> {

    private final SMCChestsAndKeys plugin;
    private final String fileName;
    private final Class<T> tClass;
    private T pluginConfig;

    public Config(SMCChestsAndKeys plugin, Class<T> tClass, String fileName) {
        this.plugin = plugin;
        this.fileName = fileName;
        this.tClass = tClass;

        File file = new File(plugin.getDataFolder(), fileName);
        SMCLogger smcLogger = plugin.getSmcLogger();

        if (file.exists()) {
            loadConfig(file);
            return;
        }

        try {
            if (file.getParentFile().mkdir()) {
                smcLogger.info("File paths have been created.");
            }

            if (!file.createNewFile()) {
                smcLogger.debug("Cannot create of " + fileName);
            }

            loadConfig(file);
            saveConfig();
        }
        catch (IOException ex) {
            smcLogger.error("Cannot create of " + fileName, ex);
        }
    }

    public T getConfig() {
        return pluginConfig;
    }

    public void loadConfig(File file) {
        try {
            Cdn cdn = plugin.getConfigManager().getCdn();
            pluginConfig = cdn.load(file, tClass);
        } catch (Exception ex) {
            plugin.getSmcLogger().error("Cannot load the contents of " + fileName, ex);
        }
    }

    public void saveConfig() {
        try {
            if (pluginConfig == null) {
                plugin.getSmcLogger().error("Cannot save or overwrite the contents of " + fileName + " (Instance config is null)");
                return;
            }
            Cdn cdn = plugin.getConfigManager().getCdn();
            FileUtils.overrideFile(new File(plugin.getDataFolder().getPath(), fileName), cdn.render(pluginConfig));
        } catch (Exception ex) {
            plugin.getSmcLogger().error("Cannot save or overwrite the contents of " + fileName, ex);
        }
    }
}
