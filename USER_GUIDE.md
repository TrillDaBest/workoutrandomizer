# Workout Randomizer - User Guide

## Quick Start

1. **Launch the Application**
   ```bash
   java -jar WorkoutRandomizer.jar
   ```
   Or use the build script to compile and run from source.

2. **Select a Workout Split**
   - Click on any workout split in the left sidebar
   - Options: Legs, Back/Biceps, Chest/Triceps, Shoulders/Biceps, Shoulders/Triceps

3. **Generate Your Workout**
   - Click the "GENERATE WORKOUT" button
   - A randomized workout with 4-6 exercises will be displayed

4. **Get a New Workout**
   - Click "GENERATE WORKOUT" again for a different randomized workout

## Features Explained

### Workout Splits

**Legs**
- Focuses on all major leg muscle groups
- Includes: Squats, Lunges, Romanian Deadlifts, Calf Raises, Leg Press

**Back/Biceps**
- Combines back exercises with bicep accessories
- Back: Rows, Deadlifts, Pullovers, Shrugs
- Biceps: Curls, Hammer Curls, Preacher Curls

**Chest/Triceps**
- Pairs chest work with tricep exercises
- Chest: Bench Press, Incline Press, Flyes, Decline Press
- Triceps: Skull Crushers, Tricep Extensions, Close Grip Bench

**Shoulders/Biceps**
- Shoulder focus with bicep work
- Shoulders: Overhead Press, Lateral Raises, Front Raises, Rear Delt Flyes
- Biceps: Curls, Hammer Curls, Preacher Curls

**Shoulders/Triceps**
- Shoulder focus with tricep work
- Shoulders: Overhead Press, Lateral Raises, Front Raises, Rear Delt Flyes
- Triceps: Skull Crushers, Tricep Extensions, Close Grip Bench

### Equipment Randomization

The app automatically randomizes between equipment types:
- **DB** = Dumbbell
- **BB** = Barbell
- **Machine** = Machine (for exercises like Leg Press)

Each time you generate a workout, the app may select different equipment for the same exercise, providing variety in your training.

### Workout Structure

- **Exercise Count**: 4-6 exercises per workout
- **Sets**: 3-4 sets recommended (displayed in workout)
- **Reps**: 8-12 reps recommended (displayed in workout)
- **Distribution**: Exercises are distributed across muscle groups in the split

## Tips for Use

1. **Variety**: Generate multiple workouts to see different exercise combinations
2. **Progressive Overload**: Track your weights and increase over time
3. **Rest**: Allow 48-72 hours between training the same muscle groups
4. **Form**: Always prioritize proper form over weight

## Bro Split Training Schedule Example

- **Monday**: Chest/Triceps
- **Tuesday**: Back/Biceps
- **Wednesday**: Rest or Cardio
- **Thursday**: Shoulders/Biceps
- **Friday**: Legs
- **Saturday**: Shoulders/Triceps
- **Sunday**: Rest

## Building from Source

### Linux/Mac
```bash
./build.sh
```

### Windows
```cmd
build.bat
```

### Manual Build
```bash
# Compile
javac -d bin src/com/workoutrandomizer/model/*.java \
               src/com/workoutrandomizer/data/*.java \
               src/com/workoutrandomizer/gui/*.java

# Run
java -cp bin com.workoutrandomizer.gui.WorkoutRandomizerGUI
```

## Customization

To add your own exercises:
1. Open `src/com/workoutrandomizer/data/ExerciseDatabase.java`
2. Add new exercises in the `static` initialization block
3. Use the format: `exercises.add(new Exercise("Name", EquipmentType.TYPE, MuscleGroup.GROUP));`
4. Recompile the application

## System Requirements

- Java 17 or higher
- Any operating system that supports Java (Windows, macOS, Linux)
- Display resolution: Minimum 900x600 pixels

## Keyboard Shortcuts

- Standard window controls (Alt+F4 to close, etc.)
- Mouse navigation only (no custom keyboard shortcuts)

## Troubleshooting

**Application won't start**
- Verify Java 17+ is installed: `java -version`
- Ensure the JAR file is not corrupted
- Try running from source using the build script

**Display issues**
- The app uses a fixed window size (900x600)
- Ensure your display supports at least this resolution
- The app uses system fonts with monospace fallback

**No exercises showing**
- Click "GENERATE WORKOUT" button
- Ensure a workout split is selected (highlighted in cyan)

## Credits

- Inspired by CS:GO Skeet/Gamesense cheat menu aesthetic
- Built with Java Swing
- Exercise database includes common gym exercises with DB/BB variants
