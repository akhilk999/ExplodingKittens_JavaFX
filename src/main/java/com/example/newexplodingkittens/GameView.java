package com.example.newexplodingkittens;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class GameView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameView.class.getResource("exploding_kittens.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Game");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

        Button deck = new Button();
        TextInputDialog getNumPlayers = new TextInputDialog("2");
        getNumPlayers.setHeaderText("Enter the number of players: ");
        int numPlayers = Integer.parseInt(getNumPlayers.showAndWait().orElse("-1"));
        TextInputDialog getPlayers = new TextInputDialog("2");
        getPlayers.setHeaderText("Enter the number of players: ");
        String[] players = getPlayers.showAndWait().orElse("").split(",");



    }

    public static void main(String[] args) {
        launch();
    }
}