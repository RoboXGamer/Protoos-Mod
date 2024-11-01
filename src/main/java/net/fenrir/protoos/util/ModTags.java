package net.fenrir.protoos.util;

import net.fenrir.protoos.ProtoOS;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = tag("needs_sapphire_tool");
        public static final TagKey<Block> NEEDS_RUBY_TOOL = tag("needs_ruby_tool");
        public static final TagKey<Block> NEEDS_TOPAZ_TOOL = tag("needs_topaz_tool");
        public static final TagKey<Block> NEEDS_EMERALD_TOOL = tag("needs_emerald_tool");
        public static final TagKey<Block> NEEDS_DIAMOND_TOOL = tag("needs_diamond_tool");

        public static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ProtoOS.MOD_ID, name));
        }
    }
}
