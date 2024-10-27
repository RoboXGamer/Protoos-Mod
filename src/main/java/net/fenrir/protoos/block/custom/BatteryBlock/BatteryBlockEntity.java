package net.fenrir.protoos.block.custom.BatteryBlock;

import net.fenrir.protoos.ProtoOS;
import net.fenrir.protoos.block.entity.ModBlockEntities;
import net.fenrir.protoos.util.ExtendedEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BatteryBlockEntity extends BlockEntity {
  private static final int FE_PER_TICK = 5;
  private int tc = 0;
  
  private final ExtendedEnergyStorage energyStorage = new ExtendedEnergyStorage(10000,0, 10000, this);
  
  private final LazyOptional<ExtendedEnergyStorage> lazyEnergyStorage = LazyOptional.of(() -> this.energyStorage);
  
  @Override
  public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
    if (cap == ForgeCapabilities.ENERGY) {
      return this.lazyEnergyStorage.cast();
    }
    return super.getCapability(cap);
  }
  
  @Override
  public void invalidateCaps() {
    super.invalidateCaps();
    this.lazyEnergyStorage.invalidate();
  }
  
  public BatteryBlockEntity(BlockPos pos, BlockState blockState) {
    super(ModBlockEntities.BATTERY_BLOCK_ENTITY.get(), pos, blockState);
  }
  
  CompoundTag getModData() {
    CompoundTag modData = new CompoundTag();
    
    modData.put("Energy", this.energyStorage.serializeNBT());
    return modData;
  }
  
  private void deserializeFromTag(CompoundTag tag) {
    this.energyStorage.deserializeNBT(Objects.requireNonNull(tag.get("Energy")));
  }
  
  @Override
  public void load(@NotNull CompoundTag tag) {
    super.load(tag);
    
    if (level != null && level.isClientSide()) {
      // Deserialize data from the tag for client-side
      deserializeFromTag(tag);
    } else {
      CompoundTag modData = tag.getCompound(ProtoOS.MOD_ID);
      deserializeFromTag(modData);
    }
  }
  
  @Override
  protected void saveAdditional(@NotNull CompoundTag tag) {
    super.saveAdditional(tag);
    CompoundTag modData = getModData();
    tag.put(ProtoOS.MOD_ID, modData);
  }
  
  public void tick() {
    this.tc++;
    if (everySecond()) tc = 0;
    
    Level level = this.getLevel();
    BlockPos pos = this.getBlockPos();
    if (level == null || level.isClientSide() || !(level instanceof ServerLevel slevel) || !(level.getBlockEntity(pos) instanceof BatteryBlockEntity be)) return;
    
    if (everySecond(1)) {
      //  TESTING
      be.energyStorage.addEnergy(FE_PER_TICK * 20);
    }
  }
  
  private boolean everySecond() {
    return this.tc % (20) == 0;
  }
  
  private boolean everySecond(double s) {
    return this.tc % (20 * s) == 0;
  }
  
  public EnergyStorage getEnergyStorage() {
    return this.energyStorage;
  }
}
