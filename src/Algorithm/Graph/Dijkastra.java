package Algorithm.Graph;

import Nodes_Manipulation.ColorNode;
import Nodes_Manipulation.Node_Status;
import Visualizer_Settings.Visualizer_Properties;

public class Dijkastra {

    private boolean find;
    private boolean print_once;

    private Visualizer_Properties visualizer_properties;

    public Dijkastra(Visualizer_Properties visualizer_properties) {
        this.print_once = false;
        this.find = false;
        this.visualizer_properties = visualizer_properties;
    }


    // ----------------------------------------------------------- Getter and Setter -----------------------------------------------------------

    public void setFind(boolean find) {
        this.find = find;
    }

    public void setPrint_once(boolean print_once) {
        this.print_once = print_once;
    }


    // ----------------------------------------------------------- End Getter and Setter -----------------------------------------------------------

    private void copy_node(Node_Status source, Node_Status destination){
        source.getVisited_area().forEach(visited -> destination.getVisited_area().add(visited));
    }
    /**
     * @param list_nodes - the list of the map
     * @param start_node - starting node of searching
     * @param addition_x -  1 it will search on the positive side side of the graph
     * @param addition_y -  -1 it will search on on negative side of the graph
     */

    private synchronized void Move_Node(Node_Status[][] list_nodes, Node_Status start_node, int addition_x, int addition_y){

        //Current node coming from the list

        try {
            Node_Status currentNode =list_nodes[start_node.getI()+addition_x][start_node.getJ()+addition_y];

            if(!find){

                if(currentNode == visualizer_properties.getDestination()){
                    copy_node(start_node,currentNode);
                    visualizer_properties.getDestination().getVisited_area().add(start_node);
                    find = true;
                    System.out.println("find true");


                }else{

                    if(!currentNode.isVisited()){
                        Thread.sleep(visualizer_properties.getAnimation_delay().getSearching_delay());
                        currentNode.setVisited(true);
                        new Thread(new ColorNode(currentNode,visualizer_properties)).start();

                        copy_node(start_node,currentNode);
                        currentNode.getVisited_area().add(start_node);

                        Move(list_nodes, currentNode);

                    }
                }

            }else{

                if(!print_once){
                    print_once = true;
                    visualizer_properties.getDestination().getVisited_area().forEach(x -> {
                        if(x != visualizer_properties.getSource()){
                            try {
                                Thread.sleep(visualizer_properties.getAnimation_delay().getPath_delay());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            x.Get_HBox().setStyle(visualizer_properties.getColor_nodes().getPath_color(true));
                        }
                    });
                }

            }
        }catch (IndexOutOfBoundsException| InterruptedException e){
            //            System.out.println("nice one");
        }
    }

    public synchronized void Move(Node_Status[][] list_nodes, Node_Status start_node){
        new Thread(() ->check_right(list_nodes,start_node)).start();

        new Thread(() ->check_left(list_nodes,start_node)).start();

        new Thread(() -> check_bottom(list_nodes,start_node)).start();

        new Thread(() ->check_up(list_nodes,start_node)).start();
    }



    private   void check_bottom(Node_Status[][] list_nodes, Node_Status start_node){
        Move_Node(list_nodes,start_node,1,0);
    }
    private  void check_up(Node_Status[][] list_nodes, Node_Status start_node){
        Move_Node(list_nodes, start_node, -1, 0);
    }
    private  void check_right(Node_Status[][] list_nodes, Node_Status start_node){
        Move_Node(list_nodes, start_node, 0, 1);
    }
    private  void check_left(Node_Status[][] list_nodes, Node_Status start_node){
        Move_Node(list_nodes,start_node,0,-1);
    }

}
