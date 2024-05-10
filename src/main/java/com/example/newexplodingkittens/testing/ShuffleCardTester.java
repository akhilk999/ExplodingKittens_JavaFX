/**
 * The ShuffleCardTester class tests the ShuffleCard class
 * @author Akhil Kasamsetty, Anish Alle, Andrew Li
 * Collaborators: N/A
 * Teacher Name: Ms. Bailey
 * Period: 6
 * Due Date: 5-10-2024
 */

package com.example.newexplodingkittens.testing;

import com.example.newexplodingkittens.model.Deck;
import com.example.newexplodingkittens.model.Player;
import com.example.newexplodingkittens.model.cards.ShuffleCard;
import com.example.newexplodingkittens.model.cards.SkipCard;

public class ShuffleCardTester {
    public static void main(String[] args) {
        System.out.println("Testing ShuffleCard.java");
        Deck deck = new Deck(2);
        Player player1 = new Player("Player1", deck);
        Player player2 = new Player("Player2", deck);

        while (!(deck.getDeck().get(0) instanceof ShuffleCard))
            deck.getDeck().remove(0);

        System.out.println("Original Deck: " + player1.getDeck().toString());
        System.out.println();

        player1.draw();
        System.out.println("Player1's Deck after Player1 draws: " + player1.getDeck().toString());
        System.out.println("Player2's Deck after Player1 draws: " + player2.getDeck().toString());

        System.out.println();
        System.out.println("Player1's Hand after Player1 draws: " + player1.getHand().toString());
        System.out.println("Player2's Hand after Player1 draws: " + player2.getHand().toString());

        player1.playCard(new SkipCard());
        System.out.println();
        System.out.println("Player1's Deck after Player1 shuffles: " + player1.getDeck().toString());
        System.out.println("Player2's Deck after Player1 shuffles: " + player2.getDeck().toString());
        System.out.println("Player1's Hand after Player1 shuffles: " + player1.getHand().toString());
    }
}
