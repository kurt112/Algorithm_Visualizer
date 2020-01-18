package Nodes_Manipulation;

import javafx.scene.layout.HBox;

import java.util.HashSet;
import java.util.Set;

public class Node_Status {

    private HBox hBox;
    private boolean visited;
    private int i;
    private int j;
    private Set<Node_Status> visited_area;

    public Node_Status(HBox hBox, boolean visited, int i, int j) {
        this.hBox = hBox;
        this.visited = visited;
        this.i = i;
        this.j = j;
        visited_area = new HashSet<>();
    }

    public int getI() {
        return i;
    }

      public int getJ() {
        return j;
    }

    public Set<Node_Status> getVisited_area() {
        return visited_area;
    }


    public HBox Get_HBox() {
        return hBox;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }


}

