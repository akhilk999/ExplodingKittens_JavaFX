
package com.example.newexplodingkittens;

import com.example.newexplodingkittens.controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("exploding_kittens.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Game");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
        ApplicationController controller = fxmlLoader.getController();

    }

    public static void main(String[] args) {
        launch();
    }
}