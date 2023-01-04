package io.github.jwelch936.chatplugin;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCookEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 *  Created by Jack Welch on 1/1/2023
 *  Idea: list all player names in alphabetical order in a book for easy readability?
 *  Formatting codes
 *  §0 - Black (normal)
 *  §1 - Dark Blue
 *  §2 - Dark Green
 *  §3 - Dark Cyan (the color of "cyan" wool)
 *  §4 - Dark Red
 *  §5 - Dark Magenta
 *  §6 - Gold
 *  §7 - Light Gray
 *  §8 - Dark Gray
 *  §9 - Purpleish-Grayish-Blueish
 *  §a - Light Green
 *  §b - Cyan (real cyan)
 *  §c - Light Red
 *  §d - Light Magenta
 *  §e - Yellow
 *  §f - White
 *
 * Other stuff:
 *
 * §k - Randomly changing letters
 * §l - Bold
 * §m - Crossed out
 * §n - Underlined
 * §o - Italic (slanted)
 * §r - Normal
 */
public class ChatPlugin extends JavaPlugin implements Listener {

    // This code is called after the server starts and after the /reload command
    @Override //do stuff in here?
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        //ExampleEvent exampleEvent = new ExampleEvent("MrCool936"); // Initialize your Event
        //Bukkit.getPluginManager().callEvent(exampleEvent); // This fires the event and allows any listener to listen to the event
        //Bukkit.getPlayer("MrCool936").sendMessage(exampleEvent.getPlayerName()); // Use your event's data
        getLogger().log(Level.INFO, "{0}.onEnable()", this.getClass().getName());
    }

    // This code is called before the server stops and after the /reload command
    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "{0}.onDisable()", this.getClass().getName());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(event.getPlayer().getName() + " is here!");
        getLogger().log(Level.INFO, "Logged: {0} is here!", event.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        event.setQuitMessage(event.getPlayer().getName() + " is gone.");
        getLogger().log(Level.INFO, "Logged: {0} is gone.", event.getPlayer().getName());
    }

    /**
     * Rename cooked pork to "steamed ham"
     * @param event Event in which furnace smelts an item
     */
    @EventHandler(priority = EventPriority.HIGH)
    public void onSmelt(BlockCookEvent event) {
        ItemStack result = event.getResult();
        if(result == null || result.getType() == Material.AIR) return;
        if(result.getType() == Material.COOKED_PORKCHOP) {
            ItemMeta meta = result.getItemMeta();
            meta.setDisplayName("Steamed Ham");
            result.setItemMeta(meta);
        }
    }
}
