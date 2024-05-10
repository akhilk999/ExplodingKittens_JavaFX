/**
 * The FindKitten class defines the Find Kitten Card
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

public class FindKitten implements Card {

    /**
     * Place a card and carry out it's action, removing the card
     * from the user's hand
     */
    @Override
    public void play(Deck deck) {
        int count = 0;
        boolean found = false;
        System.out.println(deck.toString());
        while(!found) {
            if (deck.getDeck().get(count) instanceof ExplodingKittenCard) {
                found = true;
            }
            else
                count++;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("FindKitten");
        alert.setContentText(count + " Cards before the next Exploding Kitten");
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
     * Retrieves the name of the card
     * @return  the card's name
     */
    @Override
    public String toString(){
        return "Find Kitten";
    }
}
