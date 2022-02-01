package drones.dbdao;

import drones.DB.DBmanager;
import drones.DB.DBtools;
import drones.beans.Drone;
import drones.dao.DroneDao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        Map<Integer,Object> values=new HashMap<>();
        values.put(1,drone.getCustomer_id());
        values.put(2,drone.getManufacturer());
        values.put(3,drone.getModel());
        values.put(4,drone.getEta());
        values.put(5,drone.getEntered());
        values.put(6,drone.getId());
        return DBtools.runQuery(DBmanager.CREATE_DRONE,values);

    }

    @Override
    public void deleteDrone(int id) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, id);
        DBtools.runQuery(DBmanager.DELETE_DRONE, values);
    }

    @Override
    public Set<Drone> getDrones(String sql,Map<Integer,Object> values) {
        //create comperator
        Set<Drone> drones= new TreeSet<Drone>();
        ResultSet resultSet = DBtools.runQueryForResult(sql,values);
        try{
            while(resultSet.next()){
                Drone drone=new Drone(
                        resultSet.getInt("id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getString("manufacturer"),
                        resultSet.getString("model"),
                        resultSet.getDate("eta"),
                        resultSet.getDate("entered")
                );
                drones.add(drone);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return drones;
    }
}
