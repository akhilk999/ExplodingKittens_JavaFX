package com.example.newexplodingkittens.model.cards;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.Deck;

import javax.swing.*;

public class ExplodingKittenCard implements Card {

    /**
     * Place a card and carry out it's action, removing the card
     * from the user's hand
     */
    @Override
    public void play(Deck deck) {
        deck.place(new ExplodingKittenCard());
        deck.shuffle();
    }

    /**
     * Retrieves whether card type is nope-able
     * @return false b/c it is never nope-able
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

    public void onDraw() {

    }
    /**
     * Retrieves the name of the card
     * @return  the card's name
     */
    @Override
    public String toString(){
        return "Exploding Kitten";
    }

}
