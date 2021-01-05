package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML private TableView<LaptopsRows> tableLaptops;
    @FXML private TableColumn<LaptopsRows, String> col_Product_id;
    @FXML private TableColumn<LaptopsRows, String> col_Brand;
    @FXML private TableColumn<LaptopsRows, String> col_Model;
    @FXML private TableColumn<LaptopsRows, String> col_Processor;
    @FXML private TableColumn<LaptopsRows, String> col_RAM;
    @FXML private TableColumn<LaptopsRows, String> col_OS;
    @FXML private TextField id_field;
    @FXML private TextField brand_field;
    @FXML private TextField model_field;
    @FXML private TextField processor_field;
    @FXML private TextField RAM_field;
    @FXML private TextField OS_field;
    @FXML public TextField searchProductID_field;
    @FXML private Tab orders;
    @FXML private Tab representatives;
    @FXML private Button logOut;
    Stage modifyLaptopStage;
    Scene modifyLaptopScene;
    String sql;
    Connection conn;
    int result;
    ResultSet rs;
    ObservableList<LaptopsRows> laptopsList = FXCollections.observableArrayList();
    public void logOutAction() throws Exception{
            Stage stage;
            Parent primaryStage;
            stage = (Stage) logOut.getScene().getWindow();
            primaryStage = FXMLLoader.load(getClass().getResource("SceneMain.fxml"));
            Scene scene = new Scene(primaryStage);
            stage.setScene(scene);
            stage.show();
        }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateLaptops();
    }
    public void populateLaptops(){
        laptopsList.clear();
        try {
            Connection conn = MySQLConnection.getConnection();
            rs = conn.createStatement().executeQuery("SELECT * FROM laptops");
            while (rs.next()){
                laptopsList.add(new LaptopsRows(rs.getString("Product_id"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Processor"), rs.getString("RAM"), rs.getString("OS")));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        col_Product_id.setCellValueFactory(new PropertyValueFactory<>("Product_id"));
        col_Brand.setCellValueFactory(new PropertyValueFactory<>("Brand"));
        col_Model.setCellValueFactory(new PropertyValueFactory<>("Model"));
        col_Processor.setCellValueFactory(new PropertyValueFactory<>("Processor"));
        col_OS.setCellValueFactory(new PropertyValueFactory<>("OS"));
        col_RAM.setCellValueFactory(new PropertyValueFactory<>("RAM"));
        tableLaptops.setItems(laptopsList);
    }
    public void addLaptop(){
        sql = "INSERT INTO laptops (Product_id, Brand, Model, Processor, RAM, OS) VALUES ('" +id_field.getText()+ "',"+"'"+brand_field.getText()+"',"+"'"+model_field.getText()+"',"+"'"+processor_field.getText()+"',"+"'"+RAM_field.getText()+"',"+"'"+OS_field.getText()+"')";
        try {
            conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        populateLaptops();
        id_field.clear();
        brand_field.clear();
        model_field.clear();
        processor_field.clear();
        RAM_field.clear();
        OS_field.clear();
    }
    public void deleteLaptop(){
        sql = "DELETE FROM laptops WHERE Product_id = " +searchProductID_field.getText();
        try {
            conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            // loop through the result set
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        populateLaptops();
        searchProductID_field.clear();
    }
    public void searchLaptop(){
        ObservableList<LaptopsRows> filteredLaptops = FXCollections.observableArrayList();
        sql = "SELECT * FROM laptops WHERE Product_id = " +searchProductID_field.getText();
        try {
            conn = MySQLConnection.getConnection();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                filteredLaptops.add(new LaptopsRows(rs.getString("Product_id"), rs.getString("Brand"), rs.getString("Brand"), rs.getString("Processor"), rs.getString("RAM"), rs.getString("OS")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        col_Product_id.setCellValueFactory(new PropertyValueFactory<>("Product_id"));
        col_Brand.setCellValueFactory(new PropertyValueFactory<>("Brand"));
        col_Model.setCellValueFactory(new PropertyValueFactory<>("Model"));
        col_Processor.setCellValueFactory(new PropertyValueFactory<>("Processor"));
        col_OS.setCellValueFactory(new PropertyValueFactory<>("OS"));
        col_RAM.setCellValueFactory(new PropertyValueFactory<>("RAM"));
        tableLaptops.setItems(filteredLaptops);
    }
    public void clearSearchLaptops(){
        searchProductID_field.clear();
        tableLaptops.setItems(laptopsList);
    }
    public void modifyLaptopButton() throws IOException {
        modifyLaptopStage = new Stage();
        modifyLaptopScene = new Scene(FXMLLoader.load(getClass().getResource("ModifyLaptop.fxml")));
        modifyLaptopStage.initStyle(StageStyle.UNDECORATED);
        modifyLaptopStage.getScene();
        modifyLaptopStage.setScene(modifyLaptopScene);
        modifyLaptopStage.show();
    }
}
