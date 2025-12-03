package com.workoutrandomizer.data;

import com.workoutrandomizer.model.Exercise;
import com.workoutrandomizer.model.EquipmentType;
import com.workoutrandomizer.model.MuscleGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Database of all available exercises
 */
public class ExerciseDatabase {
    private static final List<Exercise> exercises = new ArrayList<>();
    
    static {
        // Chest exercises
        exercises.add(new Exercise("Bench Press", EquipmentType.DUMBBELL, MuscleGroup.CHEST));
        exercises.add(new Exercise("Bench Press", EquipmentType.BARBELL, MuscleGroup.CHEST));
        exercises.add(new Exercise("Incline Press", EquipmentType.DUMBBELL, MuscleGroup.CHEST));
        exercises.add(new Exercise("Incline Press", EquipmentType.BARBELL, MuscleGroup.CHEST));
        exercises.add(new Exercise("Flyes", EquipmentType.DUMBBELL, MuscleGroup.CHEST));
        exercises.add(new Exercise("Decline Press", EquipmentType.DUMBBELL, MuscleGroup.CHEST));
        exercises.add(new Exercise("Decline Press", EquipmentType.BARBELL, MuscleGroup.CHEST));
        
        // Back exercises
        exercises.add(new Exercise("Rows", EquipmentType.DUMBBELL, MuscleGroup.BACK));
        exercises.add(new Exercise("Rows", EquipmentType.BARBELL, MuscleGroup.BACK));
        exercises.add(new Exercise("Deadlifts", EquipmentType.BARBELL, MuscleGroup.BACK));
        exercises.add(new Exercise("Pullovers", EquipmentType.DUMBBELL, MuscleGroup.BACK));
        exercises.add(new Exercise("Shrugs", EquipmentType.DUMBBELL, MuscleGroup.BACK));
        exercises.add(new Exercise("Shrugs", EquipmentType.BARBELL, MuscleGroup.BACK));
        
        // Shoulder exercises
        exercises.add(new Exercise("Overhead Press", EquipmentType.DUMBBELL, MuscleGroup.SHOULDERS));
        exercises.add(new Exercise("Overhead Press", EquipmentType.BARBELL, MuscleGroup.SHOULDERS));
        exercises.add(new Exercise("Lateral Raises", EquipmentType.DUMBBELL, MuscleGroup.SHOULDERS));
        exercises.add(new Exercise("Front Raises", EquipmentType.DUMBBELL, MuscleGroup.SHOULDERS));
        exercises.add(new Exercise("Front Raises", EquipmentType.BARBELL, MuscleGroup.SHOULDERS));
        exercises.add(new Exercise("Rear Delt Flyes", EquipmentType.DUMBBELL, MuscleGroup.SHOULDERS));
        
        // Bicep exercises
        exercises.add(new Exercise("Curls", EquipmentType.DUMBBELL, MuscleGroup.BICEPS));
        exercises.add(new Exercise("Curls", EquipmentType.BARBELL, MuscleGroup.BICEPS));
        exercises.add(new Exercise("Hammer Curls", EquipmentType.DUMBBELL, MuscleGroup.BICEPS));
        exercises.add(new Exercise("Preacher Curls", EquipmentType.DUMBBELL, MuscleGroup.BICEPS));
        exercises.add(new Exercise("Preacher Curls", EquipmentType.BARBELL, MuscleGroup.BICEPS));
        
        // Tricep exercises
        exercises.add(new Exercise("Skull Crushers", EquipmentType.DUMBBELL, MuscleGroup.TRICEPS));
        exercises.add(new Exercise("Skull Crushers", EquipmentType.BARBELL, MuscleGroup.TRICEPS));
        exercises.add(new Exercise("Tricep Extensions", EquipmentType.DUMBBELL, MuscleGroup.TRICEPS));
        exercises.add(new Exercise("Close Grip Bench", EquipmentType.BARBELL, MuscleGroup.TRICEPS));
        
        // Leg exercises
        exercises.add(new Exercise("Squats", EquipmentType.DUMBBELL, MuscleGroup.LEGS));
        exercises.add(new Exercise("Squats", EquipmentType.BARBELL, MuscleGroup.LEGS));
        exercises.add(new Exercise("Lunges", EquipmentType.DUMBBELL, MuscleGroup.LEGS));
        exercises.add(new Exercise("Lunges", EquipmentType.BARBELL, MuscleGroup.LEGS));
        exercises.add(new Exercise("Romanian Deadlifts", EquipmentType.DUMBBELL, MuscleGroup.LEGS));
        exercises.add(new Exercise("Romanian Deadlifts", EquipmentType.BARBELL, MuscleGroup.LEGS));
        exercises.add(new Exercise("Calf Raises", EquipmentType.DUMBBELL, MuscleGroup.LEGS));
        exercises.add(new Exercise("Calf Raises", EquipmentType.BARBELL, MuscleGroup.LEGS));
        exercises.add(new Exercise("Leg Press", EquipmentType.MACHINE, MuscleGroup.LEGS));
    }
    
    /**
     * Get all exercises for a specific muscle group
     */
    public static List<Exercise> getExercisesByMuscleGroup(MuscleGroup muscleGroup) {
        if (muscleGroup == null) {
            throw new IllegalArgumentException("Muscle group cannot be null");
        }
        return exercises.stream()
                .filter(e -> e.getMuscleGroup() == muscleGroup)
                .collect(Collectors.toList());
    }
    
    /**
     * Get all exercises
     */
    public static List<Exercise> getAllExercises() {
        return new ArrayList<>(exercises);
    }
}
