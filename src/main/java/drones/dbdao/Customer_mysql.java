package drones.dbdao;

import drones.DB.ConnectionPool;
import drones.DB.DBmanager;
import drones.DB.DBtools;
import drones.beans.Customer;
import drones.dao.CustomerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer_mysql implements CustomerDao {
    @Override
    public boolean addCustomer(Customer customer) {
        //(`name`, `phone`, `city`, `vip`, `urgent`)
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, customer.getName());
        values.put(2, customer.getPhone());
        values.put(3, customer.getCity());
        values.put(4, customer.isVip());
        values.put(5, customer.isUrgent());
        return DBtools.runQuery(DBmanager.CREATE_NEW_CUSTOMER, values);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, customer.getName());
        values.put(2, customer.getPhone());
        values.put(3, customer.getCity());
        values.put(4, customer.isVip());
        values.put(5, customer.isUrgent());
        values.put(6, customer.getId());
        return DBtools.runQuery(DBmanager.UPDATE_CUSTOMER, values);
    }

    @Override
    public void deleteCustomer(int id) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, id);
        DBtools.runQuery(DBmanager.DELETE_CUSTOMER, values);
    }

    @Override
    public List<Customer> getCustomers(String sql,Map<Integer,Object> values) {
        List<Customer> customers = new ArrayList<>();
        ResultSet resultSet = DBtools.runQueryForResult(sql,values);
        try {
            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("city"),
                        resultSet.getBoolean("vip"),
                        resultSet.getBoolean("urgent")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return customers;
    }
/*
    @Override
    public Customer getCustomerById(int id) {
        Customer customer = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(DBmanager.GET_SINGLE_CUSTOMER);
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            if(resultSet.next()){
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("city"),
                        resultSet.getBoolean("vip"),
                        resultSet.getBoolean("urgent")
                );
            }
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }

        return customer;
    }

 */
}
