package net.fenrir.protoos.item;

import net.fenrir.protoos.ProtoOS;
import net.fenrir.protoos.item.custom.FuelItem;
import net.fenrir.protoos.item.custom.ModElytra;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProtoOS.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD = ITEMS.register("emerald",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND = ITEMS.register("diamond",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_DUST = ITEMS.register("sapphire_dust",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_DUST = ITEMS.register("ruby_dust",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_DUST = ITEMS.register("topaz_dust",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_DUST = ITEMS.register("emerald_dust",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_SADDLE = ITEMS.register("sapphire_saddle",
            () -> new SaddleItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_SADDLE = ITEMS.register("ruby_saddle",
            () -> new SaddleItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_SADDLE = ITEMS.register("topaz_saddle",
            () -> new SaddleItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_SADDLE = ITEMS.register("emerald_saddle",
            () -> new SaddleItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_SADDLE = ITEMS.register("diamond_saddle",
            () -> new SaddleItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_ELYTRA = ITEMS.register("sapphire_elytra",
            () -> new ModElytra(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_ELYTRA = ITEMS.register("ruby_elytra",
            () -> new ModElytra(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_ELYTRA = ITEMS.register("topaz_elytra",
            () -> new ModElytra(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_ELYTRA = ITEMS.register("emerald_elytra",
            () -> new ModElytra(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_ELYTRA = ITEMS.register("diamond-elytra",
            () -> new ModElytra(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_SHIELD = ITEMS.register("sapphire_shield",
            () -> new ShieldItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_SHIELD = ITEMS.register("ruby_shield",
            () -> new ShieldItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_SHIELD = ITEMS.register("topaz_shield",
            () -> new ShieldItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_SHIELD = ITEMS.register("emerald_shield",
            () -> new ShieldItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_SHIELD = ITEMS.register("diamond_shield",
            () -> new ShieldItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () -> new SwordItem(ModToolTiers.SAPPHIRE, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModToolTiers.RUBY, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_SWORD = ITEMS.register("topaz_sword",
            () -> new SwordItem(ModToolTiers.TOPAZ,250,25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword",
            () -> new SwordItem(ModToolTiers.EMERALD, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_SWORD = ITEMS.register("diamond_sword",
            () -> new SwordItem(ModToolTiers.DIAMOND, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SAPPHIRE, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RUBY, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_PICKAXE = ITEMS.register("topaz_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TOPAZ,250,25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe",
            () -> new PickaxeItem(ModToolTiers.EMERALD, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_PICKAXE = ITEMS.register("diamond_pickaxe",
            () -> new PickaxeItem(ModToolTiers.DIAMOND, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () -> new AxeItem(ModToolTiers.SAPPHIRE, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModToolTiers.RUBY, 250,25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_AXE = ITEMS.register("topaz_axe",
            () -> new AxeItem(ModToolTiers.TOPAZ,250,25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe",
            () -> new AxeItem(ModToolTiers.EMERALD, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_AXE = ITEMS.register("diamond_axe",
            () -> new AxeItem(ModToolTiers.DIAMOND, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
            () -> new ShovelItem(ModToolTiers.SAPPHIRE, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModToolTiers.RUBY, 250,25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_SHOVEL = ITEMS.register("topaz_shovel",
            () -> new ShovelItem(ModToolTiers.TOPAZ,250,25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel",
            () -> new ShovelItem(ModToolTiers.EMERALD, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_SHOVEL = ITEMS.register("diamond_shovel",
            () -> new ShovelItem(ModToolTiers.DIAMOND, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
            () -> new HoeItem(ModToolTiers.SAPPHIRE, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModToolTiers.RUBY, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_HOE = ITEMS.register("topaz_hoe",
            () -> new HoeItem(ModToolTiers.TOPAZ,250,25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe",
            () -> new HoeItem(ModToolTiers.EMERALD, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_HOE = ITEMS.register("diamond_hoe",
            () -> new HoeItem(ModToolTiers.DIAMOND, 250, 25, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_SHEARS = ITEMS.register("sapphire_shears",
            () -> new ShearsItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_SHEARS = ITEMS.register("ruby_shears",
            () -> new ShearsItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_SHEARS = ITEMS.register("topaz_shears",
            () -> new ShearsItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERAlD_SHEARS = ITEMS.register("emerald_shears",
            () -> new ShearsItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_SHEARS = ITEMS.register("diamond_shears",
            () -> new ShearsItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_COAL = ITEMS.register("sapphire_coal",
            () -> new FuelItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC), 630720000));
    public static final RegistryObject<Item> RUBY_COAL = ITEMS.register("ruby_coal",
            () -> new FuelItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC), 630720000));
    public static final RegistryObject<Item> TOPAZ_COAL = ITEMS.register("topaz_coal",
            () -> new FuelItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC), 630720000));
    public static final RegistryObject<Item> EMERALD_COAL = ITEMS.register("emerald_coal",
            () -> new FuelItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC), 630720000));
    public static final RegistryObject<Item> DIAMOND_COAL = ITEMS.register("diamond_coal",
            () -> new FuelItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC), 630720000));
    public static final RegistryObject<Item> SAPPHIRE_BOW = ITEMS.register("sapphire_bow",
            () -> new BowItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_BOW = ITEMS.register("ruby_bow",
            () -> new BowItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_BOW = ITEMS.register("topaz_bow",
            () -> new BowItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_BOW = ITEMS.register("emerald_bow",
            () -> new BowItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_BOW = ITEMS.register("diamond_bow",
            () -> new BowItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> FLINT_AND_SAPPHIRE = ITEMS.register("flint_and_sapphire",
            () -> new FlintAndSteelItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> FLINT_AND_RUBY = ITEMS.register("flint_and_ruby",
            () -> new FlintAndSteelItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> FLINT_AND_TOPAZ = ITEMS.register("flint_and_topaz",
            () -> new FlintAndSteelItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> FLINT_AND_EMERALD = ITEMS.register("flint_and_emerald",
            () -> new FlintAndSteelItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> FLINT_AND_DIAMOND = ITEMS.register("flint_and_diamond",
            () -> new FlintAndSteelItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_FISHING_ROD = ITEMS.register("sapphire_fishing_rod",
            () -> new FishingRodItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_FISHING_ROD = ITEMS.register("ruby_fishing_rod",
            () -> new FishingRodItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_FISHING_ROD = ITEMS.register("topaz_fishing_rod",
            () -> new FishingRodItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_FISHING_ROD = ITEMS.register("emerald_fishing_rod",
            () -> new FishingRodItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_FISHING_ROD = ITEMS.register("diamond_fishing_rod",
            () -> new FishingRodItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_ARROW = ITEMS.register("sapphire_arrow",
            () -> new ArrowItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_ARROW = ITEMS.register("ruby_arrow",
            () -> new ArrowItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_ARROW = ITEMS.register("topaz_arrow",
            () -> new ArrowItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_ARROW = ITEMS.register("emerald_arrow",
            () -> new ArrowItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_ARROW = ITEMS.register("diamond_arrow",
            () -> new ArrowItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_BONEMEAL = ITEMS.register("sapphire_bonemeal",
            () -> new BoneMealItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_BONEMEAL = ITEMS.register("ruby_bonemeal",
            () -> new BoneMealItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_BONEMEAL = ITEMS.register("topaz_bonemeal",
            () -> new BoneMealItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_BONEMEAL = ITEMS.register("emerald_bonemeal",
            () -> new BoneMealItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_BONEMEAL = ITEMS.register("diamond_bonemeal",
            () -> new BoneMealItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
            () -> new ArmorItem(ModArmourMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmourMaterials.RUBY, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_HELMET = ITEMS.register("topaz_helmet",
            () -> new ArmorItem(ModArmourMaterials.TOPAZ, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet",
            () -> new ArmorItem(ModArmourMaterials.EMERALD, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_HELMET = ITEMS.register("diamond_helmet",
            () -> new ArmorItem(ModArmourMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate",
            () -> new ArmorItem(ModArmourMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmourMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_CHESTPLATE = ITEMS.register("topaz_chestplate",
            () -> new ArmorItem(ModArmourMaterials.TOPAZ, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate",
            () -> new ArmorItem(ModArmourMaterials.EMERALD, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_CHESTPLATE = ITEMS.register("diamond_chestplate",
            () -> new ArmorItem(ModArmourMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings",
            () -> new ArmorItem(ModArmourMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmourMaterials.RUBY, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_LEGGINGS = ITEMS.register("topaz_leggings",
            () -> new ArmorItem(ModArmourMaterials.TOPAZ, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings",
            () -> new ArmorItem(ModArmourMaterials.EMERALD, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_LEGGINGS = ITEMS.register("diamond_leggings",
            () -> new ArmorItem(ModArmourMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots",
            () -> new ArmorItem(ModArmourMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmourMaterials.RUBY, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> TOPAZ_BOOTS = ITEMS.register("topaz_boots",
            () -> new ArmorItem(ModArmourMaterials.TOPAZ, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots",
            () -> new ArmorItem(ModArmourMaterials.EMERALD, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> DIAMOND_BOOTS = ITEMS.register("diamond_boots",
            () -> new ArmorItem(ModArmourMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
