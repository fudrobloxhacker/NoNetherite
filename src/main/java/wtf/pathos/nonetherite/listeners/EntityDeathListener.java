package wtf.pathos.nonetherite.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import wtf.pathos.nonetherite.managers.NetheriteManager;
import wtf.pathos.nonetherite.annotations.EventProcessor;

public class EntityDeathListener implements Listener {
    private final NetheriteManager netheriteManager;

    public EntityDeathListener(NetheriteManager netheriteManager) {
        this.netheriteManager = netheriteManager;
    }

    @EventHandler
    @EventProcessor(description = "Remove Netherite items on player death")
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (netheriteManager.isRemoveOnDeath()) {
            event.getDrops().removeIf(netheriteManager::isDisabledNetheriteItem);
        }
    }
}