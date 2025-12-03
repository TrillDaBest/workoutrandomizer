# Workout Randomizer

A Java Swing application that generates randomized workout plans for bro split training, featuring a sleek CS:GO Skeet-inspired GUI.

## Features

- **5 Workout Splits:**
  - Legs
  - Back/Biceps
  - Chest/Triceps
  - Shoulders/Biceps
  - Shoulders/Triceps

- **Exercise Randomization:**
  - Randomly selects 4-6 exercises per workout
  - Automatically randomizes between dumbbell and barbell variants
  - Comprehensive exercise database with proper categorization

- **Skeet-Style GUI:**
  - Dark background (#0d0d0d) with cyan accents (#00bfff)
  - Clean sidebar navigation
  - Sharp, minimal design with flat UI elements
  - Monospace font (Consolas) for tech aesthetic
  - Hover effects and visual feedback

## Screenshots

### Initial View
![Workout Randomizer Initial View](https://github.com/user-attachments/assets/e7e4106d-d673-47a4-abd2-4275bdcd2568)

### Generated Workout
![Generated Workout Example](https://github.com/user-attachments/assets/fa0ab649-cf26-4400-98ec-29bb6fde4621)

## How to Run

### Prerequisites
- Java 17 or higher

### Running from Source
```bash
# Compile the application
javac -d bin src/com/workoutrandomizer/model/*.java src/com/workoutrandomizer/data/*.java src/com/workoutrandomizer/gui/*.java

# Run the application
java -cp bin com.workoutrandomizer.gui.WorkoutRandomizerGUI
```

### Building JAR
```bash
# Create manifest file
echo "Manifest-Version: 1.0" > MANIFEST.MF
echo "Main-Class: com.workoutrandomizer.gui.WorkoutRandomizerGUI" >> MANIFEST.MF

# Build JAR
jar cvfm WorkoutRandomizer.jar MANIFEST.MF -C bin .

# Run JAR
java -jar WorkoutRandomizer.jar
```

## Usage

1. **Select a Workout Split:** Click on any split in the left sidebar (Legs, Back/Biceps, etc.)
2. **Generate Workout:** Click the "GENERATE WORKOUT" button
3. **View Your Workout:** The app will display 4-6 randomized exercises with DB/BB variants
4. **Repeat:** Click "GENERATE WORKOUT" again for a new randomized workout

## Exercise Database

The app includes exercises for all major muscle groups:

- **Chest:** Bench Press, Incline Press, Flyes, Decline Press
- **Back:** Rows, Deadlifts, Pullovers, Shrugs
- **Shoulders:** Overhead Press, Lateral Raises, Front Raises, Rear Delt Flyes
- **Biceps:** Curls, Hammer Curls, Preacher Curls
- **Triceps:** Skull Crushers, Tricep Extensions, Close Grip Bench
- **Legs:** Squats, Lunges, Romanian Deadlifts, Calf Raises, Leg Press

Each exercise (where applicable) has both dumbbell (DB) and barbell (BB) variants that are randomly selected.

## Project Structure

```
src/
└── com/
    └── workoutrandomizer/
        ├── model/          # Data models (Exercise, EquipmentType, MuscleGroup, WorkoutSplit)
        ├── data/           # Exercise database and workout generator
        └── gui/            # Swing GUI components and theme
```

## License

This project is open source and available for personal use.
