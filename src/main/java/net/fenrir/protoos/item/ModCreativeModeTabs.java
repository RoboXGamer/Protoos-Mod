package net.fenrir.protoos.item;

import net.fenrir.protoos.ProtoOS;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProtoOS.MOD_ID);
    public static final RegistryObject<CreativeModeTab> PROTOOS_TAB = CREATIVE_MODE_TABS.register("protoos_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.protoos_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(ModItems.SAPPHIRE_DUST.get());
                        output.accept(ModItems.SAPPHIRE_SWORD.get());
                        output.accept(ModItems.SAPPHIRE_PICKAXE.get());
                        output.accept(ModItems.SAPPHIRE_AXE.get());
                        output.accept(ModItems.SAPPHIRE_SHOVEL.get());
                        output.accept(ModItems.SAPPHIRE_HOE.get());
                        output.accept(ModItems.SAPPHIRE_SHEARS.get());
                        output.accept(ModItems.SAPPHIRE_COAL.get());
                        output.accept(ModItems.SAPPHIRE_BOW.get());
                        output.accept(ModItems.FLINT_AND_SAPPHIRE.get());
                        output.accept(ModItems.SAPPHIRE_FISHING_ROD.get());
                        output.accept(ModItems.SAPPHIRE_ARROW.get());
                        output.accept(ModItems.SAPPHIRE_BONEMEAL.get());
                        output.accept(ModItems.SAPPHIRE_HELMET.get());
                        output.accept(ModItems.SAPPHIRE_CHESTPLATE.get());
                        output.accept(ModItems.SAPPHIRE_LEGGINGS.get());
                        output.accept(ModItems.SAPPHIRE_BOOTS.get());
                        output.accept(ModItems.RUBY.get());
                        output.accept(ModItems.RUBY_DUST.get());
                        output.accept(ModItems.RUBY_SWORD.get());
                        output.accept(ModItems.RUBY_PICKAXE.get());
                        output.accept(ModItems.RUBY_AXE.get());
                        output.accept(ModItems.RUBY_SHOVEL.get());
                        output.accept(ModItems.RUBY_HOE.get());
                        output.accept(ModItems.RUBY_SHEARS.get());
                        output.accept(ModItems.RUBY_COAL.get());
                        output.accept(ModItems.RUBY_BOW.get());
                        output.accept(ModItems.FLINT_AND_RUBY.get());
                        output.accept(ModItems.RUBY_FISHING_ROD.get());
                        output.accept(ModItems.RUBY_ARROW.get());
                        output.accept(ModItems.RUBY_BONEMEAL.get());
                        output.accept(ModItems.RUBY_HELMET.get());
                        output.accept(ModItems.RUBY_CHESTPLATE.get());
                        output.accept(ModItems.RUBY_LEGGINGS.get());
                        output.accept(ModItems.RUBY_BOOTS.get());
                        output.accept(ModItems.TOPAZ.get());
                        output.accept(ModItems.TOPAZ_DUST.get());
                        output.accept(ModItems.TOPAZ_SWORD.get());
                        output.accept(ModItems.TOPAZ_PICKAXE.get());
                        output.accept(ModItems.TOPAZ_AXE.get());
                        output.accept(ModItems.TOPAZ_SHOVEL.get());
                        output.accept(ModItems.TOPAZ_HOE.get());
                        output.accept(ModItems.TOPAZ_SHEARS.get());
                        output.accept(ModItems.TOPAZ_COAL.get());
                        output.accept(ModItems.TOPAZ_BOW.get());
                        output.accept(ModItems.FLINT_AND_TOPAZ.get());
                        output.accept(ModItems.TOPAZ_FISHING_ROD.get());
                        output.accept(ModItems.TOPAZ_ARROW.get());
                        output.accept(ModItems.TOPAZ_BONEMEAL.get());
                    })
                    .withSearchBar()
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
