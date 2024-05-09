package com.example.newexplodingkittens.controller;

import com.example.newexplodingkittens.model.Deck;
import com.example.newexplodingkittens.model.Player;
import com.example.newexplodingkittens.view.PlayerView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {
    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    public Button drawCard;

    @FXML
    public TabPane tabPane;

    @FXML
    public Label lastCard;

    @FXML
    public Button endTurn;

    public Deck deck;
    public TurnController turnController;
    public Player currentPlayer;
    public int index;

    @FXML
    public void drawCardHandler(ActionEvent event) {
        deck.setLastPlayed(turnController.getCurrentPlayer().draw());
        drawCard.setDisable(true);
    }

    public void endTurnHandler(ActionEvent event){
        currentPlayer = turnController.next();
        index = turnController.getIndex();
        tabPane.getSelectionModel().select(tabPane.getTabs().get(index));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextInputDialog getNumPlayers = new TextInputDialog("2");
        getNumPlayers.setHeaderText("Enter the number of players: ");
        int numPlayers = Integer.parseInt(getNumPlayers.showAndWait().orElse("-1"));
        deck = new Deck(numPlayers);

        TextInputDialog getPlayers = new TextInputDialog("");
        getPlayers.setHeaderText("Enter the players: ");
        getPlayers.setContentText("Separate by commas");
        String[] players = getPlayers.showAndWait().orElse("").split(",");
        List<Player> playerList = new ArrayList<>();
        List<PlayerView> playerViewList = new ArrayList<>();
        List<Tab> tabs = tabPane.getTabs();
        for(int lcv = 0; lcv < players.length; lcv++){
            playerList.add(new Player(players[lcv].trim(), deck));
            playerViewList.add(new PlayerView(playerList.get(lcv)));
            if(lcv < 2){
                tabs.get(lcv).setText(playerList.get(lcv).getName());
                tabs.get(lcv).setId("#" + playerList.get(lcv).getName());
            }
            else{
                Tab newTab = new Tab(playerList.get(lcv).getName());
                newTab.setId("#"+ playerList.get(lcv).getName());
                tabs.add(newTab);
            }

        }
        turnController = new TurnController(playerList);
        currentPlayer = turnController.getCurrentPlayer();
        index = turnController.getIndex();
    }
}