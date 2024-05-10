/**
 * The AttackCard class defines the Attack Card
 * @author Akhil Kasamsetty, Anish Alle, Andrew Li
 * Collaborators: N/A
 * Teacher Name: Ms. Bailey
 * Period: 6
 * Due Date: 5-10-2024
 */

package com.example.newexplodingkittens.model.cards;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.Deck;
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
     * Retrieves the name of the card
     * @return  the card's name
     */
    @Override
    public String toString(){
        return "Attack";
    }

}
