module com.example.newexplodingkittens {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.newexplodingkittens to javafx.fxml;
    exports com.example.newexplodingkittens;
    exports com.example.newexplodingkittens.view;
    opens com.example.newexplodingkittens.view to javafx.fxml;
    exports com.example.newexplodingkittens.controller;
    opens com.example.newexplodingkittens.controller to javafx.fxml;
}