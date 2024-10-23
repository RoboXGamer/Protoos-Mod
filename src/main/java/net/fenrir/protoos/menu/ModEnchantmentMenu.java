package net.fenrir.protoos.menu;

import net.fenrir.protoos.block.ModBlocks;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import org.jetbrains.annotations.NotNull;

public class ModEnchantmentMenu extends net.minecraft.world.inventory.EnchantmentMenu{
    private final ContainerLevelAccess access;

    public ModEnchantmentMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
        super(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
        this.access = pAccess;
    }
    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return stillValid(this.access, pPlayer, ModBlocks.ENCHANTING_BENCH.get());
    }
}
