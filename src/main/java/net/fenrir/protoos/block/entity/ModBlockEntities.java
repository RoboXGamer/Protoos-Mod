package net.fenrir.protoos.block.entity;

import net.fenrir.protoos.ProtoOS;
import net.fenrir.protoos.block.ModBlocks;
import net.fenrir.protoos.block.custom.BatteryBlock.BatteryBlockEntity;
import net.fenrir.protoos.block.custom.EnchantingBench.EnchantmentBenchBlockEntity;
import net.fenrir.protoos.block.custom.Gemstone_Chest.GemstoneChestBlockEntity;
import net.fenrir.protoos.block.custom.Simple_Item_And_Block_Creation_Machine.SimpleItemAndBlockCreationMachineBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ProtoOS.MOD_ID);

    public static final RegistryObject<BlockEntityType<SimpleItemAndBlockCreationMachineBlockEntity>> SIMPLE_ITEM_AND_BLOCK_CREATION_MACHINE =
            BLOCK_ENTITY_TYPE.register("simple_item_and_block_creation_machine", () -> BlockEntityType.Builder.of(SimpleItemAndBlockCreationMachineBlockEntity::new,
                    ModBlocks.SIMPLE_ITEM_AND_BLOCK_CREATION_MACHINE.get())
                    .build(null));

    public static final RegistryObject<BlockEntityType<GemstoneChestBlockEntity>> GEMSTONE_CHEST_ENTITY =
            BLOCK_ENTITY_TYPE.register("gemstone_chest_entity", () -> BlockEntityType.Builder.of(GemstoneChestBlockEntity::new,
                    ModBlocks.GEMSTONE_CHEST.get())
                    .build(null));
    public static final RegistryObject<BlockEntityType<EnchantmentBenchBlockEntity>> ENCHANTING_BENCH =
            BLOCK_ENTITY_TYPE.register("enchanting_bench", () -> BlockEntityType.Builder.of(EnchantmentBenchBlockEntity::new,
                    ModBlocks.ENCHANTING_BENCH.get())
                    .build(null));
    
    public static final RegistryObject<BlockEntityType<BatteryBlockEntity>> BATTERY_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPE.register("battery_block_entity", () -> BlockEntityType.Builder.of(BatteryBlockEntity::new,
                    ModBlocks.BATTERY_BLOCK.get())
                    .build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPE.register(eventBus);
    }
}