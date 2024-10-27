package net.fenrir.protoos.block.custom.BatteryBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BatteryBlock extends Block implements EntityBlock {
  public BatteryBlock(Properties pProperties) {
    super(pProperties);
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
