module com.example.olioharjoitustyo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.olioharjoitustyo to javafx.fxml;
    exports com.example.olioharjoitustyo;
    exports com.example.olioharjoitustyo.controllers;
    opens com.example.olioharjoitustyo.controllers to javafx.fxml;

}