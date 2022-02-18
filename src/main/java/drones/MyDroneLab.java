package drones;

import drones.DB.DBmanager;
import drones.DB.DBtools;
import drones.DB.SQLexamples;
import drones.beans.Customer;
import drones.beans.Drone;
import drones.beans.Student;
import drones.dao.CustomerDao;
import drones.dao.DroneDao;
import drones.dbdao.Customer_mysql;
import drones.dbdao.Drone_mysql;
import drones.jobs.RepairScanner;

import java.sql.Date;
import java.util.*;

public class MyDroneLab {
    public static void main(String[] args) {
        String[] manufacturers = {"shahar drones inc.", "parrot", "dronix", "crash-me-not"};
        String[] models = {"2022", "2021", "2020", "2019", "2018"};
        Drone drone;
        DroneDao dbDrone = new Drone_mysql();
        boolean isSuccess = DBtools.runQuery(DBmanager.CREATE_CUSTOMERS_TABLE);
        System.out.println("is success?: " + isSuccess);
        isSuccess = DBtools.runQuery(DBmanager.CREATE_DRONES_TABLE);
        System.out.println("is success?: " + isSuccess);


        //Customer customer=new Customer(0,"shimi","054-611-1234","rishon-lezion",false,true);
        CustomerDao dbCustomer = new Customer_mysql();
        //isSuccess=customerDao.addCustomer(customer);
        //System.out.println("is success?: " + isSuccess);
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, 1);
        List<Customer> customerList = dbCustomer.getCustomers(DBmanager.GET_SINGLE_CUSTOMER, values);
        customerList.forEach(System.out::println);
        //adding drones
        /*
        for (int index = 0; index < 2*customerList.size() ; index++) {
            drone=new Drone(
                    0,
                    customerList.get(index% customerList.size()).getId(),
                    manufacturers[index% manufacturers.length],
                    models[index% models.length],
                    new Date(System.currentTimeMillis()+((int)(Math.random()*7))*(1000*60*60*24)),
                    new Date(System.currentTimeMillis())
            );
            isSuccess= dbDrone.addDrone(drone);
            System.out.println(drone);
        }


         */

        Map<Integer, Object> droneValues = new HashMap<>();
        droneValues.put(1, 1);
        Set<Drone> droneSet = dbDrone.getDrones(DBmanager.GET_ALL_DRONES, droneValues);
        droneSet.forEach(System.out::println);


        //System.out.println(customer==null?"User not found":customer);


        //this is for the drones

        //Drone_mysql droneDBdao=new Drone_mysql();
        //Set<Drone> drones=droneDBdao.getAllDrones();
        RepairScanner droneScanner=new RepairScanner(droneSet);
        Thread droneTheard=new Thread(droneScanner);
        droneTheard.start();


    }

}
