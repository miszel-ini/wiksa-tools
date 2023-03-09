package net.michal.tools;

import net.michal.tools.commands.admin.EnderSeeCommand;
import net.michal.tools.commands.admin.InvSeeCommand;
import net.michal.tools.commands.players.HelpCommand;
import net.michal.tools.commands.players.LinksCommand;
import net.michal.tools.commands.players.PremiumCommand;
import net.michal.tools.storage.MessageConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class WiksaTools extends JavaPlugin {

    static WiksaTools instance;

    @Override
    public void onEnable() {
        instance = this;
        //config setup
        saveDefaultConfig();
        reloadConfig();

        //commands and listeners setup
        registerListeners();
        registerAdminCommands();
        registerPlayersCommands();
        //setup message.yml config
        MessageConfiguration.saveDefaultConfig();
        MessageConfiguration.reloadConfig();

    }
    //registering player commands
    private void registerPlayersCommands() {
        getCommand("pomoc").setExecutor(new HelpCommand());
        getCommand("premium").setExecutor(new PremiumCommand());
        getCommand("linki").setExecutor(new LinksCommand());
    }
    //registering admin commands
    private void registerAdminCommands() {
        getCommand("invsee").setExecutor(new InvSeeCommand());
        getCommand("endersee").setExecutor(new EnderSeeCommand());
    }
    //registering listeners
    private void registerListeners() {}

    public static WiksaTools getInstance() {
        return instance;
    }
}
