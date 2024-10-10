package net.fenrir.protoos.block.entity;

import net.fenrir.protoos.ProtoOS;
import net.fenrir.protoos.block.ModBlocks;
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


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPE.register(eventBus);
    }
}