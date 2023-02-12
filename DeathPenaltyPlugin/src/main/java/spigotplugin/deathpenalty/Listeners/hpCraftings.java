package spigotplugin.deathpenalty.Listeners;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.*;


public class hpCraftings implements Listener {


    public void recipes() {
        //Craftings
        //Stew of Life
        ItemStack hpRenew = new ItemStack(Material.MUSHROOM_STEW, 2);
        ItemMeta hpRenewMeta = hpRenew.getItemMeta();
        hpRenewMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Stew Of Life");
        hpRenewMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
        //This number is for veryfing if it's the right item to heal in hpRenewClick
        hpRenewMeta.setCustomModelData(100);
        hpRenew.setItemMeta(hpRenewMeta);

        //Recipe
        ShapelessRecipe recipeHPrenew = new ShapelessRecipe(new NamespacedKey("1", "life"), hpRenew);
        //Crafting of Stew of life
        //Change if needed
        //Customizable
        recipeHPrenew.addIngredient(Material.BLAZE_ROD);
        recipeHPrenew.addIngredient(Material.SPORE_BLOSSOM);
        recipeHPrenew.addIngredient(Material.AMETHYST_CLUSTER);
        recipeHPrenew.addIngredient(Material.DEAD_BUSH);
        recipeHPrenew.addIngredient(Material.END_CRYSTAL);
        recipeHPrenew.addIngredient(Material.BLUE_ORCHID);
        recipeHPrenew.addIngredient(Material.DIAMOND_BLOCK);
        recipeHPrenew.addIngredient(Material.BOWL);
        recipeHPrenew.addIngredient(Material.NETHERITE_SCRAP);

        Bukkit.addRecipe(recipeHPrenew);

        //Stew of Immortality
        ItemStack hpBoost = new ItemStack(Material.BEETROOT_SOUP, 1);
        ItemMeta hpBoostMeta = hpBoost.getItemMeta();
        hpBoostMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Stew Of Immortality");
        hpBoostMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
        //This number is for veryfing if it's the right item to heal in hpRenewClick
        hpBoostMeta.setCustomModelData(100);
        hpBoost.setItemMeta(hpBoostMeta);

        //Recipe
        ShapedRecipe recipeHpBoost = new ShapedRecipe(new NamespacedKey("2", "lifeboost"),hpBoost);
        //Crafting of Stew of Immortality
        //Change if needed
        //ABC is the first line of the crafting from top DEF is the middle part etc.
        //Customizable
        recipeHpBoost.shape("ABC", "DEF", "GHI");
        recipeHpBoost.setIngredient('A', Material.ECHO_SHARD);
        recipeHpBoost.setIngredient('B', Material.POISONOUS_POTATO);
        recipeHpBoost.setIngredient('C', Material.ECHO_SHARD);
        recipeHpBoost.setIngredient('D', Material.DIAMOND_BLOCK);
        recipeHpBoost.setIngredient('E', Material.NETHERITE_BLOCK);
        recipeHpBoost.setIngredient('F', Material.DIAMOND_BLOCK);
        recipeHpBoost.setIngredient('G', Material.DIAMOND_BLOCK);
        recipeHpBoost.setIngredient('H', new RecipeChoice.ExactChoice(hpRenew));
        recipeHpBoost.setIngredient('I', Material.DIAMOND_BLOCK);

        Bukkit.addRecipe(recipeHpBoost);
    }
}
