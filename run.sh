#!/bin/bash
# Build and run the Workout Randomizer application

echo "Building Workout Randomizer..."
mvn clean package

if [ $? -eq 0 ]; then
    echo "Build successful! Starting application..."
    java -jar target/workout-randomizer-1.0-SNAPSHOT.jar
else
    echo "Build failed. Please check the error messages above."
    exit 1
fi
