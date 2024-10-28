package net.fenrir.protoos.block.custom.BatteryBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BatteryBlock extends Block implements EntityBlock {
  public static BooleanProperty POWERED = BlockStateProperties.POWERED;
  
  public BatteryBlock(Properties pProperties) {
    super(pProperties);
    this.registerDefaultState(this.defaultBlockState().setValue(POWERED, false));
  }
  
  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(POWERED);
  }
  
  @Override
  public void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block neighborBlock, @NotNull BlockPos neighborPos, boolean pMovedByPiston) {
    if (level instanceof ServerLevel serverLevel) {
      boolean currentPowered = state.getValue(POWERED);
      boolean isGettingPowered = level.hasNeighborSignal(pos);
      if (isGettingPowered != currentPowered) {
        serverLevel.setBlock(pos, state.setValue(POWERED, isGettingPowered), Block.UPDATE_ALL);
      }
      if (level.getBlockEntity(pos) instanceof BatteryBlockEntity blockEntity) {
        blockEntity.setChanged();
      }
    }
  }
  
  @Override
  public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
    return new BatteryBlockEntity(blockPos, blockState);
  }
  
  @Override
  public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> blockEntityType) {
    return level.isClientSide ? null : ((level1, pos, state1, blockEntity) -> ((BatteryBlockEntity) blockEntity).tick());
  }
}
