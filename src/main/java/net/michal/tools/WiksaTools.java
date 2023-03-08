package net.michal.tools;

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
    private void registerPlayersCommands() {}
    //registering admin commands
    private void registerAdminCommands() {}
    //registering listeners
    private void registerListeners() {}

    public static WiksaTools getInstance() {
        return instance;
    }
}
