package net.fenrir.protoos.menu;

import net.fenrir.protoos.block.ModBlocks;
import net.fenrir.protoos.block.custom.Gemstone_Chest.GemstoneChestBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class GemstoneChestMenu extends AbstractContainerMenu {

    private final GemstoneChestBlockEntity blockEntity;
    private final ContainerLevelAccess levelAccess;

    //Server Constructor
    public GemstoneChestMenu(int containerId, @NotNull Inventory playerInv, BlockEntity blockEntity) {
        super(ModMenus.GEMSTONE_CHEST_MENU.get(), containerId);
        if (blockEntity instanceof GemstoneChestBlockEntity miniChestBlockEntity) {
            this.blockEntity = miniChestBlockEntity;
        } else {
            throw new IllegalArgumentException("BlockEntity is not a MechanicalCrafterBlockEntity");
        }

        this.levelAccess = ContainerLevelAccess.create(Objects.requireNonNull(blockEntity.getLevel()),
                blockEntity.getBlockPos());
        createBlockEntityInventory(this.blockEntity);

        createPlayerHotbar(playerInv);
        createPlayerInventory(playerInv);
    }

    // Client Constructor
    public GemstoneChestMenu(int containerId, Inventory playerInv, FriendlyByteBuf extraData) {
        this(containerId, playerInv, playerInv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    private void createPlayerInventory(@NotNull Inventory playerInv) {
        var playerInvYStart = 140;
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, playerInvYStart + row * 18));
            }
        }
    }

    private void createPlayerHotbar(@NotNull Inventory playerInv) {
        var hotbarYStart = 198;
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInv, col, 8 + col * 18, hotbarYStart));
        }
    }

    private void createBlockEntityInventory(GemstoneChestBlockEntity blockEntity){
        int startX = 8;  // X coordinate for the top-left slot
        int startY = 18; // Y coordinate for the top-left slot
        int slotsPerRow = 9;  // Number of slots in a row
        int rows = 6;         // Number of rows
        int slotSize = 18;    // Slot width/height (assuming slots are square)

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < slotsPerRow; col++) {
                int slotIndex = row * slotsPerRow + col;
                int xPosition = startX + col * slotSize;
                int yPosition = startY + row * slotSize;
                this.addSlot(new SlotItemHandler(blockEntity.getInvHandler(), slotIndex, xPosition, yPosition));
            }
        }
    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 1;  // must be the number of slots you have!
    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return stillValid(this.levelAccess, player, ModBlocks.GEMSTONE_CHEST.get());
    }

    public BlockEntity getBlockEntity() {
        return this.blockEntity;
    }
}
