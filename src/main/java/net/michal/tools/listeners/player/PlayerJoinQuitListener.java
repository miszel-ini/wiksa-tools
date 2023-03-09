package net.michal.tools.listeners.player;

import net.michal.tools.basic.helpers.ChatHelper;
import net.michal.tools.storage.MessageConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(" ");
        if(player.hasPlayedBefore()) {
            ChatHelper.sendMessages(player, MessageConfiguration.getConfig().getStringList("messages.join.constant-player"));
        } else {
            ChatHelper.sendMessages(player, MessageConfiguration.getConfig().getStringList("messages.join.new-player"));
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        event.setQuitMessage(
                ChatHelper.fixChatColor(MessageConfiguration.getConfig().getString("messages.quit-player").replace("{NAME}", player.getDisplayName()))
        );
    }
}
