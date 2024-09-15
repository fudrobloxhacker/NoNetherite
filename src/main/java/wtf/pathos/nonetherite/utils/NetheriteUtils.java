package wtf.pathos.nonetherite.utils;

import org.bukkit.Material;
import java.util.Arrays;
import java.util.List;

public class NetheriteUtils {
    private static final List<Material> NETHERITE_MATERIALS = Arrays.asList(
            Material.NETHERITE_INGOT,
            Material.NETHERITE_SWORD,
            Material.NETHERITE_PICKAXE,
            Material.NETHERITE_AXE,
            Material.NETHERITE_SHOVEL,
            Material.NETHERITE_HOE,
            Material.NETHERITE_HELMET,
            Material.NETHERITE_CHESTPLATE,
            Material.NETHERITE_LEGGINGS,
            Material.NETHERITE_BOOTS,
            Material.NETHERITE_BLOCK,
            Material.NETHERITE_SCRAP
    );

    public static boolean isNetheriteItem(Material material) {
        return NETHERITE_MATERIALS.contains(material);
    }
}