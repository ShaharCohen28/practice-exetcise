package drones.dbdao;

import drones.DB.DBmanager;
import drones.DB.DBtools;
import drones.beans.Drone;
import drones.dao.DroneDao;

import java.sql.Date;
import java.util.*;

public class Drone_mysql implements DroneDao {
    @Override
    public boolean addDrone(Drone drone) {
        Map<Integer,Object> values=new HashMap<>();
        values.put(1,drone.getCustomer_id());
        values.put(2,drone.getManufacturer());
        values.put(3,drone.getModel());
        values.put(4,drone.getEta());
        values.put(5,drone.getEntered());
        return DBtools.runQuery(DBmanager.CREATE_DRONE,values);
    }

    @Override
    public boolean updateDrone(Drone drone) {
        return false;
    }

    @Override
    public void deleteDrone(int id) {

    }

    @Override
    public Set<Drone> getAllDrones() {
        //create comperator
        Set<Drone> drones= new TreeSet<>();
        return drones;
    }
}
