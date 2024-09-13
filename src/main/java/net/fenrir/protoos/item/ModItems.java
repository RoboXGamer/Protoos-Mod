package net.fenrir.protoos.item;

import net.fenrir.protoos.ProtoOS;
import net.fenrir.protoos.item.custom.FuelItem;
import net.minecraft.world.item.*;
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
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SAPPHIRE, 9, 25, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () -> new AxeItem(ModToolTiers.SAPPHIRE, 9, 25, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
            () -> new ShovelItem(ModToolTiers.SAPPHIRE, 9, 25, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
            () -> new HoeItem(ModToolTiers.SAPPHIRE, 9, 25, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAPPHIRE_SHEARS = ITEMS.register("sapphire_shears",
            () -> new ShearsItem(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAPPHIRE_COAL = ITEMS.register("sapphire_coal",
            () -> new FuelItem(new Item.Properties(), 630720000));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
