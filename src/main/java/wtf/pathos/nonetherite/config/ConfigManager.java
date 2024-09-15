package wtf.pathos.nonetherite.config;

import org.bukkit.configuration.file.FileConfiguration;
import wtf.pathos.nonetherite.NoNetheritePlugin;
import wtf.pathos.nonetherite.models.NetheriteItem;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ConfigManager {
    private final NoNetheritePlugin plugin;
    private FileConfiguration config;

    public ConfigManager(NoNetheritePlugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    private void loadConfig() {
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
    }

    public String getDisableMessage() {
        return config.getString("disable-message", "Netherite items are not allowed on this server.");
    }

    public boolean isMessageEnabled() {
        return config.getBoolean("enable-disable-message", true);
    }

    public Set<NetheriteItem> getDisabledItems() {
        Set<String> disabledItemNames = new HashSet<>(config.getStringList("disabled-items"));
        return EnumSet.allOf(NetheriteItem.class).stream()
                .filter(item -> disabledItemNames.contains(item.name()))
                .collect(Collectors.toSet());
    }

    public boolean isRemoveOnDeath() {
        return config.getBoolean("remove-on-death", true);
    }

    public boolean isPreventPlacement() {
        return config.getBoolean("prevent-placement", true);
    }
}