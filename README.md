# Workout Randomizer

A Java Swing application that randomizes workout exercises based on the bro split training method. Features a dark-themed GUI inspired by the Skeet CSGO interface.

## Features

- **Bro Split Selection**: Choose from 5 different workout splits:
  - Legs
  - Back/Biceps
  - Chest/Triceps
  - Shoulder/Biceps
  - Shoulder/Triceps

- **Exercise Randomization**: Generates random exercises using both dumbbell and barbell variations
- **Modern GUI**: Dark-themed interface with a clean, modern design inspired by Skeet CSGO

## Requirements

- Java 11 or higher
- Maven 3.6 or higher

## Building

```bash
mvn clean package
```

## Running

**Using the convenience script (Linux/Mac):**
```bash
./run.sh
```

**Or manually:**
```bash
java -jar target/workout-randomizer-1.0-SNAPSHOT.jar
```

**Or using Maven:**
```bash
mvn compile exec:java -Dexec.mainClass="com.workoutrandomizer.WorkoutRandomizerApp"
```

## Usage

1. Select a workout split from the dropdown menu
2. Click the "RANDOMIZE" button
3. View your randomized workout exercises with equipment type
4. Click "RANDOMIZE" again to generate a new workout combination

## Exercise Categories

The application includes a comprehensive database of exercises for:
- **Legs**: Squats, lunges, Bulgarian split squats, Romanian deadlifts
- **Back**: Rows, deadlifts, T-bar rows
- **Biceps**: Curls, preacher curls, hammer curls, concentration curls
- **Chest**: Bench press, incline press, decline press, flyes
- **Triceps**: Close-grip bench press, overhead extensions, skull crushers, kickbacks
- **Shoulders**: Overhead press, lateral raises, front raises, upright rows, reverse flyes

Each exercise has both dumbbell and barbell variations where applicable.