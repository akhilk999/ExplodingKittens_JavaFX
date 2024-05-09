package com.example.newexplodingkittens.testing;

import com.example.newexplodingkittens.model.Deck;
import com.example.newexplodingkittens.model.Player;

public class PlayerTester {
    public static void main(String[] args) {
        System.out.println("Testing Player.java");
        Deck deck = new Deck(2);
        Player player1 = new Player("Player1", deck);
        Player player2 = new Player("Player2", deck);

        System.out.println("Original Deck: " + player1.getDeck().toString());
        System.out.println();

        player1.draw();
        System.out.println("Player1's Deck after Player1 draws: " + player1.getDeck().toString());
        System.out.println("Player2's Deck after Player1 draws: " + player2.getDeck().toString());

        System.out.println();
        System.out.println("Player1's Hand after Player1 draws: " + player1.getHand().toString());
        System.out.println("Player2's Hand after Player1 draws: " + player2.getHand().toString());
    }
}
