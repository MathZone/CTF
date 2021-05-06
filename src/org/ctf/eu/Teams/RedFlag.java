package org.ctf.eu.Teams;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

public class RedFlag {
    public static ItemStack makeRedFlag(){
        ItemStack itemStack = new ItemStack(Material.RED_BANNER);
        BannerMeta bannerMeta = (BannerMeta) itemStack.getItemMeta();
        bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.CIRCLE_MIDDLE));
        itemStack.setItemMeta(bannerMeta);
        return itemStack;
    }
}
