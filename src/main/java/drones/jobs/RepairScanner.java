package drones.jobs;

import drones.beans.Drone;

import java.sql.Date;
import java.util.Set;
import java.util.Random;

public class RepairScanner implements Runnable {
    private Set<Drone> drones;
    private boolean isRunning;

    public RepairScanner(Set<Drone> drones){
        this.drones=drones;
        this.isRunning=true;
    }

    public void stopScanner(){
        this.isRunning=false;
    }

    @Override
    public void run() {
        while(true){
            for (Drone item:drones) {
                if(!item.isPopped()){
                    if(item.getEta().before(new Date(System.currentTimeMillis()))){
                        item.setPopped(true);
                        System.out.println("drone is ready!!!\n============");
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int counter = 0; counter <3 ; counter++) {
                                    try{Thread.sleep(30_000);}catch( InterruptedException e){
                                        System.out.println(e.getMessage());
                                    }
                                }

                            }
                        }).start();
                    }
                }
            }
            try {
                Thread.sleep(1000*60*60*24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
