package com.workoutrandomizer.model;

/**
 * Defines the different workout split options
 */
public enum WorkoutSplit {
    LEGS("Legs", new MuscleGroup[]{MuscleGroup.LEGS}),
    BACK_BICEPS("Back/Biceps", new MuscleGroup[]{MuscleGroup.BACK, MuscleGroup.BICEPS}),
    CHEST_TRICEPS("Chest/Triceps", new MuscleGroup[]{MuscleGroup.CHEST, MuscleGroup.TRICEPS}),
    SHOULDERS_BI("Shoulders/Biceps", new MuscleGroup[]{MuscleGroup.SHOULDERS, MuscleGroup.BICEPS}),
    SHOULDERS_TRI("Shoulders/Triceps", new MuscleGroup[]{MuscleGroup.SHOULDERS, MuscleGroup.TRICEPS});
    
    private final String displayName;
    private final MuscleGroup[] muscleGroups;
    
    WorkoutSplit(String displayName, MuscleGroup[] muscleGroups) {
        this.displayName = displayName;
        this.muscleGroups = muscleGroups;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public MuscleGroup[] getMuscleGroups() {
        return muscleGroups;
    }
}
