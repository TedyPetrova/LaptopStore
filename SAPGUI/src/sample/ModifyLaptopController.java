package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ModifyLaptopController extends AdminController  implements Initializable {
    @FXML private ChoiceBox<String> choiceBoxLaptops;
    @FXML private TextField productID_field;
    @FXML private TextField newValueLaptop_field;
    @FXML private Button closeButton;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setChoiceBoxLaptops();
    }
    public void setChoiceBoxLaptops(){
        choiceBoxLaptops.getItems().add("Brand");
        choiceBoxLaptops.getItems().add("Model");
        choiceBoxLaptops.getItems().add("Processor");
        choiceBoxLaptops.getItems().add("RAM");
        choiceBoxLaptops.getItems().add("OS");
        choiceBoxLaptops.setValue("Brand");
    }
    public void modifyButtonAction(){
        if(choiceBoxLaptops.getValue()=="Brand"){
            sql = "UPDATE laptops SET "+choiceBoxLaptops.getValue()+"="+"'"+newValueLaptop_field.getText()+"'"+"WHERE Product_id ="+productID_field.getText();
            try {
                conn = MySQLConnection.getConnection();
                Statement stmt = conn.createStatement();
                result = stmt.executeUpdate(sql);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
    public void closeButtonAction(){
        modifyLaptopStage = (Stage) closeButton.getScene().getWindow();
        modifyLaptopStage.hide();
    }
}
