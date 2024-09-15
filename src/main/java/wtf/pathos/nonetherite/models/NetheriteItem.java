package wtf.pathos.nonetherite.models;

import org.bukkit.Material;

public enum NetheriteItem {
    NETHERITE_INGOT(Material.NETHERITE_INGOT),
    NETHERITE_SWORD(Material.NETHERITE_SWORD),
    NETHERITE_PICKAXE(Material.NETHERITE_PICKAXE),
    NETHERITE_AXE(Material.NETHERITE_AXE),
    NETHERITE_SHOVEL(Material.NETHERITE_SHOVEL),
    NETHERITE_HOE(Material.NETHERITE_HOE),
    NETHERITE_HELMET(Material.NETHERITE_HELMET),
    NETHERITE_CHESTPLATE(Material.NETHERITE_CHESTPLATE),
    NETHERITE_LEGGINGS(Material.NETHERITE_LEGGINGS),
    NETHERITE_BOOTS(Material.NETHERITE_BOOTS),
    NETHERITE_BLOCK(Material.NETHERITE_BLOCK),
    NETHERITE_SCRAP(Material.NETHERITE_SCRAP);

    private final Material material;

    NetheriteItem(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }
}