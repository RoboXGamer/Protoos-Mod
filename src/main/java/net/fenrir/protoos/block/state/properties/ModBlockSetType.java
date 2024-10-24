package net.fenrir.protoos.block.state.properties;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.Set;
import java.util.stream.Stream;

public record ModBlockSetType(String name, boolean canOpenByHand, SoundType soundType, SoundEvent doorClose, SoundEvent doorOpen, SoundEvent trapdoorClose, SoundEvent trapdoorOpen, SoundEvent pressurePlateClickOff, SoundEvent pressurePlateClickOn, SoundEvent buttonClickOff, SoundEvent buttonClickOn) {
    private static final Set<BlockSetType> VALUES = new ObjectArraySet();
    public static final BlockSetType SAPPHIRE;

    public ModBlockSetType(String pName) {
        this(pName, true, SoundType.WOOD, SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON);
    }

    public ModBlockSetType(String name, boolean canOpenByHand, SoundType soundType, SoundEvent doorClose, SoundEvent doorOpen, SoundEvent trapdoorClose, SoundEvent trapdoorOpen, SoundEvent pressurePlateClickOff, SoundEvent pressurePlateClickOn, SoundEvent buttonClickOff, SoundEvent buttonClickOn) {
        this.name = name;
        this.canOpenByHand = canOpenByHand;
        this.soundType = soundType;
        this.doorClose = doorClose;
        this.doorOpen = doorOpen;
        this.trapdoorClose = trapdoorClose;
        this.trapdoorOpen = trapdoorOpen;
        this.pressurePlateClickOff = pressurePlateClickOff;
        this.pressurePlateClickOn = pressurePlateClickOn;
        this.buttonClickOff = buttonClickOff;
        this.buttonClickOn = buttonClickOn;
    }

    public static BlockSetType register(BlockSetType pValue) {
        VALUES.add(pValue);
        return pValue;
    }

    public static Stream<BlockSetType> values() {
        return VALUES.stream();
    }

    public String name() {
        return this.name;
    }

    public boolean canOpenByHand() {
        return this.canOpenByHand;
    }

    public SoundType soundType() {
        return this.soundType;
    }

    public SoundEvent doorClose() {
        return this.doorClose;
    }

    public SoundEvent doorOpen() {
        return this.doorOpen;
    }

    public SoundEvent trapdoorClose() {
        return this.trapdoorClose;
    }

    public SoundEvent trapdoorOpen() {
        return this.trapdoorOpen;
    }

    public SoundEvent pressurePlateClickOff() {
        return this.pressurePlateClickOff;
    }

    public SoundEvent pressurePlateClickOn() {
        return this.pressurePlateClickOn;
    }

    public SoundEvent buttonClickOff() {
        return this.buttonClickOff;
    }

    public SoundEvent buttonClickOn() {
        return this.buttonClickOn;
    }

    static {
        SAPPHIRE = register(new BlockSetType("sapphire", false, SoundType.METAL, SoundEvents.IRON_DOOR_CLOSE, SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_TRAPDOOR_CLOSE, SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));
    }
}
