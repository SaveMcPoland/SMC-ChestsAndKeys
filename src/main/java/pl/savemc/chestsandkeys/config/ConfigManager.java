package pl.savemc.chestsandkeys.config;

import net.dzikoysk.cdn.Cdn;
import net.dzikoysk.cdn.CdnFactory;
import org.bukkit.enchantments.Enchantment;
import pl.savemc.chestsandkeys.SMCChestsAndKeys;
import pl.savemc.chestsandkeys.SMCLogger;
import pl.savemc.chestsandkeys.config.composers.EnchantmentComposer;

public class ConfigManager {

    private final SMCChestsAndKeys plugin;
    private final Cdn cdn = CdnFactory
            .createYamlLike()
            .getSettings()
            .withComposer(Enchantment.class, new EnchantmentComposer())
            .build();

    private Config<PluginConfig> pluginConfig;
    private Config<ChestConfig> chestConfig;

    public ConfigManager(SMCChestsAndKeys plugin) {
        this.plugin = plugin;
    }

    public void loadConfigs() {
        this.pluginConfig = new Config<>(plugin, PluginConfig.class, "config.yml");
        this.chestConfig = new Config<>(plugin, ChestConfig.class, "chests.yml");
    }

    public void saveConfigs() {
        SMCLogger logger = plugin.getSmcLogger();

        try {
            this.pluginConfig.saveConfig();
        } catch (Exception exception) {
            logger.error("Configuration save error", exception);
        } catch (NoClassDefFoundError exception) {
            logger.error(" ");
            logger.error("----------------------------------------------------------------------------------------");
            logger.error(" THIS IS NOT A BUG OR BUG! PLUGIN HAS BEEN POSSIBLY DISABLED BY AN INCORRECT WAY! ");
            logger.error("----------------------------------------------------------------------------------------");
            logger.error("Configuration save error", exception);
            logger.error("----------------------------------------------------------------------------------------");
            logger.error(" TO NIE JEST BLAD LUB BUG! PLUGIN ZOSTAL PRAWDOPODOBNIE WYLACZONY W NIEPOPRAWNY SPOSOB! ");
            logger.error("----------------------------------------------------------------------------------------");
            logger.error(" ");
        }
    }

    public Cdn getCdn() {
        return cdn;
    }

    public PluginConfig getPluginConfig() {
        return pluginConfig.getConfig();
    }

    public ChestConfig getChestConfig() {
        return chestConfig.getConfig();
    }

}
