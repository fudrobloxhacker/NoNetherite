package wtf.pathos.nonetherite.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import wtf.pathos.nonetherite.managers.NetheriteManager;
import wtf.pathos.nonetherite.annotations.EventProcessor;

public class BlockPlaceListener implements Listener {
    private final NetheriteManager netheriteManager;

    public BlockPlaceListener(NetheriteManager netheriteManager) {
        this.netheriteManager = netheriteManager;
    }

    @EventHandler
    @EventProcessor(description = "Prevent placement of Netherite blocks")
    public void onBlockPlace(BlockPlaceEvent event) {
        if (netheriteManager.isDisabledNetheriteItem(event.getItemInHand())) {
            event.setCancelled(true);
            netheriteManager.notifyPlayer(event.getPlayer());
        }
    }
}