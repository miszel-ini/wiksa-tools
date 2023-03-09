package net.michal.tools.commands.admin;

import net.michal.tools.basic.helpers.ChatHelper;
import net.michal.tools.storage.MessageConfiguration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        if(player.isOp() || player.hasPermission("tools.wiksa.heal")) {
            if(player.getHealth() < 20 || player.getFoodLevel() < 20) {
                player.setHealth(20);
                player.setFoodLevel(20);
                ChatHelper.sendMessage(player, MessageConfiguration.getConfig().getString("messages.player-healed"));
            } else {
                return false;
            }
        } else {
            ChatHelper.sendMessage(player, MessageConfiguration.getConfig().getString("errors.player-no-permission"));
        }

        return false;
    }
}
