package Nodes_Manipulation;
import Visualizer_Settings.Visualizer_Properties;
import javafx.application.Platform;

public class ColorNode implements Runnable {

    private Node_Status node_status;
    private Visualizer_Properties visualizer_properties;
    public ColorNode(Node_Status node_status, Visualizer_Properties visualizer_properties) {
        this.node_status = node_status;
        this.visualizer_properties = visualizer_properties;
    }

    @Override
    public void run() {
            Platform.runLater(() -> {
                if(!node_status.Get_HBox().getStyle().equals(visualizer_properties.getColor_nodes().getPath_color(true)))
                node_status.Get_HBox().setStyle(visualizer_properties.getColor_nodes().getFinding_color(true));
            });

    }

}
