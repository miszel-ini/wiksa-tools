package net.michal.tools.commands.admin;

import net.michal.tools.basic.helpers.ChatHelper;
import net.michal.tools.storage.MessageConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvSeeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        if(player.isOp() || player.hasPermission("wiksa.tools.invsee")) {
            if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if(target != null) {
                    player.openInventory(target.getInventory());
                    ChatHelper.sendMessage(player, MessageConfiguration.getConfig().getString("messages.invsee.open-target-inventory").replace("{NAME}", target.getDisplayName()));

                } else {
                    ChatHelper.sendMessage(player, MessageConfiguration.getConfig().getString("errors.player-offline"));
                }
            } else {
                ChatHelper.sendMessage(player, MessageConfiguration.getConfig().getString("messages.invsee.correct-usage"));
            }
        } else {
            ChatHelper.sendMessage(player, MessageConfiguration.getConfig().getString("errors.player-no-permission"));
        }

        return false;
    }
}
