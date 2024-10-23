package net.fenrir.protoos.block.custom.EnchantingBench;

import net.fenrir.protoos.block.custom.Gemstone_Chest.GemstoneChestBlockEntity;
import net.fenrir.protoos.block.entity.ModBlockEntities;
import net.fenrir.protoos.menu.ModEnchantmentMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.EnchantmentTableBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

public class EnchantingBench extends BaseEntityBlock {
    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    public static final List<BlockPos> BOOKSHELF_OFFSETS = BlockPos.betweenClosedStream(-2, 0, -2, 2, 1, 2).filter((p_207914_) -> {
        return Math.abs(p_207914_.getX()) == 2 || Math.abs(p_207914_.getZ()) == 2;
    }).map(BlockPos::immutable).toList();

    public EnchantingBench(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    public static boolean isValidBookShelf(Level pLevel, BlockPos pTablePos, BlockPos pOffsetPos) {
        return pLevel.getBlockState(pTablePos.offset(pOffsetPos)).getEnchantPowerBonus(pLevel, pTablePos.offset(pOffsetPos)) != 0.0F && pLevel.getBlockState(pTablePos.offset(pOffsetPos.getX() / 2, pOffsetPos.getY(), pOffsetPos.getZ() / 2)).is(BlockTags.ENCHANTMENT_POWER_TRANSMITTER);
    }

    public boolean useShapeForLightOcclusion(@NotNull BlockState pState) {
        return true;
    }

    public VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return SHAPE;
    }

    public void animateTick(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);
        Iterator var5 = BOOKSHELF_OFFSETS.iterator();

        while(var5.hasNext()) {
            BlockPos blockpos = (BlockPos)var5.next();
            if (pRandom.nextInt(16) == 0 && isValidBookShelf(pLevel, pPos, blockpos)) {
                pLevel.addParticle(ParticleTypes.ENCHANT, (double)pPos.getX() + 0.5, (double)pPos.getY() + 2.0, (double)pPos.getZ() + 0.5, (double)((float)blockpos.getX() + pRandom.nextFloat()) - 0.5, (double)((float)blockpos.getY() - pRandom.nextFloat() - 1.0F), (double)((float)blockpos.getZ() + pRandom.nextFloat()) - 0.5);
            }
        }

    }

    public RenderShape getRenderShape(@NotNull BlockState pState) {
        return RenderShape.MODEL;
    }

    public BlockEntity newBlockEntity(@NotNull BlockPos pPos, @NotNull BlockState pState) {
        return new EnchantmentBenchBlockEntity(pPos, pState);
    }

    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, @NotNull BlockState pState, @NotNull BlockEntityType<T> pBlockEntityType) {
        return pLevel.isClientSide ? createTickerHelper(pBlockEntityType, ModBlockEntities.ENCHANTING_BENCH.get(), EnchantmentBenchBlockEntity::bookAnimationTick) : null;
    }

    public InteractionResult use(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            pPlayer.openMenu(pState.getMenuProvider(pLevel, pPos));
            return InteractionResult.CONSUME;
        }
    }

    @Nullable
    public MenuProvider getMenuProvider(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos) {
        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if (blockentity instanceof EnchantmentBenchBlockEntity) {
            Component component = ((Nameable)blockentity).getDisplayName();
            return new SimpleMenuProvider((p_207906_, p_207907_, p_207908_) -> {
                return new ModEnchantmentMenu(p_207906_, p_207907_, ContainerLevelAccess.create(pLevel, pPos));
            }, component);
        } else {
            return null;
        }
    }

    public void setPlacedBy(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, LivingEntity pPlacer, ItemStack pStack) {
        if (pStack.hasCustomHoverName()) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof EnchantmentBenchBlockEntity) {
                ((EnchantmentBenchBlockEntity)blockentity).setCustomName(pStack.getHoverName());
            }
        }

    }

    public boolean isPathfindable(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull PathComputationType pType) {
        return false;
    }
}
