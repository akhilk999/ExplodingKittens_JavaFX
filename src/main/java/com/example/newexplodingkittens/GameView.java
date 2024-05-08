
package com.example.newexplodingkittens;

import com.example.newexplodingkittens.model.Deck;
import com.example.newexplodingkittens.model.Player;
import com.example.newexplodingkittens.view.PlayerView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameView.class.getResource("exploding_kittens.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Game");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

        TextInputDialog getNumPlayers = new TextInputDialog("2");
        getNumPlayers.setHeaderText("Enter the number of players: ");
        int numPlayers = Integer.parseInt(getNumPlayers.showAndWait().orElse("-1"));
        Deck deck = new Deck(numPlayers);

        TextInputDialog getPlayers = new TextInputDialog("");
        getPlayers.setHeaderText("Enter the players: ");
        getPlayers.setContentText("Separate by commas");
        String[] players = getPlayers.showAndWait().orElse("").split(",");
        List<Player> playerList = new ArrayList<>();
        List<PlayerView> playerViewList = new ArrayList<>();
        for(int lcv = 0; lcv < players.length; lcv++){
            playerList.add(new Player(players[lcv].trim(), deck));
            playerViewList.add(new PlayerView(playerList.get(lcv)));
        }
        /*
        Button newCard = new Button();
        Image lastCardImage = ImageIO.read(new File("src/images/defuse/Laser-Pointer.jpg"));
        lastCardImage = lastCardImage.getScaledInstance(-1, gameView.gameFrame.getHeight()/2, Image.SCALE_DEFAULT);
        */
    }

    public static void main(String[] args) {
        launch();
    }
}