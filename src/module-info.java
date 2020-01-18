module Path_Finding{

    // all jar files in the package

    // sdk jar files for javafx;
    requires javafx.media;
    requires javafx.web;
    requires javafx.swing;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.controls;

    // jar files for jfoenix
    requires com.jfoenix;

// -------------------------------------------------------------------------------//

    //opening all package

    opens MVC.Conroller.Settings_Controller;
    opens MVC.Conroller;
    opens MVC.Ui;
    opens Visualizer_Settings;
    opens Algorithm.Graph;
//    opens Algorithm.Sorting;
}