package net.michal.tools.commands.admin;

import net.michal.tools.basic.helpers.ChatHelper;
import net.michal.tools.storage.MessageConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderSeeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        if(player.isOp() || player.hasPermission("wiksa.tools.endersee")) {
            if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if(target != null) {
                    player.openInventory(target.getEnderChest());
                    ChatHelper.sendMessage(player, MessageConfiguration.getConfig().getString("messages.endersee.open-target-enderchest").replace("{NAME}", target.getDisplayName()));

                } else {
                    ChatHelper.sendMessage(player, MessageConfiguration.getConfig().getString("errors.player-offline"));
                }
            } else {
                ChatHelper.sendMessage(player, MessageConfiguration.getConfig().getString("messages.endersee.correct-usage"));
            }
        } else {
            ChatHelper.sendMessage(player, MessageConfiguration.getConfig().getString("errors.player-no-permission"));
        }

        return false;
    }
}
