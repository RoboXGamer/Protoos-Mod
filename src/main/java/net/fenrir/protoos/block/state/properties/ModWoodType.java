package net.fenrir.protoos.block.state.properties;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.Set;
import java.util.stream.Stream;

public record ModWoodType(String name, BlockSetType setType, SoundType soundType, SoundType hangingSignSoundType, SoundEvent fenceGateClose, SoundEvent fenceGateOpen) {
    private static final Set<ModWoodType> VALUES = new ObjectArraySet();
    public static final ModWoodType SAPPHIRE;

    public ModWoodType(String pName, BlockSetType pSetType) {
        this(pName, pSetType, SoundType.WOOD, SoundType.HANGING_SIGN, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN);
    }

    public ModWoodType(String name, BlockSetType setType, SoundType soundType, SoundType hangingSignSoundType, SoundEvent fenceGateClose, SoundEvent fenceGateOpen) {
        this.name = name;
        this.setType = setType;
        this.soundType = soundType;
        this.hangingSignSoundType = hangingSignSoundType;
        this.fenceGateClose = fenceGateClose;
        this.fenceGateOpen = fenceGateOpen;
    }

    public static ModWoodType register(ModWoodType pWoodType) {
        VALUES.add(pWoodType);
        return pWoodType;
    }

    public static Stream<ModWoodType> values() {
        return VALUES.stream();
    }

    public String name() {
        return this.name;
    }

    public BlockSetType setType() {
        return this.setType;
    }

    public SoundType soundType() {
        return this.soundType;
    }

    public SoundType hangingSignSoundType() {
        return this.hangingSignSoundType;
    }

    public SoundEvent fenceGateClose() {
        return this.fenceGateClose;
    }

    public SoundEvent fenceGateOpen() {
        return this.fenceGateOpen;
    }

    static {
        SAPPHIRE = register(new ModWoodType("sapphire", ModBlockSetType.SAPPHIRE));
    }
}
