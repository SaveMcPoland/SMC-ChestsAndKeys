package pl.savemc.chestsandkeys;

import org.bukkit.Bukkit;
import org.bukkit.Server;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

    public void error(String content) {
        rootLogger.severe(content);
    }

    public void error(String content, Throwable cause) {
        String loadedPlugins = Arrays.stream(Bukkit.getPluginManager().getPlugins())
                .filter(plugin -> !plugin.getName().contains("SMC-Dzialki"))
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
        error("  SMC-Dzialki: " + this.plugin.getDescription().getVersion());
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
