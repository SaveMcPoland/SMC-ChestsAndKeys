package pl.savemc.chestsandkeys.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public final class ChatUtils {

    private ChatUtils() {}

    public static String colored(String toColor){
        return ChatColor.translateAlternateColorCodes('&', toColor);
    }

    public static List<String> colored(List<String> toColor) {
        return toColor.stream()
                .map(ChatUtils::colored)
                .collect(Collectors.toList());
    }

    public static void sendMessage(Player player, String message){
        player.sendMessage(colored(message));
    }

    public static void sendMessage(CommandSender commandSender, String message){
        commandSender.sendMessage(colored(message));
    }
}
