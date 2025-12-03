package com.workoutrandomizer.data;

import com.workoutrandomizer.model.Exercise;
import com.workoutrandomizer.model.MuscleGroup;
import com.workoutrandomizer.model.WorkoutSplit;

import java.util.*;

/**
 * Generates randomized workouts based on the selected split
 */
public class WorkoutGenerator {
    private final Random random;
    
    public WorkoutGenerator() {
        this.random = new Random();
    }
    
    /**
     * Generate a randomized workout for the given split
     * Returns 4-6 exercises
     */
    public List<Exercise> generateWorkout(WorkoutSplit split) {
        List<Exercise> workout = new ArrayList<>();
        MuscleGroup[] muscleGroups = split.getMuscleGroups();
        
        // Determine total number of exercises (4-6)
        int totalExercises = 4 + random.nextInt(3); // 4, 5, or 6
        
        // Calculate exercises per muscle group
        int exercisesPerGroup = totalExercises / muscleGroups.length;
        int remainder = totalExercises % muscleGroups.length;
        
        // Generate exercises for each muscle group
        for (int i = 0; i < muscleGroups.length; i++) {
            int count = exercisesPerGroup + (i < remainder ? 1 : 0);
            List<Exercise> groupExercises = getRandomExercises(muscleGroups[i], count);
            workout.addAll(groupExercises);
        }
        
        // Shuffle the final workout
        Collections.shuffle(workout, random);
        
        return workout;
    }
    
    /**
     * Get a specified number of random exercises for a muscle group
     * Prioritizes variety in exercise names, randomly selecting equipment type
     */
    private List<Exercise> getRandomExercises(MuscleGroup muscleGroup, int count) {
        List<Exercise> allExercises = ExerciseDatabase.getExercisesByMuscleGroup(muscleGroup);
        
        if (allExercises.isEmpty()) {
            return Collections.emptyList();
        }
        
        // Group exercises by name
        Map<String, List<Exercise>> exercisesByName = new HashMap<>();
        for (Exercise exercise : allExercises) {
            exercisesByName.computeIfAbsent(exercise.getName(), k -> new ArrayList<>()).add(exercise);
        }
        
        // Select random exercise names
        List<String> exerciseNames = new ArrayList<>(exercisesByName.keySet());
        Collections.shuffle(exerciseNames, random);
        
        List<Exercise> selected = new ArrayList<>();
        for (int i = 0; i < Math.min(count, exerciseNames.size()); i++) {
            String name = exerciseNames.get(i);
            List<Exercise> variants = exercisesByName.get(name);
            // Randomly select a variant (DB/BB/etc)
            selected.add(variants.get(random.nextInt(variants.size())));
        }
        
        return selected;
    }
}
