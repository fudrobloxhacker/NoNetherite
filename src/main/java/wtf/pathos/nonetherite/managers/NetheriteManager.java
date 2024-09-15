package wtf.pathos.nonetherite.managers;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import wtf.pathos.nonetherite.NoNetheritePlugin;
import wtf.pathos.nonetherite.services.MessageService;
import wtf.pathos.nonetherite.models.NetheriteItem;

import java.util.Set;

public class NetheriteManager {
    private final NoNetheritePlugin plugin;
    private final MessageService messageService;
    private final Set<NetheriteItem> disabledItems;

    public NetheriteManager(NoNetheritePlugin plugin, MessageService messageService) {
        this.plugin = plugin;
        this.messageService = messageService;
        this.disabledItems = plugin.getConfigManager().getDisabledItems();
    }

    public boolean isDisabledNetheriteItem(ItemStack item) {
        return item != null && disabledItems.stream()
                .anyMatch(netheriteItem -> netheriteItem.getMaterial() == item.getType());
    }

    public void removeNetheriteItem(ItemStack item) {
        if (isDisabledNetheriteItem(item)) {
            item.setType(Material.AIR);
        }
    }

    public void notifyPlayer(HumanEntity player) {
        messageService.sendDisableMessage(player);
    }

    public boolean isRemoveOnDeath() {
        return plugin.getConfigManager().isRemoveOnDeath();
    }

    public boolean isPreventPlacement() {
        return plugin.getConfigManager().isPreventPlacement();
    }
}