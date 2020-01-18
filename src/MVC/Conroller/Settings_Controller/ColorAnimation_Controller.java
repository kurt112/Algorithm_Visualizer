package MVC.Conroller.Settings_Controller;

import Visualizer_Settings.Visualizer_Properties;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

public class ColorAnimation_Controller {

    //---------------------------------------- Variable ----------------------------------------------
    @FXML private TextField searching_delay;
    @FXML private TextField path_delay;

    @FXML
    private ColorPicker source_color;

    @FXML
    private ColorPicker destination_color;

    @FXML
    private ColorPicker path_color;

    @FXML
    private ColorPicker searching_color;

    @FXML
    private ColorPicker unvisited_color;

    @FXML
    private ColorPicker block_color;



    private Visualizer_Properties visualizer_properties;

    //---------------------------------------- End of Variable ----------------------------------------------



    //------------------------------------------- of Button Function ----------------------------------------------
    @FXML
    void Button_Apply() {

    }

    @FXML
    void Button_Cancel() {

    }

    @FXML
    void Button_Ok() {


        visualizer_properties.getColor_nodes().setSource_color(source_color.getValue().toString());

        visualizer_properties.getColor_nodes().setDestination_color(destination_color.getValue().toString());

        visualizer_properties.getColor_nodes().setPath_color( path_color.getValue().toString());

        visualizer_properties.getColor_nodes().setFinding_color(searching_color.getValue().toString());

        visualizer_properties.getColor_nodes().setUnvisited_color(unvisited_color.getValue().toString());

        visualizer_properties.getColor_nodes().setBlock_color(block_color.getValue().toString());

        try {
            visualizer_properties.getAnimation_delay().setPath_delay(Long.parseLong(path_delay.getText()));
        }catch (NumberFormatException | NullPointerException e){
            Alert_Information();
        }

        try {
            visualizer_properties.getAnimation_delay().setPath_delay(Long.parseLong(searching_delay.getText()));
        }catch (NumberFormatException | NullPointerException e){
            Alert_Information();
        }
        visualizer_properties.Create_Map();

    }

    //---------------------------------------- End of Button Function ----------------------------------------------

    private void Alert_Information(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error Delay Value");
        alert.setContentText("try putting whole number in value");
        alert.showAndWait();
    }


    //---------------------------------------- Getter Method ----------------------------------------------

    public ColorPicker getSource_color() {
        return source_color;
    }

    public ColorPicker getDestination_color() {
        return destination_color;
    }

    public ColorPicker getPath_color() {
        return path_color;
    }

    public ColorPicker getSearching_color() {
        return searching_color;
    }

    public ColorPicker getUnvisited_color() {
        return unvisited_color;
    }

    public ColorPicker getBlock_color() {
        return block_color;
    }

    public void setVisualizer_properties(Visualizer_Properties visualizer_properties) {
        this.visualizer_properties = visualizer_properties;
    }

    public TextField getSearching_delay() {
        return searching_delay;
    }

    public TextField getPath_delay() {
        return path_delay;
    }

    //---------------------------------------- End of Getter Setter ----------------------------------------------
}
