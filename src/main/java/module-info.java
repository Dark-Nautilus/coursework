module petclinic {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    requires org.json;

    opens petclinic to javafx.fxml;
    opens petclinic.model to javafx.base;
    opens petclinic.controller to javafx.fxml;

    exports petclinic;
    exports petclinic.model;
    exports petclinic.controller;
    exports petclinic.dao;
    opens petclinic.dao to javafx.fxml;
    exports petclinic.view;
    opens petclinic.view to javafx.fxml;
}