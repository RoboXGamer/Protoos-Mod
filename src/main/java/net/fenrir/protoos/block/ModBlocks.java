package net.fenrir.protoos.block;

import net.fenrir.protoos.ProtoOS;
import net.fenrir.protoos.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ProtoOS.MOD_ID);

    public static final RegistryObject<Block> SAPPHIRE_GLASS_BLOCK = registerBlock("sapphire_glass_block",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion().explosionResistance(10000f)));
    public static final RegistryObject<Block> RUBY_GLASS_BLOCK = registerBlock("ruby_glass_block",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion().explosionResistance(100000f)));
    public static final RegistryObject<Block> TOPAZ_GLASS_BLOCK = registerBlock("topaz_glass_block",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion().explosionResistance(100000f)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
