/**
 * The ExplodingKittenCard class defines the Exploding Kitten Card
 * @author Akhil Kasamsetty, Anish Alle, Andrew Li
 * Collaborators: N/A
 * Teacher Name: Ms. Bailey
 * Period: 6
 * Due Date: 5-10-2024
 */

package com.example.newexplodingkittens.model.cards;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.Deck;


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
     * Retrieves the name of the card
     * @return  the card's name
     */
    @Override
    public String toString(){
        return "Exploding Kitten";
    }

}
