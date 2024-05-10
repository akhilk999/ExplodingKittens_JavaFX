package com.example.newexplodingkittens.testing;

import com.example.newexplodingkittens.model.Deck;
import com.example.newexplodingkittens.model.Player;
import com.example.newexplodingkittens.model.cards.DrawFromTheBottom;

public class DrawFromTheBottomTester {
    public static void main(String[] args) {
        System.out.println("Testing DrawFromTheBottom.java");
        Deck deck = new Deck(2);
        Player player1 = new Player("Player1", deck);
        Player player2 = new Player("Player2", deck);

        while (!(deck.getDeck().get(0) instanceof DrawFromTheBottom))
            deck.getDeck().remove(0);

        System.out.println("Original Deck: " + player1.getDeck().toString());
        System.out.println();

        player1.draw();
        System.out.println("Player1's Deck after Player1 draws: " + player1.getDeck().toString());
        System.out.println("Player2's Deck after Player1 draws: " + player2.getDeck().toString());

        System.out.println();
        System.out.println("Player1's Hand after Player1 draws: " + player1.getHand().toString());
        System.out.println("Player2's Hand after Player1 draws: " + player2.getHand().toString());

        player1.playCard(player1.getHand().get(0));
        System.out.println();
        System.out.println("Player1's Deck after Player1 Draws From The Bottom: " + player1.getDeck().toString());
        System.out.println("Player2's Deck after Player1 Draws From The Bottom: " + player2.getDeck().toString());
        System.out.println("Player1's Hand after Player1 Draws From The Bottom: " + player1.getHand().toString());
    }
}
