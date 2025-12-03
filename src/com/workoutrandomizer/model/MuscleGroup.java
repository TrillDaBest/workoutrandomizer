package com.workoutrandomizer.model;

/**
 * Muscle groups for workout splits
 */
public enum MuscleGroup {
    CHEST("Chest"),
    BACK("Back"),
    SHOULDERS("Shoulders"),
    BICEPS("Biceps"),
    TRICEPS("Triceps"),
    LEGS("Legs");
    
    private final String displayName;
    
    MuscleGroup(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
