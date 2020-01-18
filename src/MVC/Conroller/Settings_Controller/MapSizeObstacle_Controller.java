package MVC.Conroller.Settings_Controller;

import Visualizer_Settings.Visualizer_Properties;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class MapSizeObstacle_Controller {

    //---------------------------------------- Variables ----------------------------------------------

    @FXML
    private TextField width_value;

    @FXML
    private TextField height_value;

    @FXML
    private TextField percentage_value;

    private Visualizer_Properties visualizer_properties;

    //---------------------------------------- End of Variable ----------------------------------------------


    //---------------------------------------- Button Function ----------------------------------------------

    @FXML
    void Button_Ok() {
        try {

            visualizer_properties.getMap_setting().setX(Integer.parseInt(width_value.getText()));

        }catch (NumberFormatException | NullPointerException e){
            Alert_Information("Map Width");
        }

        try {

            visualizer_properties.getMap_setting().setY(Integer.parseInt(height_value.getText()));

        }catch (NumberFormatException | NullPointerException e){
            Alert_Information("Map Height");
        }

        try {
            visualizer_properties.getMap_setting().setBlock_percentage(Integer.parseInt(percentage_value.getText()));
        }catch (NumberFormatException | NullPointerException e){
            Alert_Information("Block Percentage");
        }

        visualizer_properties.Create_Map();

    }//button ok

    @FXML
    void Button_Apply() {

    }//button apply

    @FXML
    void Button_Cancel() {

    }//button cancel


    //---------------------------------------- End of Button Function ----------------------------------------------

    //---------------------------------------- Getter and Setter ----------------------------------------------


    public TextField getWidth_value() {
        return width_value;
    }


    public TextField getHeight_value() {
        return height_value;
    }


    public TextField getPercentage_value() {
        return percentage_value;
    }



    public void setVisualizer_properties(Visualizer_Properties visualizer_properties) {
        this.visualizer_properties = visualizer_properties;
    }

    //---------------------------------------- Getter and Setter ----------------------------------------------
    //---------------------------------------- Getter and Setter ----------------------------------------------
    private void Alert_Information(String title){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText("try putting whole number in value");
        alert.showAndWait();
    }
    //---------------------------------------- Getter and Setter ----------------------------------------------



}
