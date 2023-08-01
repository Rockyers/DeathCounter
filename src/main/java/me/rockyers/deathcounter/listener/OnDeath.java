package me.rockyers.deathcounter.listener;

import me.rockyers.deathcounter.DeathCounter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeath implements Listener {
    private final DeathCounter plugin;
    public OnDeath(DeathCounter plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent ev) {
        Player p = ev.getEntity();
        plugin.getSaveFile().set(p.getUniqueId().toString(), plugin.getDeaths(p) + 1);
    }
}
