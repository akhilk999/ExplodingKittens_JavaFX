package com.example.newexplodingkittens.model.cards;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.Deck;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import javax.swing.*;

public class FindKitten implements Card {

    /**
     * Place a card and carry out it's action, removing the card
     * from the user's hand
     */
    @Override
    public void play(Deck deck) {
        int count = (int) deck.getDeck().stream().filter(card -> !(card instanceof ExplodingKittenCard)).count();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("FindKitten");
            alert.setContentText(count + " Cards until the next Exploding Kitten");
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
        return "Find Kitten";
    }
}
