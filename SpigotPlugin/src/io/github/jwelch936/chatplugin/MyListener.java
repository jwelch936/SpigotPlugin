package io.github.jwelch936.chatplugin;

import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyListener implements Listener {

    Logger logger;

    public MyListener(Logger logger) {
        this.logger = logger;
    }

    /*
    @EventHandler
    public void onExampleEvent(ExampleEvent event) {
        // Handle implementation here
    }
    */

}
