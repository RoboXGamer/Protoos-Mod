package net.fenrir.protoos;

import net.fenrir.protoos.block.ModBlocks;
import net.fenrir.protoos.block.entity.ModBlockEntities;
import net.fenrir.protoos.item.ModCreativeModeTabs;
import net.fenrir.protoos.item.ModItems;
import net.fenrir.protoos.menu.ModMenus;
import net.fenrir.protoos.screen.GemstoneChestScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ProtoOS.MOD_ID)
public class ProtoOS
{
    public static final String MOD_ID = "protoos";
    public static ResourceLocation location(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public ProtoOS()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModMenus.register(modEventBus);
        modEventBus.addListener(this::clientSetup);
        ModCreativeModeTabs.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void clientSetup(FMLClientSetupEvent  event) {
        event.enqueueWork(
                () -> MenuScreens.register(ModMenus.GEMSTONE_CHEST_MENU.get(), GemstoneChestScreen::new)
        );
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}