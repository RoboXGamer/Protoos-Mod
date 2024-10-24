package net.fenrir.protoos.block;

import net.fenrir.protoos.ProtoOS;
import net.fenrir.protoos.block.custom.EnchantingBench.EnchantingBench;
import net.fenrir.protoos.block.custom.Gemstone_Chest.GemstoneChest;
import net.fenrir.protoos.block.custom.Simple_Item_And_Block_Creation_Machine.SimpleItemAndBlockCreationMachine;
import net.fenrir.protoos.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ProtoOS.MOD_ID);

    public static final RegistryObject<Block> SAPPHIRE_GLASS_BLOCK = registerBlock("sapphire_glass_block",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion().explosionResistance(1000000f)));
    public static final RegistryObject<Block> RUBY_GLASS_BLOCK = registerBlock("ruby_glass_block",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion().explosionResistance(1000000f)));
    public static final RegistryObject<Block> TOPAZ_GLASS_BLOCK = registerBlock("topaz_glass_block",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion().explosionResistance(1000000f)));
    public static final RegistryObject<SimpleItemAndBlockCreationMachine> SIMPLE_ITEM_AND_BLOCK_CREATION_MACHINE = registerBlock("simple_item_and_block_creation_machine",
            () -> new SimpleItemAndBlockCreationMachine(BlockBehaviour.Properties.of().noOcclusion()));
    public static final RegistryObject<GemstoneChest> GEMSTONE_CHEST = registerBlock("gemstone_chest",
            () -> new GemstoneChest(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> ENCHANTING_BENCH = registerBlock("enchanting_bench",
            () -> new EnchantingBench(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> SAPPHIRE_LOG = registerBlock("sapphire_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> SAPPHIRE_PLANKS = registerBlock("sapphire_planks",
            () -> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> SAPPHIRE_PRESSURE_PLATE = registerBlock("sapphire_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY), new BlockSetType(SAPPHIRE_PLANKS.toString())));
    public static final RegistryObject<Block> SAPPHIRE_DOOR = registerBlock("sapphire_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of().noOcclusion().pushReaction(PushReaction.DESTROY), new BlockSetType(SAPPHIRE_PLANKS.toString())));
    public static final RegistryObject<Block> SAPPHIRE_FENCE = registerBlock("sapphire_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> SAPPHIRE_FENCE_GATE = registerBlock("sapphire_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(), WoodType.OAK));
    public static final RegistryObject<Block> SAPPHIRE_SLAB = registerBlock("sapphire_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> SAPPHIRE_STAIRS = registerBlock("sapphire_stairs",
            () -> new StairBlock(SAPPHIRE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> SAPPHIRE_TRAPDOOR = registerBlock("sapphire_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of().noOcclusion(),BlockSetType.OAK));
    public static final RegistryObject<Block> SAPPHIRE_SIGN = registerBlock("sapphire_sign",
            () -> new StandingSignBlock(BlockBehaviour.Properties.of(), WoodType.OAK));
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
