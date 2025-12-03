package com.workoutrandomizer.model;

/**
 * Represents a single exercise with its equipment type and muscle group
 */
public class Exercise {
    private final String name;
    private final EquipmentType equipmentType;
    private final MuscleGroup muscleGroup;
    
    public Exercise(String name, EquipmentType equipmentType, MuscleGroup muscleGroup) {
        this.name = name;
        this.equipmentType = equipmentType;
        this.muscleGroup = muscleGroup;
    }
    
    public String getName() {
        return name;
    }
    
    public EquipmentType getEquipmentType() {
        return equipmentType;
    }
    
    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }
    
    public String getFullName() {
        return equipmentType.getAbbreviation() + " " + name;
    }
    
    @Override
    public String toString() {
        return getFullName();
    }
}
