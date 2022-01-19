package airport;

import java.util.Random;

public class Airplane implements Runnable {
    private static int id = 1000;
    private static Object mutex = new Object();
    private int planeID;

    public Airplane() {
        this.planeID = ++id;
    }

    public void takeOff() {
        System.out.println("Plane id#" + this.planeID + " is taking off");
    }

    public void fly() {
        int flyTime = (int) (Math.random() * 5000) + 5000;
        System.out.println("Airplane #" + this.planeID + " in the air for " + flyTime);
        try {
            Thread.sleep(flyTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void land() {
        System.out.println("Plane id#" + this.planeID + " is landing");
    }

    @Override
    public void run() {
        //System.out.println("Plane id #" + this.planeID + " wants to take of");
        synchronized (mutex) {
            takeOff();
        }
        //System.out.println("Plane id #" + this.planeID + " has took off");
        fly();
        //System.out.println("Plane id #" + this.planeID + " wants to land");
        synchronized (mutex) {
            land();
        }
        //System.out.println("Plane id #" + this.planeID + " has landed");
    }
}
