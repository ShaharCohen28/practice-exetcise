package drones.DB;

import drones.beans.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLexamples {
    private static final  String ADD_STUDENT="INSERT INTO `class146`.`student` " +
            "(name,phone,city,course) " +
            "VALUES (?,?,?,?)";
    private static final String DELETE_STUDENT_BY_ID = "" +
            "DELETE FROM `class146`.`student` WHERE id=?";

    public static boolean addStudent(Student student){
        Connection connection=null;
        try{
            connection= ConnectionPool.getInstance().getConnection();
            PreparedStatement statement= connection.prepareStatement(ADD_STUDENT);
            statement.setString(1,student.getName());
            statement.setString(2,student.getPhone());
            statement.setString(3,student.getCity());
            statement.setString(4,student.getCourse());
            statement.execute();
            return true;
        }catch (InterruptedException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }

    public static boolean removeById(int id){
        Connection connection=null;
        try{
            connection=ConnectionPool.getInstance().getConnection();
            PreparedStatement statement= connection.prepareStatement(DELETE_STUDENT_BY_ID);
            statement.setInt(1,id);
            statement.execute();
            return true;
        }catch(InterruptedException | SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }
}
