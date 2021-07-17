package pl.savemc.chestsandkeys.config;

import net.dzikoysk.cdn.Cdn;
import net.dzikoysk.cdn.CdnFactory;
import org.panda_lang.utilities.commons.FileUtils;
import pl.savemc.chestsandkeys.SMCChestsAndKeys;
import pl.savemc.chestsandkeys.SMCLogger;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Config<T extends Serializable> {

    private final Cdn cdn = CdnFactory.createYamlLike();
    private final SMCChestsAndKeys plugin;
    private final String fileName;
    private final Class<T> tClass;
    private T pluginConfig;

    public Config(SMCChestsAndKeys plugin, Class<T> tClass, String fileName) {
        this.plugin = plugin;
        this.fileName = fileName;
        this.tClass = tClass;
        loadConfigFile();
    }

    public T getConfig() {
        return pluginConfig;
    }

    public void loadConfigFile() {
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
                smcLogger.warn("Cannot create of " + fileName);
            }

            loadConfig(file);
            saveConfig();
        }
        catch (IOException ex) {
            smcLogger.error("Cannot create of " + fileName, ex);
        }
    }

    public void loadConfig(File file) {
        try {
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

            FileUtils.overrideFile(new File(plugin.getDataFolder().getPath(), fileName), cdn.render(pluginConfig));
        } catch (Exception ex) {
            plugin.getSmcLogger().error("Cannot save or overwrite the contents of " + fileName, ex);
        }
    }
}
