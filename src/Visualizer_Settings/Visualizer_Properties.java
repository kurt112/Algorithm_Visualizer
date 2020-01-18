package Visualizer_Settings;

import Nodes_Manipulation.Node_Status;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;


import java.util.Arrays;

public class Visualizer_Properties {

    private Animation_Delay animation_delay;
    private Color_Nodes color_nodes;
    private Map_Settings map_setting;
    private Node_Status[][] rectangle_container;
    private Node_Status source;
    private Node_Status destination;
    private VBox  Parent_Vbox;

    private int width=0, height =0;
    private boolean hover = false;



    // ----------------------------   Constructor ----------------------------//
    public Visualizer_Properties(VBox Parent_Vbox) {
        this.animation_delay = new Animation_Delay();
        this.color_nodes = new Color_Nodes();
        this.map_setting = new Map_Settings();
        this.Parent_Vbox  = Parent_Vbox;
        System.out.println(Parent_Vbox);

    }
    // ---------------------------- End of Constructor----------------------------//


    // ----------------------------   Getter and Setter---------------------------//

    public Animation_Delay getAnimation_delay() {
        return animation_delay; }

    public Color_Nodes getColor_nodes() {
        return color_nodes;
    }


    public Map_Settings getMap_setting() {
        return map_setting;
    }

    public Node_Status getSource() {
        return source;
    }

    public Node_Status getDestination() {
        return destination;
    }

    public void setSource(Node_Status source) {
        this.source = source;
    }

    public void setDestination(Node_Status destination) {
        this.destination = destination;
    }

    public boolean isHover() {
        return hover;
    }

    public Node_Status[][] getRectangle_container() {
        return rectangle_container;
    }
    // ----------------------------  End of Getter and Setter ----------------------------//



    public void Create_Map(){

        Parent_Vbox.getChildren().clear();
        destination = null;
        source = null;

        try {

            // setting the width of the container
            width = map_setting.getX();
            height = map_setting.getY();

            rectangle_container = new Node_Status[width][height];
            new Thread(() -> {
                try {

                    // Adding item in the multi array
                    for (int i = 0; i < width; i++) {
                        HBox main_hbox = new HBox();

                        Thread.sleep(50);
                        VBox.setVgrow(main_hbox, Priority.ALWAYS);

                        for (int j = 0; j < height; j++) {
                            HBox child_hbox = new HBox();
                            rectangle_container[i][j]  = new Node_Status(child_hbox,false,i,j);
                            child_hbox.setStyle(color_nodes.getUnvisited_color(true));
                            HBox.setHgrow(child_hbox, Priority.ALWAYS);
                            main_hbox.getChildren().add(child_hbox);
                        }
                        Platform.runLater(() -> Parent_Vbox.getChildren().add(main_hbox));
                    }

                    // Adding Action listener for every item
                    Arrays.stream(rectangle_container).flatMap(Arrays::stream).forEach(item -> item.Get_HBox().setOnMouseClicked(e ->{
                        if(e.getButton() == MouseButton.PRIMARY){
                            try {
                                source.Get_HBox().setStyle(color_nodes.getUnvisited_color(true));
                                source.setVisited(false);
                                item.Get_HBox().setStyle(color_nodes.getSource_color(true));
                                source = find_rectangle(item.Get_HBox());
                                source.setVisited(true);

                            }catch (NullPointerException a){
                                item.Get_HBox().setStyle(color_nodes.getSource_color(true));
                                source = find_rectangle(item.Get_HBox());
                                source.setVisited(true);
                            }
                        }
                        if(e.getButton() == MouseButton.SECONDARY){
                            try{
                                destination.Get_HBox().setStyle(color_nodes.getUnvisited_color(true));
                                destination.setVisited(false);
                                item.Get_HBox().setStyle(color_nodes.getDestination_color(true));
                                destination = find_rectangle(item.Get_HBox());
                                destination.setVisited(true);
                            }catch (NullPointerException f){
                                item.Get_HBox().setStyle(color_nodes.getDestination_color(true));
                                destination = find_rectangle(item.Get_HBox());
                                destination.setVisited(true);
                            }
                        }
                    }));
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }).start();
        }catch (NumberFormatException | NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing number or Letter Detected");
            alert.setContentText("Fill up the x and y proper value");
            alert.showAndWait();

        }
        System.out.println("finish");
    }


    private Node_Status find_rectangle(HBox hBox){
        return Arrays.stream(rectangle_container)
                .flatMap(Arrays::stream)
                .filter(item -> item.Get_HBox().equals(hBox))
                .findAny()
                .orElse(null);
    }
}
