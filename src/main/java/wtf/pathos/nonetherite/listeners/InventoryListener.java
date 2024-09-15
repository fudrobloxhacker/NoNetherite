package wtf.pathos.nonetherite.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import wtf.pathos.nonetherite.managers.NetheriteManager;
import wtf.pathos.nonetherite.annotations.EventProcessor;

public class InventoryListener implements Listener {
    private final NetheriteManager netheriteManager;

    public InventoryListener(NetheriteManager netheriteManager) {
        this.netheriteManager = netheriteManager;
    }

    @EventHandler
    @EventProcessor(description = "Prevent inventory interactions with Netherite items")
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getCurrentItem() != null && netheriteManager.isDisabledNetheriteItem(event.getCurrentItem())) {
            event.setCancelled(true);
            netheriteManager.removeNetheriteItem(event.getCurrentItem());
            netheriteManager.notifyPlayer(event.getWhoClicked());
        }
    }

    @EventHandler
    @EventProcessor(description = "Prevent inventory dragging of Netherite items")
    public void onInventoryDrag(InventoryDragEvent event) {
        event.getNewItems().values().forEach(item -> {
            if (netheriteManager.isDisabledNetheriteItem(item)) {
                event.setCancelled(true);
                netheriteManager.notifyPlayer(event.getWhoClicked());
            }
        });
    }
}