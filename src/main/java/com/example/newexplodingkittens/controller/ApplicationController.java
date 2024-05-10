package com.example.newexplodingkittens.controller;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.Deck;
import com.example.newexplodingkittens.model.Player;
import com.example.newexplodingkittens.model.cards.DefuseCard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {

    @FXML
    public Button drawCard;

    @FXML
    public TabPane tabPane;

    @FXML
    public Label lastCard;

    @FXML
    public Button endTurn;

    @FXML
    public Label currentPlayerLabel;

    public static Deck deck;
    public static TurnController turnController;
    public static Player currentPlayer;
    public int index;
    public boolean clickedDrawCard;
    public boolean clickedPlayedCard;

    @FXML
    public void drawCardHandler(ActionEvent event) {
        deck.setLastPlayed(turnController.getCurrentPlayer().draw());
        updateCards();
        drawCard.setDisable(true);
        setCardButtonsDisable(true);
        endTurn.setDisable(false);
    }

    @FXML
    public void endTurnHandler(ActionEvent event){
        endTurn.setDisable(true);
        if(currentPlayer.getNumTurns() > 1)
            currentPlayer.setTurns(currentPlayer.getNumTurns() - 1);

        else{
            currentPlayer = turnController.next();
            index = turnController.getIndex();
            tabPane.getSelectionModel().select(tabPane.getTabs().get(index));
            currentPlayerLabel.setText(currentPlayer.getName());


        }
        drawCard.setDisable(false);
        setCardButtonsDisable(false);
        if(clickedPlayedCard) {

            clickedPlayedCard = false;
        }
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
        for (String player : players) {
            Player newPlayer = new Player(player.trim(), deck);
            playerList.add(newPlayer);
            Tab newTab = new Tab(newPlayer.getName());
            newTab.setId("#" + newPlayer.getName());
            tabs.add(newTab);
            newPlayer.addCardtoHand(new DefuseCard());
            for (int init = 0; init < 7; init++) {
                newPlayer.addCardtoHand(deck.draw());
            }
            VBox verticalContent = new VBox();
            verticalContent.setAlignment(Pos.CENTER);
            HBox tabContent = new HBox();
            tabContent.setAlignment(Pos.CENTER);
            tabContent.setId("#" + newPlayer.getName() + "Tab");
            newTab.setContent(verticalContent);
            verticalContent.getChildren().add(tabContent);
            List<Node> cardButtons = new ArrayList<>();
            for (int lcv2 = 0; lcv2 < newPlayer.getHand().size(); lcv2++) {
                Card card = newPlayer.getHand().get(lcv2);
                Button cardButton = new Button(card.toString());
                cardButtons.add(cardButton);
                cardButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(card.consumesTurn()){
                            setCardButtonsDisable(true);
                            drawCard.setDisable(true);
                            endTurn.setDisable(false);
                        }
                        currentPlayer.playCard(card);
                        lastCard.setText(card.toString());
                        clickedPlayedCard = true;
                        updateCards();
                    }
                });
            }
            tabContent.setSpacing(15);
            tabContent.getChildren().addAll(cardButtons);
        }
        deck.addKittens(numPlayers);
        deck.shuffle();

        turnController = new TurnController(playerList);
        currentPlayer = turnController.getCurrentPlayer();
        currentPlayerLabel.setText("Current Player: " + currentPlayer.getName());
        index = turnController.getIndex();
        clickedDrawCard = false;
        clickedPlayedCard = false;
        endTurn.setDisable(true);
        drawCard.setDisable(false);
    }
    public void updateCards(){
        VBox vertical = (VBox) tabPane.getTabs().get(index).getContent();
        HBox horizontal = (HBox) vertical.getChildren().get(0);
        List<Node> labelList = horizontal.getChildren();
        List<Node> cardButtons = new ArrayList<>();
        for(int lcv2 = 0; lcv2 < currentPlayer.getHand().size(); lcv2++){
            Card card = currentPlayer.getHand().get(lcv2);
            Button cardButton = new Button(card.toString());
            cardButtons.add(cardButton);
            cardButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(card.consumesTurn()){
                        setCardButtonsDisable(true);
                        drawCard.setDisable(true);
                        endTurn.setDisable(false);
                    }
                    currentPlayer.playCard(card);
                    lastCard.setText(card.toString());
                    clickedPlayedCard = true;
                    updateCards();
                }
            });
        }
        labelList.clear();
        labelList.addAll(cardButtons);
    }

    public void setCardButtonsDisable(boolean bool){
        VBox vertical = (VBox) tabPane.getTabs().get(index).getContent();
        HBox horizontal = (HBox) vertical.getChildren().get(0);
        List<Node> buttonList = horizontal.getChildren();
        for (Node node : buttonList) {
            Button button = (Button) node;
            button.setDisable(bool);
        }
    }
}