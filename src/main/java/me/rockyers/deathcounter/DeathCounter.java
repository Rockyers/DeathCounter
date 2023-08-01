package me.rockyers.deathcounter;

import de.leonhard.storage.Json;
import lombok.Getter;
import me.rockyers.deathcounter.listener.OnDeath;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class DeathCounter extends JavaPlugin {
    private final Json saveFile = new Json("deaths.json", getPath());

    @Override
    public void onEnable() {
        new OnDeath(this);
    }

    public String getPath() {
        return getDataFolder().getPath();
    }

    public int getDeaths(Player player) {
        return saveFile.getOrDefault(player.getUniqueId().toString(), 0);
    }
}
