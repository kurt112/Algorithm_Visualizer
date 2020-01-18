package Visualizer_Settings;

public class Color_Nodes {

    private String finding_color;// color of the nodes when finding
    private String source_color; //  color of the nodes of the source
    private String destination_color;// the color  of the nodes in destination
    private String path_color;// The color of the path when the path is found
    private String unvisited_color; // normal color of the nodes
    private String block_color; // color for the block


    public Color_Nodes() {

        // setting the default color when the program starts;
        this.finding_color = "cyan";
        this.source_color = "green";
        this.destination_color = "red";
        this.path_color = "orange";
        this.unvisited_color = "white";
        this.block_color = "black";
    }


    public String getBlock_color(boolean using) {
        return using ? "-fx-border-style: solid inside;"
                + "-fx-border-color: black;" + "-fx-background-color:'"+block_color+"';":block_color;
    }

    public String getSource_color(boolean using) {
        return using ? "-fx-border-style: solid inside;"
                + "-fx-border-color: black;" + "-fx-background-color:'"+source_color+"';":source_color;
    }

    public String getDestination_color(boolean using) {
        return using? "-fx-border-style: solid inside;"
                + "-fx-border-color: black;" + "-fx-background-color:'"+destination_color+"';":destination_color;
    }

      public String getPath_color(boolean using) {
        return using  ?  "-fx-border-style: solid inside;"
                +"-fx-border-color: black;" + "-fx-background-color:'"+
                path_color+"';": path_color;
    }


    public String getUnvisited_color(boolean using) {
        return using ? "-fx-border-style: solid inside;"
                +"-fx-border-color: black;" + "-fx-background-color:'"+
                unvisited_color+"';": unvisited_color;
    }

    public String getFinding_color(boolean using) {
        return using ? "-fx-border-style: solid inside;"
                +"-fx-border-color: black;" + "-fx-background-color:'"+
                finding_color+"';": finding_color;
    }

    public void setFinding_color(String finding_color) {
        this.finding_color = finding_color;
    }

    public void setSource_color(String source_color) {
        this.source_color = source_color;
    }

    public void setDestination_color(String destination_color) {
        this.destination_color = destination_color;
    }

    public void setPath_color(String path_color) {
        this.path_color = path_color;
    }

    public void setUnvisited_color(String unvisited_color) {
        this.unvisited_color = unvisited_color;
    }

    public void setBlock_color(String block_color) {
        this.block_color = block_color;
    }
}
