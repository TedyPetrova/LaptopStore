package sample;

import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Laptops {
    String sql;
    Connection conn;
    int result;
    ResultSet rs;
    public void showAll(){
        sql = "SELECT * FROM laptops";
        try {
            conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                LaptopsRows l1 = new LaptopsRows(rs.getString("Product_id"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Processor"), rs.getString("RAM"), rs.getString("OS"));
                TableView<LaptopsRows> tableLaptops = new TableView<>();
                tableLaptops.setEditable(true);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void search(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id of the laptop you want to see:");
        int id = input.nextInt();
        sql = "SELECT * FROM laptops WHERE Product_id = " + "'" +id+"'";
        try {
            conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("Product_id"));
                System.out.println(rs.getString("Brand"));
                System.out.println(rs.getString("Model"));
                System.out.println(rs.getString("Processor"));
                System.out.println(rs.getString("RAM"));
                System.out.println(rs.getString("OS"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void insert(){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert the product id, brand, model, processor, RAM and OS of the pc you want to enter:");
        int productID = input.nextInt();
        String brand = input.next();
        String model = input.next();
        String processor = input.next();
        int RAM = input.nextInt();
        String OS = input.next();
        sql = "INSERT INTO laptops (Product_id, Brand, Model, Processor, RAM, OS) VALUES ('" +productID+ "',"+"'"+brand+"',"+"'"+model+"',"+"'"+processor+"',"+"'"+RAM+"',"+"'"+OS+"')";
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
        System.out.println("Enter the id of the laptop you want to delete:");
        int id = input.nextInt();
        sql = "DELETE FROM laptops WHERE Product_id = " +id;
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
        System.out.println("Insert the product id of the pc you want to modify, the column you want to change, and the new value:");
        int productID = input.nextInt();
        String column = input.next();
        String newValue = input.next();
        sql = "UPDATE laptops SET "+column+"="+"'"+newValue+"'"+"WHERE Product_id ="+productID;
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
