module com.example.newexplodingkittens {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.newexplodingkittens to javafx.fxml;
    exports com.example.newexplodingkittens;
}