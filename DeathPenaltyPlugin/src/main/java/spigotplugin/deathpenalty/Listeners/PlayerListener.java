package spigotplugin.deathpenalty.Listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.attribute.*;
import org.bukkit.entity.Ghast;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.entity.Ghast;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.Listener;
import org.bukkit.entity.Entity.Spigot;
import java.util.Map;
import java.util.HashMap;


public class PlayerListener implements Listener {
    //Customization
    //How much health to remove per death
    private int deathPenalty = 2;
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        //Get Player entity
        Player player = (Player)e.getEntity().getPlayer();
        //Play Sound
        player.playSound(player.getLocation(), Sound.BLOCK_SCULK_SHRIEKER_SHRIEK, 1, 1);
        //Players health variable
        double brLives = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        double lives = brLives;
        //Deal deathPenalty
        lives = lives - deathPenalty;
        //If player's health is above 1
        if(lives > 1) {
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(lives);
            Bukkit.broadcastMessage(player.getName() +" "+ ChatColor.BOLD + ChatColor.RED + brLives + " ❤ → " + lives + " ❤");
        }
        //If player's health is lower after death penalty left him with 1 heart
        else if(lives < 1)
        {
            lives = 1;
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(lives);
            Bukkit.broadcastMessage(player.getName() +" "+ ChatColor.BOLD + ChatColor.RED + brLives + " ❤ → " + lives + " ❤");
        }
    }
}
