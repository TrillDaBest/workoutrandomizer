package com.workoutrandomizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ExerciseDatabase {
    private static final List<Exercise> exercises = new ArrayList<>();
    private static final Random random = new Random();

    static {
        // Legs exercises
        exercises.add(new Exercise("Barbell Squats", "Barbell", "Legs"));
        exercises.add(new Exercise("Dumbbell Squats", "Dumbbell", "Legs"));
        exercises.add(new Exercise("Barbell Lunges", "Barbell", "Legs"));
        exercises.add(new Exercise("Dumbbell Lunges", "Dumbbell", "Legs"));
        exercises.add(new Exercise("Barbell Romanian Deadlifts", "Barbell", "Legs"));
        exercises.add(new Exercise("Dumbbell Romanian Deadlifts", "Dumbbell", "Legs"));
        exercises.add(new Exercise("Barbell Bulgarian Split Squats", "Barbell", "Legs"));
        exercises.add(new Exercise("Dumbbell Bulgarian Split Squats", "Dumbbell", "Legs"));

        // Back exercises
        exercises.add(new Exercise("Barbell Rows", "Barbell", "Back"));
        exercises.add(new Exercise("Dumbbell Rows", "Dumbbell", "Back"));
        exercises.add(new Exercise("Barbell Deadlifts", "Barbell", "Back"));
        exercises.add(new Exercise("Dumbbell Deadlifts", "Dumbbell", "Back"));
        exercises.add(new Exercise("Barbell T-Bar Rows", "Barbell", "Back"));
        exercises.add(new Exercise("Dumbbell Seal Rows", "Dumbbell", "Back"));

        // Biceps exercises
        exercises.add(new Exercise("Barbell Curls", "Barbell", "Biceps"));
        exercises.add(new Exercise("Dumbbell Curls", "Dumbbell", "Biceps"));
        exercises.add(new Exercise("Barbell Preacher Curls", "Barbell", "Biceps"));
        exercises.add(new Exercise("Dumbbell Hammer Curls", "Dumbbell", "Biceps"));
        exercises.add(new Exercise("Barbell EZ-Bar Curls", "Barbell", "Biceps"));
        exercises.add(new Exercise("Dumbbell Concentration Curls", "Dumbbell", "Biceps"));

        // Chest exercises
        exercises.add(new Exercise("Barbell Bench Press", "Barbell", "Chest"));
        exercises.add(new Exercise("Dumbbell Bench Press", "Dumbbell", "Chest"));
        exercises.add(new Exercise("Barbell Incline Press", "Barbell", "Chest"));
        exercises.add(new Exercise("Dumbbell Incline Press", "Dumbbell", "Chest"));
        exercises.add(new Exercise("Barbell Decline Press", "Barbell", "Chest"));
        exercises.add(new Exercise("Dumbbell Decline Press", "Dumbbell", "Chest"));
        exercises.add(new Exercise("Dumbbell Flyes", "Dumbbell", "Chest"));

        // Triceps exercises
        exercises.add(new Exercise("Barbell Close-Grip Bench Press", "Barbell", "Triceps"));
        exercises.add(new Exercise("Dumbbell Overhead Extension", "Dumbbell", "Triceps"));
        exercises.add(new Exercise("Barbell Skull Crushers", "Barbell", "Triceps"));
        exercises.add(new Exercise("Dumbbell Tricep Kickbacks", "Dumbbell", "Triceps"));
        exercises.add(new Exercise("Dumbbell Tricep Extension", "Dumbbell", "Triceps"));

        // Shoulder exercises
        exercises.add(new Exercise("Barbell Overhead Press", "Barbell", "Shoulder"));
        exercises.add(new Exercise("Dumbbell Shoulder Press", "Dumbbell", "Shoulder"));
        exercises.add(new Exercise("Barbell Front Raise", "Barbell", "Shoulder"));
        exercises.add(new Exercise("Dumbbell Lateral Raise", "Dumbbell", "Shoulder"));
        exercises.add(new Exercise("Dumbbell Front Raise", "Dumbbell", "Shoulder"));
        exercises.add(new Exercise("Barbell Upright Row", "Barbell", "Shoulder"));
        exercises.add(new Exercise("Dumbbell Reverse Flyes", "Dumbbell", "Shoulder"));
    }

    public static List<Exercise> getRandomExercises(String split, int count) {
        List<Exercise> filtered = new ArrayList<>();

        switch (split) {
            case "Legs":
                filtered = exercises.stream()
                    .filter(e -> e.getCategory().equals("Legs"))
                    .collect(Collectors.toList());
                break;
            case "Back/Biceps":
                filtered = exercises.stream()
                    .filter(e -> e.getCategory().equals("Back") || e.getCategory().equals("Biceps"))
                    .collect(Collectors.toList());
                break;
            case "Chest/Triceps":
                filtered = exercises.stream()
                    .filter(e -> e.getCategory().equals("Chest") || e.getCategory().equals("Triceps"))
                    .collect(Collectors.toList());
                break;
            case "Shoulder/Biceps":
                filtered = exercises.stream()
                    .filter(e -> e.getCategory().equals("Shoulder") || e.getCategory().equals("Biceps"))
                    .collect(Collectors.toList());
                break;
            case "Shoulder/Triceps":
                filtered = exercises.stream()
                    .filter(e -> e.getCategory().equals("Shoulder") || e.getCategory().equals("Triceps"))
                    .collect(Collectors.toList());
                break;
            default:
                // Return empty list for invalid split
                break;
        }

        List<Exercise> result = new ArrayList<>();
        List<Exercise> available = new ArrayList<>(filtered);
        
        for (int i = 0; i < Math.min(count, filtered.size()); i++) {
            int index = random.nextInt(available.size());
            result.add(available.remove(index));
        }

        return result;
    }

    public static String[] getSplits() {
        return new String[]{"Legs", "Back/Biceps", "Chest/Triceps", "Shoulder/Biceps", "Shoulder/Triceps"};
    }
}
