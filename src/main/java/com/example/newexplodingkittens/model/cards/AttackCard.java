package com.example.newexplodingkittens.model.cards;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.Deck;
import com.example.newexplodingkittens.controller.ApplicationController;
import com.example.newexplodingkittens.model.Player;

import javax.swing.*;

import static com.example.newexplodingkittens.controller.ApplicationController.currentPlayer;
import static com.example.newexplodingkittens.controller.ApplicationController.turnController;

public class AttackCard implements Card {

    /**
     * Place a card and carry out it's action, removing the card
     * from the user's hand
     */
    @Override
    public void play(Deck deck) {
        turnController.getNextPlayer().setTurns(2);

    }

    /**
     * Retrieves whether card consumes turn when played
     * @return true b/c it consumes turn
     */
    @Override
    public boolean consumesTurn() {
        return true;
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
        return "Attack";
    }

}
