package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Orders {
    String sql;
    Connection conn;
    int result;
    ResultSet rs;
    public void showAll(){
        sql = "SELECT * FROM orders";
        try {
            conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("idOfOrder"));
                System.out.println(rs.getString("dateOfOrder"));
                System.out.println(rs.getString("laptops_Product_id"));
                System.out.println(rs.getString("customers_Customer_id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void search(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id of the order you want to see:");
        int id = input.nextInt();
        sql = "SELECT * FROM orders WHERE idOfOrder = " + "'" +id+"'";
        try {
            conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("idOfOrder"));
                System.out.println(rs.getString("dateOfOrder"));
                System.out.println(rs.getString("laptops_Product_id"));
                System.out.println(rs.getString("customers_Customer_id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void insert(){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert the order id, date, id of laptop and customer id:");
        int orderID = input.nextInt();
        String date = input.next();
        String laptopID = input.next();
        String customerID = input.next();
        sql = "INSERT INTO orders (idOfOrder, dateOfOrder, laptops_Product_id, customers_Customer_id) VALUES ('" +orderID+ "',"+"'"+date+"',"+"'"+laptopID+"',"+"'"+customerID+"')";
        try {
            conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            System.out.println("Element inserted.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void delete(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id of the order you want to delete:");
        int id = input.nextInt();
        sql = "DELETE FROM orders WHERE idOfOrder = " +id;
        try {
            conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            System.out.println("Element deleted.");
            // loop through the result set
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void modify(){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert the order id of the order you want to modify, the column you want to change, and the new value:");
        int id = input.nextInt();
        String column = input.next();
        String newValue = input.next();
        sql = "UPDATE orders SET "+column+"="+"'"+newValue+"'"+"WHERE idOfOrder ="+id;
        try {
            conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            System.out.println("Element modified.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
