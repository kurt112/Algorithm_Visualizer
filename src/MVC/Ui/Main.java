package MVC.Ui;

import MVC.Conroller.MainBorder;
import Visualizer_Settings.Visualizer_Properties;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

//        Settings_Scence/SettingMain_Ui.fxml
        FXMLLoader loader = new FXMLLoader();
        Parent parent = loader.load(getClass().getResource("MainBorder_Ui.fxml"));

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();


    }
}