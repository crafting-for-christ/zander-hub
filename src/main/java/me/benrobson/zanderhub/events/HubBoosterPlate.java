package me.benrobson.zanderhub.events;

import me.benrobson.zanderhub.ZanderHubMain;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class HubBoosterPlate implements Listener {
    ZanderHubMain plugin;
    public HubBoosterPlate(ZanderHubMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void HubBoosterPlate(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        Location pplatelocation = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());

        if (pplatelocation.getBlock().getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE) {
            player.setVelocity(player.getLocation().getDirection().multiply(plugin.getConfig().getInt("velocitymultiplier")));
            player.setVelocity(new Vector(player.getVelocity().getX(), 1.0D, player.getVelocity().getZ()));
        }
    }
}