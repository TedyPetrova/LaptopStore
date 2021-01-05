package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Customers {
    String sql;
    Connection conn;
    int result;
    ResultSet rs;
    public void showAll(){
        sql = "SELECT * FROM customers";
        try {
            conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("Customer_id"));
                System.out.println(rs.getString("Name"));
                System.out.println(rs.getString("Email"));
                System.out.println(rs.getString("Phone"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void search(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id of the customer you want to see:");
        int id = input.nextInt();
        sql = "SELECT * FROM customers WHERE Customer_id = " + "'" +id+"'";
        try {
            conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("Customer_id"));
                System.out.println(rs.getString("Name"));
                System.out.println(rs.getString("Email"));
                System.out.println(rs.getString("Phone"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void insert(){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert the customer id, name, e-mail and phone of the customer:");
        int customerID = input.nextInt();
        String name = input.next();
        String email = input.next();
        int phone = input.nextInt();
        sql = "INSERT INTO customers (Customer_id, Name, Email, Phone) VALUES ('" +customerID+ "',"+"'"+name+"',"+"'"+email+"',"+"'"+phone+"')";
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
        System.out.println("Enter the id of the customer you want to delete:");
        int id = input.nextInt();
        sql = "DELETE FROM customers WHERE Customer_id = " +id;
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
        System.out.println("Insert the customer id of the customer you want to modify, the column you want to change, and the new value:");
        int id = input.nextInt();
        String column = input.next();
        String newValue = input.next();
        sql = "UPDATE customers SET "+column+"="+"'"+newValue+"'"+"WHERE Customer_id ="+id;
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
