package net.fenrir.protoos.item;

import net.fenrir.protoos.ProtoOS;
import net.fenrir.protoos.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 0, 25f, 5f, 255,
                    ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.SAPPHIRE.get())),
            new ResourceLocation(ProtoOS.MOD_ID, "sapphire"), List.of(Tiers.NETHERITE), List.of());
    public static final Tier RUBY = TierSortingRegistry.registerTier(
            new ForgeTier(5, 0, 25f, 5f, 255,
                    ModTags.Blocks.NEEDS_RUBY_TOOL, () -> Ingredient.of(ModItems.RUBY.get())),
            new ResourceLocation(ProtoOS.MOD_ID, "ruby"), List.of(Tiers.NETHERITE), List.of());
    public static final Tier TOPAZ = TierSortingRegistry.registerTier(
            new ForgeTier(5,0,25f,5f,255,
                    ModTags.Blocks.NEEDS_TOPAZ_TOOL, () -> Ingredient.of(ModItems.TOPAZ.get())),
            new ResourceLocation(ProtoOS.MOD_ID, "topaz"), List.of(Tiers.NETHERITE), List.of());
}
