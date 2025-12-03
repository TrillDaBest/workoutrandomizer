@echo off
REM Build script for Workout Randomizer (Windows)

echo === Building Workout Randomizer ===

REM Clean previous build
echo Cleaning previous build...
if exist bin rmdir /s /q bin
mkdir bin

REM Compile source files
echo Compiling Java source files...
javac -d bin src\com\workoutrandomizer\model\*.java src\com\workoutrandomizer\data\*.java src\com\workoutrandomizer\gui\*.java

if errorlevel 1 (
    echo Compilation failed!
    exit /b 1
)

echo Compilation successful!

REM Create manifest
echo Creating manifest...
echo Manifest-Version: 1.0 > MANIFEST.MF
echo Main-Class: com.workoutrandomizer.gui.WorkoutRandomizerGUI >> MANIFEST.MF

REM Build JAR
echo Building JAR file...
jar cvfm WorkoutRandomizer.jar MANIFEST.MF -C bin .

if errorlevel 1 (
    echo JAR creation failed!
    exit /b 1
)

echo === Build Complete ===
echo Run with: java -jar WorkoutRandomizer.jar
