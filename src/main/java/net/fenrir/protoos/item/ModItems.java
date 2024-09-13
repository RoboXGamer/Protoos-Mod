package net.fenrir.protoos.item;

import net.fenrir.protoos.ProtoOS;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProtoOS.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAPPHIRE_DUST = ITEMS.register("sapphire_dust",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () -> new SwordItem(ModToolTiers.SAPPHIRE, 9, 25, new Item.Properties().fireResistant()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
