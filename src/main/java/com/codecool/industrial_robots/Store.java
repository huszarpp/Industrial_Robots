package com.codecool.industrial_robots;

import com.codecool.industrial_robots.robots.Robot;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Robot> robots = new ArrayList<>();
    private int waitingItems = 0;

    public void addNewRobot(Robot newRobot) {
        robots.add(newRobot);
    }

    public void simulateOneDay(int numOfNewItems, int batteryCharge) {
        System.out.println(numOfNewItems + " items arrived today.");
        System.out.println(batteryCharge + " levels charging for all robots.");

        waitingItems += numOfNewItems;
        System.out.println(this.toString());

        for (Robot robot : robots) {
            System.out.println(robot.getName() + " BEFORE delivery:");
            System.out.println(robot.toString());

            robot.workForOneDay(waitingItems, batteryCharge);
            waitingItems -= robot.getCurrentLoad();

            System.out.println(robot.getName() + " AFTER delivery:");
            System.out.println(robot.toString());
        }

        System.out.println(this.toString());
        System.out.println();
    }

    @Override
    public String toString() {
        return waitingItems + " items are waiting for delivery.";
    }
}
