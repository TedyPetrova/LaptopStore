package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.text.TableView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent mainScene = FXMLLoader.load(getClass().getResource("SceneMain.fxml"));
        primaryStage.setTitle("Laptop Store");
        primaryStage.setScene(new Scene(mainScene, 590, 400));
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
