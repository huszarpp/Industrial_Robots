package com.codecool.industrial_robots.robots;

public class Eco extends Robot{

    public Eco(String name, int currentBatteryLevel) {
        super(name, 4, 6, currentBatteryLevel);
    }

    @Override
    int calculateBatteryDecrease(int load) {
        return (load + 1) / 2;
    }
}