package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LogInController {
    @FXML private TextField adminUsername_field;
    @FXML private PasswordField adminPass_field;
    @FXML Button LogInAdmin;
    @FXML private Label invalidLoginAdmin;
    Scene sceneAdmin;
    String sql;
    Connection conn;
    int result;
    ResultSet rs;
    Stage stage;
    Parent adminStage;

    public void exit(){
        System.exit(1);
    }
    public void LogInAdminAction() throws Exception {
        if(adminUsername_field.getText().equals("Tedy") && adminPass_field.getText().equals("pass")){
            stage = (Stage) LogInAdmin.getScene().getWindow();
            adminStage = FXMLLoader.load(getClass().getResource("SceneAdmin.fxml"));
            Scene scene = new Scene(adminStage);
            stage.setScene(scene);
            stage.show();
        }
        else{
            invalidLoginAdmin.setText("Invalid login");
        }
    }
}
