package com.codecool.industrial_robots.robots;

public abstract class Robot {

    private final String name;
    private final int maxBatteryLevel;
    private final int maxCapacity;
    private int currentBatteryLevel;
    private int currentLoad = 0;

    public Robot(String name, int maxBatteryLevel, int maxCapacity, int currentBatteryLevel) {
        this.name = name;
        this.maxBatteryLevel = maxBatteryLevel;
        this.maxCapacity = maxCapacity;
        this.currentBatteryLevel = currentBatteryLevel;
    }

    abstract int calculateBatteryDecrease(int load);

    int calculateCurrentLoad(int waitingItems) {
        int maxLoadForCurrentDay = Math.min(waitingItems, getMaxCapacity());
        int batteryDecreaseForCurrentDay = calculateBatteryDecrease(maxLoadForCurrentDay);
        while (batteryDecreaseForCurrentDay > getCurrentBatteryLevel()) {
            maxLoadForCurrentDay--;
            batteryDecreaseForCurrentDay = calculateBatteryDecrease(maxLoadForCurrentDay);
        }
        return maxLoadForCurrentDay;
    }

    public void workForOneDay(int waitingItems, int batteryCharge) {
        chargeBattery(batteryCharge);
        setCurrentLoad(calculateCurrentLoad(waitingItems));
        setCurrentBatteryLevel(getCurrentBatteryLevel() - calculateBatteryDecrease(currentLoad));
    }

    void chargeBattery(int chargedLevels) {
        setCurrentBatteryLevel(Math.min(getCurrentBatteryLevel() + chargedLevels, getMaxBatteryLevel()));
    }

    @Override
    public String toString() {
        return "Type: " + getClass().getSimpleName() +
                ", Name: " + getName() +
                ", Max battery level: " + getMaxBatteryLevel() +
                ", Current battery level: " + getCurrentBatteryLevel() +
                ", Max capacity: " + getMaxCapacity() +
                ", Current load: " + getCurrentLoad();
    }

    public String getName() {
        return name;
    }

    public int getMaxBatteryLevel() {
        return maxBatteryLevel;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentBatteryLevel() {
        return currentBatteryLevel;
    }

    public void setCurrentBatteryLevel(int currentBatteryLevel) {
        this.currentBatteryLevel = currentBatteryLevel;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(int currentLoad) {
        this.currentLoad = currentLoad;
    }
}
