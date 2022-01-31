package drones.dao;

import drones.beans.Customer;

import java.util.List;
import java.util.HashMap;

import java.util.Map;

public interface CustomerDao {
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);

    void deleteCustomer(int id);

    List<Customer> getCustomers(String sql,Map<Integer,Object> values);

}
