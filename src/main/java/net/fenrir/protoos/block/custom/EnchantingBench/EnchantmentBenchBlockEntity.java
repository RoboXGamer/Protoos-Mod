package net.fenrir.protoos.block.custom.EnchantingBench;

import net.fenrir.protoos.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class EnchantmentBenchBlockEntity extends BlockEntity implements Nameable {
    public int time;
    public float flip;
    public float oFlip;
    public float flipT;
    public float flipA;
    public float open;
    public float oOpen;
    public float rot;
    public float oRot;
    public float tRot;
    private static final RandomSource RANDOM = RandomSource.create();
    private Component name;

    public EnchantmentBenchBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.ENCHANTING_BENCH.get(), pPos, pBlockState);
    }

    protected void saveAdditional(@NotNull CompoundTag pTag) {
        super.saveAdditional(pTag);
        if (this.hasCustomName()) {
            pTag.putString("CustomName", Component.Serializer.toJson(this.name));
        }

    }

    public void load(CompoundTag pTag) {
        super.load(pTag);
        if (pTag.contains("CustomName", 8)) {
            this.name = Component.Serializer.fromJson(pTag.getString("CustomName"));
        }

    }

    public static void bookAnimationTick(Level pLevel, BlockPos pPos, BlockState pState, EnchantmentBenchBlockEntity pBlockEntity) {
        pBlockEntity.oOpen = pBlockEntity.open;
        pBlockEntity.oRot = pBlockEntity.rot;
        Player $$4 = pLevel.getNearestPlayer((double)pPos.getX() + 0.5, (double)pPos.getY() + 0.5, (double)pPos.getZ() + 0.5, 3.0, false);
        if ($$4 != null) {
            double $$5 = $$4.getX() - ((double)pPos.getX() + 0.5);
            double $$6 = $$4.getZ() - ((double)pPos.getZ() + 0.5);
            pBlockEntity.tRot = (float) Mth.atan2($$6, $$5);
            pBlockEntity.open += 0.1F;
            if (pBlockEntity.open < 0.5F || RANDOM.nextInt(40) == 0) {
                float $$7 = pBlockEntity.flipT;

                do {
                    pBlockEntity.flipT += (float)(RANDOM.nextInt(4) - RANDOM.nextInt(4));
                } while($$7 == pBlockEntity.flipT);
            }
        } else {
            pBlockEntity.tRot += 0.02F;
            pBlockEntity.open -= 0.1F;
        }

        while(pBlockEntity.rot >= 3.1415927F) {
            pBlockEntity.rot -= 6.2831855F;
        }

        while(pBlockEntity.rot < -3.1415927F) {
            pBlockEntity.rot += 6.2831855F;
        }

        while(pBlockEntity.tRot >= 3.1415927F) {
            pBlockEntity.tRot -= 6.2831855F;
        }

        while(pBlockEntity.tRot < -3.1415927F) {
            pBlockEntity.tRot += 6.2831855F;
        }

        float $$8;
        for($$8 = pBlockEntity.tRot - pBlockEntity.rot; $$8 >= 3.1415927F; $$8 -= 6.2831855F) {
        }

        while($$8 < -3.1415927F) {
            $$8 += 6.2831855F;
        }

        pBlockEntity.rot += $$8 * 0.4F;
        pBlockEntity.open = Mth.clamp(pBlockEntity.open, 0.0F, 1.0F);
        ++pBlockEntity.time;
        pBlockEntity.oFlip = pBlockEntity.flip;
        float $$9 = (pBlockEntity.flipT - pBlockEntity.flip) * 0.4F;
        float $$10 = 0.2F;
        $$9 = Mth.clamp($$9, -0.2F, 0.2F);
        pBlockEntity.flipA += ($$9 - pBlockEntity.flipA) * 0.9F;
        pBlockEntity.flip += pBlockEntity.flipA;
    }

    public Component getName() {
        return (Component)(this.name != null ? this.name : Component.translatable("container.enchanting"));
    }

    public void setCustomName(@Nullable Component pName) {
        this.name = pName;
    }

    @Nullable
    public Component getCustomName() {
        return this.name;
    }
}