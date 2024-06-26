/**
 * The Deck class defines the functionality behind the game's deck
 * @author Akhil Kasamsetty, Anish Alle, Andrew Li
 * Collaborators: N/A
 * Teacher Name: Ms. Bailey
 * Period: 6
 * Due Date: 5-10-2024
 */

package com.example.newexplodingkittens.model;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.cards.ExplodingKittenCard;
import com.example.newexplodingkittens.util.CardFactory;
import com.example.newexplodingkittens.util.GameUtils;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    //instance variables
    CardFactory cardFactory;
    public List<Card> deck;
    public List<Card> lastPlayed;

    /**
     * Allocates a new Deck that creates and stores a CardFactory, number of players and a queue of cards
     * @param numPlayers the number of players in the game
     */
    public Deck(int numPlayers){
        cardFactory = new CardFactory(numPlayers);
        deck = cardFactory.getList();
        lastPlayed = new ArrayList<>();
    }

    /**
     * Adds a certain card in a certain location within the deck
     * @param card the card to be added
     */
    public void place(Card card){
        deck.add(card);
    }

    /**
     * Draws a new card from the top of the deck
     * @return the drawn card
     */
    public Card draw(){
        return deck.remove(0);
    }

    /**
     * Retrieves the deck
     * @return the deck
     */
    public List<Card> getDeck(){
        return deck;
    }

    /**
     * Sets the last played card
     * @param card the card to be set as the last played
     */
    public void setLastPlayed(Card card) { lastPlayed.add(0,card); }

    /**
     * Shuffles the deck using GameUtils.shuffle()
     */
    public void shuffle() { deck = GameUtils.shuffle(deck); }

    /**
     * Adds Kittens to the deck depending on the number of players
     * @param numPlayers the number of players in the game
     */
    public void addKittens(int numPlayers){
        for(int lcv = 0; lcv < numPlayers - 1; lcv++){
            deck.add(new ExplodingKittenCard());
        }
    }

    /**
     * Returns the deck as a string
     * @return deckString the deck in the form of a string
     */
    public String toString(){
        String deckString = "";
        for (Card card : deck)
        {
            deckString += (" " + card.toString());
        }
        return deckString;
    }
}