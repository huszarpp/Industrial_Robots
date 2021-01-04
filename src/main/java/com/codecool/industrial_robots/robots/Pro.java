package com.codecool.industrial_robots.robots;

public class Pro extends Robot{

    public Pro(String name, int currentBatteryLevel) {
        super(name, 12, 8, currentBatteryLevel);
    }

    @Override
    int calculateBatteryDecrease(int load) {
        if (load <= 5) {
            return load;
        }
        return 5 + (load % 5) * 2;
    }
}