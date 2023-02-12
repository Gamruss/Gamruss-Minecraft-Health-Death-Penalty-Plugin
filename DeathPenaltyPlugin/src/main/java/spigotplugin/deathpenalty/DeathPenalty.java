package spigotplugin.deathpenalty;

import org.bukkit.plugin.java.JavaPlugin;
import spigotplugin.deathpenalty.Listeners.PlayerListener;
import spigotplugin.deathpenalty.Listeners.hpRenewClick;
import spigotplugin.deathpenalty.Listeners.hpCraftings;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathPenalty extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        hpCraftings crafting = new hpCraftings();
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new hpRenewClick(), this);
        crafting.recipes();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
