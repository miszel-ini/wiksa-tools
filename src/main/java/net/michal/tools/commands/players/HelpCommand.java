package net.michal.tools.commands.players;

import net.michal.tools.basic.helpers.ChatHelper;
import net.michal.tools.storage.MessageConfiguration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        ChatHelper.sendMessages(player, MessageConfiguration.getConfig().getStringList("messages.help"));

        return false;
    }
}
