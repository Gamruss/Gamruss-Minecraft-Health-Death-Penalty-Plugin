package spigotplugin.deathpenalty.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;
import org.bukkit.entity.Entity.Spigot;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.checkerframework.checker.units.qual.A;
import org.w3c.dom.Attr;

import java.util.HashMap;

public class hpRenewClick implements Listener {
    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event){
        Player player = event.getPlayer();
        //
        //Stew Of Life
        //
        //If rightclicked with the right item
        if((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
                && player.getInventory().getItemInMainHand().getType() == Material.MUSHROOM_STEW
                && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 100)
        {
            double lives;
            double brLives;
            int amount;
            //Gets player health
            brLives = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            lives = brLives;
            lives = lives + 1;
            //If player is trying to heal over 20 health
            if(lives > 20)
            {
                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Default Max Health Reached");
            }
            //If the next heal will be at 20 health
            else if(lives == 20)
            {
                //Health set
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(lives);
                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Default Max Health Reached");
                //Send message about change of max health
                Bukkit.broadcastMessage(player.getName() + " " + ChatColor.BOLD + "" + ChatColor.RED + brLives + " ❤ → " + lives + " ❤");
                //Play sound
                player.playSound(player.getLocation(), Sound.ENTITY_VEX_DEATH, 1, 1);
                //Remove Item from hand
                amount = player.getInventory().getItemInMainHand().getAmount();
                amount--;
                player.getInventory().getItemInMainHand().setAmount(amount);
                //Give back bowl
                ItemStack bowl = new ItemStack(Material.BOWL,1);
                player.getInventory().addItem(bowl);
            }
            //if player has below 19 health
            else
            {
                //Health set
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(lives);
                //Send message about change of max health
                Bukkit.broadcastMessage(player.getName() + " " + ChatColor.BOLD + "" + ChatColor.RED + brLives + " ❤ → " + lives + " ❤");
                //Play sound
                player.playSound(player.getLocation(), Sound.ENTITY_VEX_AMBIENT, 1, 1);
                //Remove Item from hand
                amount = player.getInventory().getItemInMainHand().getAmount();
                amount--;
                player.getInventory().getItemInMainHand().setAmount(amount);
                //Give back bowl
                ItemStack bowl = new ItemStack(Material.BOWL,1);
                player.getInventory().addItem(bowl);
            }
            //
            //Stew of Immortality
            //
            //If rightclicked with the right item
        } else if ((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
                && player.getInventory().getItemInMainHand().getType() == Material.BEETROOT_SOUP
                && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 100)
        {
            double lives;
            double brLives;
            int amount;
            //Gets player health
            brLives = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            lives = brLives;
            //If you are trying to heal with less than 20 health
            if(lives < 20)
            {
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD +"You can't get health with Stew of Immortality if you don't have atleast 20 health");
            }
            else
            {
                lives = lives + 2;
                if(lives <= 40 && lives >= 20)
                {
                    //Health set
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(lives);
                    //Play sound
                    player.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, 1, 1);
                    //Send message about change of max health
                    Bukkit.broadcastMessage(player.getName() + " " + ChatColor.BOLD + ChatColor.DARK_RED + brLives + " ❤ → " + ChatColor.DARK_RED + lives + " ❤");
                    //Remove item from hand
                    amount = player.getInventory().getItemInMainHand().getAmount();
                    amount--;
                    player.getInventory().getItemInMainHand().setAmount(amount);
                    //Give back bowl
                    ItemStack bowl = new ItemStack(Material.BOWL,1);
                    player.getInventory().addItem(bowl);
                }
                //Max health reached
                else
                {
                    player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Max Boost HP Reached");
                }
            }

        }
        else
        {
            return;
        }
    }
}
