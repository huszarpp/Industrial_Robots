package com.codecool.industrial_robots.robots;

public class Mac extends Robot{

    public Mac(String name, int currentBatteryLevel) {
        super(name, 10, 10, currentBatteryLevel);
    }

    @Override
    int calculateBatteryDecrease(int load) {
        return load;
    }
}
