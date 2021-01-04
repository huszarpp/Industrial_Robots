package com.codecool.industrial_robots;


import com.codecool.industrial_robots.robots.Eco;
import com.codecool.industrial_robots.robots.Mac;
import com.codecool.industrial_robots.robots.Pro;
import com.codecool.industrial_robots.robots.Robot;

public class StoreSimulator {

    public static void main(String[] args) {

        Store store = new Store();

        Robot robot1 = new Mac("R2", 4);
        Robot robot2 = new Eco("3CPO", 3);
        Robot robot3 = new Pro("BB8", 10);
        Robot robot4 = new Eco("E12", 4);

        store.addNewRobot(robot1);
        store.addNewRobot(robot2);
        store.addNewRobot(robot3);
        store.addNewRobot(robot4);

        int[] items = {20, 32, 20, 16};
        int[] charges = {3, 2, 5, 3};

        for (int i = 0; i < 4; i++) {
            System.out.println("DAY " + (i +1));
            store.simulateOneDay(items[i], charges[i]);
        }
    }
}
