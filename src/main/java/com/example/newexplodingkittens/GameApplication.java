/**
 * The GameApplication class manages the running instantiation of the application
 * by loading the FXML file that contains the application's framework.
 * @author Akhil Kasamsetty, Anish Alle, Andrew Li
 * Collaborators: N/A
 * Teacher Name: Ms. Bailey
 * Period: 6
 * Due Date: 5-10-2024
 */

package com.example.newexplodingkittens;

import com.example.newexplodingkittens.controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {

    /**
     * Starts the application
     * @param stage the stage in which the application is started
     * @throws IOException incase the stage is invalid or some error
     */
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