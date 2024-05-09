package com.example.newexplodingkittens.model;

import com.example.newexplodingkittens.interfaces.Card;
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
     * Discards a certain card from the deck
     * @param card the card to be removed
     */
    public void discard(Card card){
        deck.remove(card);
    }

    /**
     * Adds a certain card in a certain location within the deck
     * NOTE: needs to be fixed
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

    public List<Card> getLastPlayed() { return lastPlayed; }

    public Card getLastPlayedCard(){return lastPlayed.get(0); }

    public void setLastPlayed(Card card) { lastPlayed.add(0,card); }

    public void shuffle() { deck = GameUtils.shuffle(deck); }

    public String toString(){
        String deckString = "";
        for (Card card : deck)
        {
            deckString += (" " + card.toString());
        }
        return deckString;
    }
}