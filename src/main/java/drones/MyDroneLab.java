package drones;

import drones.DB.DBmanager;
import drones.DB.DBtools;
import drones.DB.SQLexamples;
import drones.beans.Customer;
import drones.beans.Drone;
import drones.beans.Student;
import drones.dao.CustomerDao;
import drones.dbdao.Customer_mysql;
import drones.dbdao.Drone_mysql;
import drones.jobs.RepairScanner;

import java.util.*;

public class MyDroneLab {
    public static void main(String[] args) {
        //Student student=new Student(0,"momo","054-234-4321","ness-ziona","java fill stack");
        //System.out.println(SQLexamples.addStudent(student)?"Student added successfully":"Attempt failed");
        //System.out.println(SQLexamples.removeById(10)?"Student removed successfully":"Student removal failed");
        boolean isSuccess= DBtools.runQuery(DBmanager.CREATE_CUSTOMERS_TABLE);
        System.out.println("is success?: " + isSuccess);
        isSuccess=DBtools.runQuery(DBmanager.CREATE_DRONES_TABLE);
        System.out.println("is success?: " + isSuccess);

        //Customer customer=new Customer(0,"shimi","054-611-1234","rishon-lezion",false,true);
        CustomerDao dbCustomer =new Customer_mysql();
        //isSuccess=customerDao.addCustomer(customer);
        //System.out.println("is success?: " + isSuccess);
        Map<Integer,Object> values=new HashMap<>();
        values.put(1,1);
        List<Customer> customerList =dbCustomer.getCustomers(DBmanager.GET_SINGLE_CUSTOMER,values);
        customerList.forEach(System.out::println);
        //Customer customer=customerDao.getCustomerById(1);
        //System.out.println(customer==null?"User not found":customer);


        //this is for the drones
        Drone_mysql droneDBdao=new Drone_mysql();
        Set<Drone> drones=droneDBdao.getAllDrones();
        RepairScanner droneScanner=new RepairScanner(drones);
        Thread droneTheard=new Thread(droneScanner);
        droneTheard.start();



    }
}
