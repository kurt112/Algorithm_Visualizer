package MVC.Conroller;

import Algorithm.Graph.Dijkastra;
import MVC.Ui.LoadScene;
import Visualizer_Settings.Visualizer_Properties;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.util.Arrays;

public class MainBorder {

    @FXML private VBox vbox;
    @FXML private VBox parent;



    private Visualizer_Properties visualizer_properties;
    private Dijkastra dijkastra;


    public void initialize() {
        visualizer_properties = new Visualizer_Properties(vbox);
        dijkastra = new Dijkastra(visualizer_properties);
        visualizer_properties.Create_Map();
    }
    @FXML
     private void Generate_Map() {
        visualizer_properties.Create_Map();

    }

//
//    @FXML public void Paint_Action(){
//    }




    @FXML public void Settings_Open(){
        LoadScene loadScene = new LoadScene();
        loadScene.LoadSetting_Alert(parent,visualizer_properties);
    }

    @FXML public void start()  {
        dijkastra.setFind(false);
        dijkastra.setPrint_once(false);
        new Thread(() -> dijkastra.Move(visualizer_properties.getRectangle_container(),visualizer_properties.getSource())).start();
    }
    @FXML void Default_Map() {
        visualizer_properties = new Visualizer_Properties(vbox);
        Generate_Map();
    }

    @FXML public void Reset() {
        visualizer_properties.setDestination(null);
        visualizer_properties.setSource(null);
        Arrays.stream(visualizer_properties.getRectangle_container())
                .flatMap(Arrays::stream)
                .forEach(map -> {
                    map.setVisited(false);
                    map.getVisited_area().clear();
                    map.Get_HBox().setStyle(visualizer_properties.getColor_nodes().getUnvisited_color(true));
                });
    }
}
