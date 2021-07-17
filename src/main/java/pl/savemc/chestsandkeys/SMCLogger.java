package pl.savemc.chestsandkeys;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import pl.savemc.chestsandkeys.config.ConfigManager;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author FunnyGuildsTeam
 * @see <a href="https://github.com/FunnyGuilds/FunnyGuilds/blob/master/plugin/src/main/java/net/dzikoysk/funnyguilds/FunnyGuildsLogger.java">FunnyGuildsLogger.java</a>
 */

public class SMCLogger {

    private final SMCChestsAndKeys plugin;
    private final Logger rootLogger;

    SMCLogger(SMCChestsAndKeys plugin) {
        this.plugin = plugin;
        this.rootLogger = plugin.getLogger();
    }

    public void info(String content) {
        rootLogger.info(content);
    }

    public void warn(String content) {
        rootLogger.warning(content);
    }

    public void debug(String content) {
        ConfigManager manager = plugin.getConfigManager();

        if (manager != null && manager.getPluginConfig() != null && !manager.getPluginConfig().debugConsole) {
            return;
        }

        this.rootLogger.info("[Debug] > " + content);
    }

    public void debug(String content, Throwable cause) {
        ConfigManager manager = plugin.getConfigManager();

        if (manager != null && manager.getPluginConfig() != null && !manager.getPluginConfig().debugConsole) {
            return;
        }

        String loadedPlugins = Arrays.stream(Bukkit.getPluginManager().getPlugins())
                .filter(plugin -> !plugin.getName().contains(this.plugin.getName()))
                .map(plugin -> plugin.getName() + " " + plugin.getDescription().getVersion())
                .collect(Collectors.joining(", "));

        if (loadedPlugins.length() == 0) {
            loadedPlugins = "none";
        }

        debug("");
        debug(content);
        debug("");
        debug(cause.toString());

        for (StackTraceElement element : cause.getStackTrace()) {
            debug("       at " + element.toString());
        }

        debug("");
        debug("Server Information:");
        debug("  " + this.plugin.getName() + ": " + this.plugin.getDescription().getVersion());
        debug("  Bukkit: " + Bukkit.getBukkitVersion());
        debug("  Java: " + System.getProperty("java.version"));
        debug("  Thread: " + Thread.currentThread());
        debug("  Loaded plugins: " + loadedPlugins);
        debug("  Reload count: " + getReloadCount());
        debug("");
    }

    public void error(String content) {
        rootLogger.severe(content);
    }

    public void error(String content, Throwable cause) {
        String loadedPlugins = Arrays.stream(Bukkit.getPluginManager().getPlugins())
                .filter(plugin -> !plugin.getName().contains(this.plugin.getName()))
                .map(plugin -> plugin.getName() + " " + plugin.getDescription().getVersion())
                .collect(Collectors.joining(", "));

        if (loadedPlugins.length() == 0) {
            loadedPlugins = "none";
        }

        error("");
        error(content);
        error("");
        error(cause.toString());

        for (StackTraceElement element : cause.getStackTrace()) {
            error("       at " + element.toString());
        }

        error("");
        error("Server Information:");
        error("  " + this.plugin.getName() + ": " + this.plugin.getDescription().getVersion());
        error("  Bukkit: " + Bukkit.getBukkitVersion());
        error("  Java: " + System.getProperty("java.version"));
        error("  Thread: " + Thread.currentThread());
        error("  Reload count: " + getReloadCount());
        error("  Loaded plugins: " + loadedPlugins);
        error("");
    }

    public static int getReloadCount() {
        Server server = Bukkit.getServer();

        try {
            final Field reloadCountField = server.getClass().getDeclaredField("reloadCount");
            return reloadCountField.getInt(server);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return -1;
        }
    }

}
