#!/bin/bash
# Build script for Workout Randomizer

echo "=== Building Workout Randomizer ==="

# Clean previous build
echo "Cleaning previous build..."
rm -rf bin
mkdir bin

# Compile source files
echo "Compiling Java source files..."
javac -d bin src/com/workoutrandomizer/model/*.java src/com/workoutrandomizer/data/*.java src/com/workoutrandomizer/gui/*.java

if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi

echo "Compilation successful!"

# Create manifest
echo "Creating manifest..."
echo "Manifest-Version: 1.0" > MANIFEST.MF
echo "Main-Class: com.workoutrandomizer.gui.WorkoutRandomizerGUI" >> MANIFEST.MF

# Build JAR
echo "Building JAR file..."
jar cvfm WorkoutRandomizer.jar MANIFEST.MF -C bin .

if [ $? -ne 0 ]; then
    echo "JAR creation failed!"
    exit 1
fi

echo "=== Build Complete ==="
echo "Run with: java -jar WorkoutRandomizer.jar"
