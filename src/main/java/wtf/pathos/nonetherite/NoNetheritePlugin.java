package wtf.pathos.nonetherite;

import org.bukkit.plugin.java.JavaPlugin;
import wtf.pathos.nonetherite.config.ConfigManager;
import wtf.pathos.nonetherite.listeners.*;
import wtf.pathos.nonetherite.managers.NetheriteManager;
import wtf.pathos.nonetherite.services.MessageService;

public class NoNetheritePlugin extends JavaPlugin {
    private ConfigManager configManager;
    private NetheriteManager netheriteManager;
    private MessageService messageService;

    @Override
    public void onEnable() {
        configManager = new ConfigManager(this);
        messageService = new MessageService(configManager);
        netheriteManager = new NetheriteManager(this, messageService);

        registerListeners();

        getLogger().info("NoNetherite plugin has been enabled!");
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new CraftingListener(netheriteManager), this);
        getServer().getPluginManager().registerEvents(new InventoryListener(netheriteManager), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractionListener(netheriteManager), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(netheriteManager), this);
        getServer().getPluginManager().registerEvents(new EntityDeathListener(netheriteManager), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("NoNetherite plugin has been disabled!");
    }

    public NetheriteManager getNetheriteManager() {
        return netheriteManager;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public MessageService getMessageService() {
        return messageService;
    }
}