package wtf.pathos.nonetherite.services;

import org.bukkit.entity.HumanEntity;
import wtf.pathos.nonetherite.config.ConfigManager;

public class MessageService {
    private final ConfigManager configManager;

    public MessageService(ConfigManager configManager) {
        this.configManager = configManager;
    }

    public void sendDisableMessage(HumanEntity player) {
        if (configManager.isMessageEnabled()) {
            player.sendMessage(configManager.getDisableMessage());
        }
    }
}