package net.michal.tools.commands.players;

import net.michal.tools.basic.helpers.ChatHelper;
import net.michal.tools.storage.MessageConfiguration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PremiumCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        ChatHelper.sendMessage(player, MessageConfiguration.getConfig().getString("messages.premium"));
        return false;
    }
}
