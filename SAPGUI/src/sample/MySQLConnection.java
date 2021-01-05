package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
        import java.io.FileInputStream;
        import java.io.IOException;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.Properties;

public class MySQLConnection {
    Connection conn = null;
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:mysql://localhost:3306/laptopstore?useSSL=false";
            String user = "root";
            String password = "501219021";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } /*finally {
            try{
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }*/
        return conn;
    }
}