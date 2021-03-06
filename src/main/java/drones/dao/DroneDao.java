package drones.dao;

import drones.beans.Drone;

import java.sql.Date;
import java.util.Map;
import java.util.Set;

public interface DroneDao {
    boolean addDrone(Drone drone);
    boolean updateDrone(Drone drone);

    void deleteDrone(int id);

    Set<Drone> getDrones(String sql, Map<Integer,Object> values);

}
