/**
 * The SeeTheFutureCard class defines the See The Future Card
 * @author Akhil Kasamsetty, Anish Alle, Andrew Li
 * Collaborators: N/A
 * Teacher Name: Ms. Bailey
 * Period: 6
 * Due Date: 5-10-2024
 */

package com.example.newexplodingkittens.model.cards;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.Deck;
import javafx.scene.control.Alert;
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
        if (deck.getDeck().size() < 3) {
            next.addAll(deck.getDeck());
        } else {
            for (int i = 0; i < 3; i++) {
                next.add(deck.getDeck().get(i));
            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("SeeTheFuture");
        alert.setContentText(next.toString());
        alert.show();

    }

    /**
     * Retrieves whether card consumes turn when played
     * @return false b/c it does not consume turn
     */
    @Override
    public boolean consumesTurn() {
        return false;
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
