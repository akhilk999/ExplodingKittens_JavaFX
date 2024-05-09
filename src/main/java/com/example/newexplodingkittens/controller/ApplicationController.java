package com.example.newexplodingkittens.controller;

import com.example.newexplodingkittens.model.Deck;
import com.example.newexplodingkittens.model.Player;
import com.example.newexplodingkittens.model.cards.DefuseCard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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
        drawCard.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextInputDialog getNumPlayers = new TextInputDialog("2");
        getNumPlayers.setHeaderText("Enter the number of players: ");
        getNumPlayers.setContentText("Enter a number from 2-10");
        int numPlayers = Integer.parseInt(getNumPlayers.showAndWait().orElse("-1"));
        while(numPlayers < 2 || numPlayers > 10){
            getNumPlayers.setHeaderText("Invalid number - Please enter the number of players: ");
            numPlayers = Integer.parseInt(getNumPlayers.showAndWait().orElse("-1"));
        }
        deck = new Deck(numPlayers);

        TextInputDialog getPlayers = new TextInputDialog("");
        getPlayers.setHeaderText("Enter the players: ");
        getPlayers.setContentText("Separate by commas");
        String[] players = getPlayers.showAndWait().orElse("").split(",");
        while(players.length != numPlayers){
            getPlayers.setHeaderText("Invalid number of players: Please enter the players: ");
            players = getPlayers.showAndWait().orElse("").split(",");
        }
        List<Player> playerList = new ArrayList<>();
        List<Tab> tabs = tabPane.getTabs();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        for(int lcv = 0; lcv < players.length; lcv++){
            Player newPlayer = new Player(players[lcv].trim(),deck);
            playerList.add(newPlayer);
                Tab newTab = new Tab(newPlayer.getName());
                newTab.setId("#"+ newPlayer.getName());
                tabs.add(newTab);
            newPlayer.addCardtoHand(new DefuseCard());
            for(int init = 0; init < 7; init++){
                newPlayer.addCardtoHand(deck.draw());
            }
            VBox verticalContent = new VBox();
            verticalContent.setAlignment(Pos.CENTER);
            HBox tabContent = new HBox();
            tabContent.setAlignment(Pos.CENTER);
            tabContent.setId("#" + newPlayer.getName() + "Tab");
            newTab.setContent(verticalContent);
            verticalContent.getChildren().add(tabContent);
            List<Node> cardLabels = new ArrayList<>();
            for(int lcv2 = 0; lcv2 < newPlayer.getHand().size(); lcv2++){
                cardLabels.add(new Label(newPlayer.getHand().get(lcv2).toString()));
            }
            tabContent.getChildren().addAll(cardLabels);
        }
        deck.addKittens(numPlayers);
        deck.shuffle();


        turnController = new TurnController(playerList);
        currentPlayer = turnController.getCurrentPlayer();
        index = turnController.getIndex();
    }
    public void update(){

    }
}