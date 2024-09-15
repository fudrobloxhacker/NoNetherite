package wtf.pathos.nonetherite.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import wtf.pathos.nonetherite.managers.NetheriteManager;
import wtf.pathos.nonetherite.annotations.EventProcessor;

public class CraftingListener implements Listener {
    private final NetheriteManager netheriteManager;

    public CraftingListener(NetheriteManager netheriteManager) {
        this.netheriteManager = netheriteManager;
    }

    @EventHandler
    @EventProcessor(description = "Prevent crafting of Netherite items")
    public void onCraftItem(CraftItemEvent event) {
        ItemStack result = event.getRecipe().getResult();
        if (netheriteManager.isDisabledNetheriteItem(result)) {
            event.setCancelled(true);
            netheriteManager.notifyPlayer(event.getWhoClicked());
        }
    }
}