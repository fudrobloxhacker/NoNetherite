package wtf.pathos.nonetherite.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import wtf.pathos.nonetherite.managers.NetheriteManager;
import wtf.pathos.nonetherite.annotations.EventProcessor;

public class PlayerInteractionListener implements Listener {
    private final NetheriteManager netheriteManager;

    public PlayerInteractionListener(NetheriteManager netheriteManager) {
        this.netheriteManager = netheriteManager;
    }

    @EventHandler
    @EventProcessor(description = "Prevent usage of Netherite items")
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getItem() != null && netheriteManager.isDisabledNetheriteItem(event.getItem())) {
            event.setCancelled(true);
            netheriteManager.removeNetheriteItem(event.getItem());
            netheriteManager.notifyPlayer(event.getPlayer());
        }
    }
}