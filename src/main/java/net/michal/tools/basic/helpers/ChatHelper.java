package net.michal.tools.basic.helpers;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ChatHelper {

    public static String fixChatColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', text)
                .replace(">>", "")
                .replace("<<", "");
    }

    public static List<String> fixChatColors(List<String> strings) {
        List<String> colors = new ArrayList<>();
        for (String s : strings)
            colors.add(fixChatColor(s));
        return colors;
    }

    public static void sendMessage(Player player, String message) {
        if(player != null) {
            player.sendMessage(fixChatColor(message));
        }
    }

    public static List<String> sendMessages(Player player, List<String> text) {
        for(String message : text) {
            player.sendMessage(
                    fixChatColor(message)
            );
        }
        return text;
    }
}
