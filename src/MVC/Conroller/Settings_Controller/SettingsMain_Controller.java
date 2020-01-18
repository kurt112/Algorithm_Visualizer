package MVC.Conroller.Settings_Controller;

import MVC.Ui.LoadScene;
import Visualizer_Settings.Visualizer_Properties;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;

public class SettingsMain_Controller {
    @FXML private TreeView<String> Menu_Settings;
    @FXML private VBox Changing_Menu;
    private LoadScene loadScene = new LoadScene();
    private Visualizer_Properties visualizer_properties;
    public void initialize(){
        Create_TreeItem();
    }

    private void Create_TreeItem(){
        TreeItem Tree_Container = new TreeItem<>("Im the container");
        TreeItem Map_Appearance  = new TreeItem<>("Map Appearance");
        TreeItem nodes  = new TreeItem<>("Nodes");

        // ----------------------------   For Tree roots ----------------------------//

        Tree_Container.getChildren().addAll(Map_Appearance,nodes);

        TreeItem size_obstacle = new TreeItem<>("Map Size and Obstacle");
        TreeItem color_animation = new TreeItem<>("Color and Animation");

        Map_Appearance.getChildren().addAll(size_obstacle,color_animation);

        Menu_Settings.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {

            if(newValue != null){
                switch (newValue.getValue()){
                    case "Map Size and Obstacle":
                        loadScene.Settings_MapSizeObstacle(Changing_Menu,visualizer_properties);
                        break;
                    case "Color and Animation":
                        loadScene.Settings_ColorAnimation(Changing_Menu,visualizer_properties);
                        break;
                }
            }
        });

        Menu_Settings.setRoot(Tree_Container);
        Menu_Settings.setShowRoot(false);

    }

    public Visualizer_Properties getVisualizer_properties() {
        return visualizer_properties;
    }

    public void setVisualizer_properties(Visualizer_Properties visualizer_properties) {
        this.visualizer_properties = visualizer_properties;
    }
}
