/**
 * The Card interface defines common methods for all cards
 * @author Akhil Kasamsetty, Anish Alle, Andrew Li
 * Collaborators: N/A
 * Teacher Name: Ms. Bailey
 * Period: 6
 * Due Date: 5-10-2024
 */

package com.example.newexplodingkittens.interfaces;

import com.example.newexplodingkittens.model.Deck;

public  interface Card {
    /**
     * Plays the effect of the card
     * @param deck the game's deck of cards
     */
    void play(Deck deck);

    /**
     * Whether the card consumes a full turn or not
     * @return true if the card uses up a turn, false otherwise
     */
    boolean consumesTurn();

}
