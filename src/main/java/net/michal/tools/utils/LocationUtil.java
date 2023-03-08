package net.michal.tools.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class LocationUtil {

    public static void teleportRandom(Player player){
        boolean udane = false;
        while(!udane){
            Location loc = getValidRandomCords();
            if(loc.getBlock().getBiome() != Biome.DEEP_OCEAN && loc.getBlock().getBiome() != Biome.OCEAN){
                player.teleport(loc);
                udane = true;
            }
        }

    }

    public void teleportRandom(Location location){
        boolean udane = false;
        while(!udane){
            Location loc = getValidRandomCords();
            if(loc.getBlock().getBiome() != Biome.DEEP_OCEAN && loc.getBlock().getBiome() != Biome.OCEAN){
                //	player.teleport(loc);
                udane = true;
            }
        }

    }

    public static List<Player> getPlayersInRadius(Location location, int size) {
        List<Player> players = new ArrayList<Player>();

        for (Player p : location.getWorld().getPlayers()) {
            if (location.distance(p.getLocation()) <= size) {
                players.add(p);
            }
        }

        return players;
    }

    public static Location getRandomCords() {
        Location loc = new Location(Bukkit.getWorlds().get(0), RandomUtil.getRandInt(-3000, 3000), 0, RandomUtil.getRandInt(-3000, 3000));
        return loc;
    }

    public static Location getValidRandomCords() {
        Boolean invalid = true;
        while(invalid){
            Location loc = getRandomCords();
            loc.setY(loc.getWorld().getHighestBlockAt(loc).getLocation().getY() + 2);

        }

        return null;
    }
}
