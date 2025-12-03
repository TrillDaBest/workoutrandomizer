package com.workoutrandomizer;

public class Exercise {
    private String name;
    private String equipment;
    private String category;

    public Exercise(String name, String equipment, String category) {
        this.name = name;
        this.equipment = equipment;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " (" + equipment + ")";
    }
}
