package com.example.newexplodingkittens.model.cards;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.Deck;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SeeTheFuture implements Card {

    /**
     * Place a card and carry out it's action, removing the card
     * from the user's hand
     */
    @Override
    public void play(Deck deck) {
        List<Card> next = new ArrayList<>();
        next.add(deck.getDeck().get(0));
        next.add(deck.getDeck().get(1));
        next.add(deck.getDeck().get(2));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("SeeTheFuture");
        alert.setContentText(next.toString());
        alert.show();

    }

    /**
     * Retrieves whether card type is nope-able
     * @return true b/c it is always nope-able
     */
    @Override
    public boolean consumesTurn() {
        return false;
    }

    /**
     * Retrieves the card's images
     * @return array of card's images
     */
    @Override
    public ImageIcon[] getImages(){

        return new ImageIcon[0];
    }

    /**
     * Retrieves the name of the card
     * @return  the card's name
     */
    @Override
    public String toString(){
        return "See The Future";
    }

}
