package net.fenrir.protoos.block.custom.Gemstone_Chest;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class GemstoneChest extends Block implements EntityBlock {
    public GemstoneChest(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new GemstoneChestBlockEntity(pos, state);
    }

    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (!state.is(newState.getBlock())) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof GemstoneChestBlockEntity blockEntity) {
                SimpleContainer inv = blockEntity.getInvContainer();
                Containers.dropContents(level, pos, inv);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    public InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }
        if (hand != InteractionHand.MAIN_HAND) return InteractionResult.PASS;
        BlockEntity be = level.getBlockEntity(pos);
        if (!(be instanceof GemstoneChestBlockEntity blockEntity)) return InteractionResult.PASS;
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            NetworkHooks.openScreen(serverPlayer, blockEntity,pos);
        }
        return InteractionResult.CONSUME;
    }
}