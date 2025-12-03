package com.workoutrandomizer.model;

/**
 * Types of equipment used for exercises
 */
public enum EquipmentType {
    DUMBBELL("DB"),
    BARBELL("BB"),
    MACHINE("Machine"),
    BODYWEIGHT("Bodyweight");
    
    private final String abbreviation;
    
    EquipmentType(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    public String getAbbreviation() {
        return abbreviation;
    }
}
