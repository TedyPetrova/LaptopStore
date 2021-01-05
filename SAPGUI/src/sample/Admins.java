package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admins {
    String sql;
    Connection conn;
    int result;
    ResultSet rs;
    public void showAll(){
        sql = "SELECT * FROM administrators";
        try {
            conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("administrator_id"));
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
