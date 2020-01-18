package MVC.Ui;


import MVC.Conroller.Settings_Controller.ColorAnimation_Controller;
import MVC.Conroller.Settings_Controller.MapSizeObstacle_Controller;
import MVC.Conroller.Settings_Controller.SettingsMain_Controller;
import Visualizer_Settings.Visualizer_Properties;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoadScene {

    public LoadScene(){

    }
    private Stage stage;
    private Parent parent;
    private  static FXMLLoader fxmlLoader;

    private static final String ColorAnimation_Ui = "Settings_Scene/ColorAnimation_Ui.fxml";
    private static final String SettingMain_Ui = "Settings_Scene/SettingMain_Ui.fxml";
    private static final String MapSizeObstacle_Ui = "Settings_Scene/MapSizeObstacle_Ui.fxml";
    private static final String MainBorder_Ui = "Settings_Scene/MainBorder_Ui.fxml";

    private void LoadUi(Node node, String path){

        stage = (Stage) node.getScene().getWindow();
        stage.close();

        stage = new Stage();

        try {

            parent = FXMLLoader.load(getClass().getResource(path));

        }catch (IOException e){

        }
        Scene scene = new Scene(parent);

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    public void Load_Settings(Node node){
        LoadUi(node,SettingMain_Ui);
    }

    private void Alert(Parent parent, String path){

        fxmlLoader = new FXMLLoader(getClass().getResource(path));
        stage = new Stage();
        stage.initOwner(parent.getScene().getWindow());

        try {
            parent = fxmlLoader.load();
        }catch (IOException e){
            e.printStackTrace();
        }

        Scene scene = new Scene(parent);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Algorithm Settings");

        stage.centerOnScreen();
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }




    public void LoadSetting_Alert(Node node,Visualizer_Properties visualizer_properties){
        Alert((Parent) node,SettingMain_Ui);

        SettingsMain_Controller controller = fxmlLoader.getController();
        controller.setVisualizer_properties(visualizer_properties);

    }

    // ------------------------------------------- For changing the right Scene ----------------------------------------------//

    private void Settings_Right(String path, VBox vBox){
        VBox VBox_child = New_Vbox(path);
        VBox.setVgrow(VBox_child, Priority.ALWAYS);
        vBox.getChildren().clear();
        vBox.getChildren().setAll(VBox_child);
    }


    private VBox New_Vbox(String path){
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource(path));

            return (VBox)fxmlLoader.load();

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void Settings_ColorAnimation(VBox vBox, Visualizer_Properties visualizer_properties){
        Settings_Right(ColorAnimation_Ui,vBox);
        ColorAnimation_Controller controller = fxmlLoader.getController();
        controller.getBlock_color().setValue(Color.valueOf(visualizer_properties.getColor_nodes().getBlock_color(false)));
        controller.getDestination_color().setValue(Color.valueOf(visualizer_properties.getColor_nodes().getDestination_color(false)));
        controller.getPath_color().setValue(Color.valueOf(visualizer_properties.getColor_nodes().getPath_color(false)));
        controller.getSource_color().setValue(Color.valueOf(visualizer_properties.getColor_nodes().getSource_color(false)));
        controller.getUnvisited_color().setValue(Color.valueOf(visualizer_properties.getColor_nodes().getUnvisited_color(false)));
        controller.getSearching_color().setValue(Color.valueOf(visualizer_properties.getColor_nodes().getFinding_color(false)));
        controller.getDelay_value().setText(""+ visualizer_properties.getAnimation_delay().getDelay());
        controller.setVisualizer_properties(visualizer_properties);
    }

    public void Settings_MapSizeObstacle(VBox vBox, Visualizer_Properties visualizer_properties){
        Settings_Right(MapSizeObstacle_Ui,vBox);
        System.out.println(fxmlLoader);
        MapSizeObstacle_Controller controller = fxmlLoader.getController();
        controller.getHeight_value().setText(""+visualizer_properties.getMap_setting().getY());
        controller.getWidth_value().setText(""+visualizer_properties.getMap_setting().getX());
        controller.getPercentage_value().setText(""+visualizer_properties.getAnimation_delay().getDelay());
        controller.setVisualizer_properties(visualizer_properties);
    }

    // ------------------------------------------- End of changing the right Scene ----------------------------------------------//

}