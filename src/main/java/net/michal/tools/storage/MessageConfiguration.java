package net.michal.tools.storage;

import net.michal.tools.WiksaTools;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

public class MessageConfiguration {

    private static WiksaTools instance = WiksaTools.getInstance();

    private static FileConfiguration msgConfig = null;
    private static File msgConfigFile = null;

    public static void reloadConfig() {
        if (msgConfigFile == null)
            msgConfigFile = new File(instance.getDataFolder(), "messages.yml");
        msgConfig = (FileConfiguration) YamlConfiguration.loadConfiguration(msgConfigFile);
        InputStream defConfigStream = instance.getResource("messages.yml");
        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            msgConfig.setDefaults((Configuration)defConfig);
        }
    }

    public static FileConfiguration getConfig() {
        if (msgConfig == null)
            reloadConfig();
        return msgConfig;
    }

    public static void saveConfig() {
        if (msgConfig == null || msgConfigFile == null)
            return;
        try {
            getConfig().save(msgConfigFile);
        } catch (IOException ex) {
            Bukkit.getLogger().log(Level.SEVERE, "[CONFIGURATION] - Blad w zapisywaniu pliku:  " + msgConfigFile, ex);
        }
    }

    public static void saveDefaultConfig() {
        if (msgConfigFile == null)
            msgConfigFile = new File(instance.getDataFolder(), "messages.yml");
        if (!msgConfigFile.exists())
            instance.saveResource("messages.yml", false);
    }
}
