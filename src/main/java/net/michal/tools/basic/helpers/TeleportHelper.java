package net.michal.tools.basic.helpers;

import net.michal.tools.WiksaTools;
import net.michal.tools.storage.MessageConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TeleportHelper {
    public static void teleport(final Player player, final Location location, int seconds){
        final Location ploc = player.getLocation();
        if(player.hasPermission("admin")){
            ChatHelper.sendMessage(player, MessageConfiguration.getConfig().getString("teleport.admin-teleport"));
            player.teleport(location);
            return;
        }
        ChatHelper.sendMessage(player, MessageConfiguration.getConfig().getString("teleport.actually-teleporting").replace("{TIME}", String.valueOf(seconds)));
        Bukkit.getServer().getScheduler().runTaskLater(WiksaTools.getInstance(), () -> {
            if(!player.isOnline()) return;
            if(ploc.distance(player.getLocation()) > 1){
                ChatHelper.sendMessage(player, MessageConfiguration.getConfig().getString("teleport.stop-teleporting"));
                return;
            }
            player.teleport(location);
        }, 20L * seconds);
    }

}
