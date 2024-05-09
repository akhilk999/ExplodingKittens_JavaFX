
package com.example.newexplodingkittens;

import com.example.newexplodingkittens.controller.TurnController;
import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.Deck;
import com.example.newexplodingkittens.controller.ApplicationController;
import com.example.newexplodingkittens.model.Player;
import com.example.newexplodingkittens.model.cards.DefuseCard;
import com.example.newexplodingkittens.view.PlayerView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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