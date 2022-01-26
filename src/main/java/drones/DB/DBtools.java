package drones.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBtools {
    public static void runQuery(String sql) {
        Connection connection=null;

        try{
            connection= ConnectionPool.getInstance().getConnection();
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.execute();
        }catch(SQLException|InterruptedException err){
            System.out.println(err.getMessage());
        }finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }
}
