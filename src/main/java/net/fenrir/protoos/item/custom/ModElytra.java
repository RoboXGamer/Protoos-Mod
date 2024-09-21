package net.fenrir.protoos.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModElytra extends ElytraItem {
    public ModElytra(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public boolean canElytraFly(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        return true;
    }
}

