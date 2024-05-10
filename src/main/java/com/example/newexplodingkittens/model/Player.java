/**
 * The Player class defines functionality for each player in the game
 * @author Akhil Kasamsetty, Anish Alle, Andrew Li
 * Collaborators: N/A
 * Teacher Name: Ms. Bailey
 * Period: 6
 * Due Date: 5-10-2024
 */

package com.example.newexplodingkittens.model;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.cards.DefuseCard;
import com.example.newexplodingkittens.model.cards.DrawFromTheBottom;
import com.example.newexplodingkittens.model.cards.ExplodingKittenCard;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final Deck deck;
    private final List<Card> hand;
    private boolean eliminated;
    public int numTurns;

    public Player(String name, Deck deck){
        this.name = name;
        this.deck = deck;
        hand = new ArrayList<>();
        eliminated = false;
        numTurns = 1;
    }

    /** Eliminates the player if they do not have a Defuse card
     */
    public void onExplode(){
        boolean found = false;
        int index = -1;
        for (int lcv = 0; lcv < hand.size(); lcv++){
            if (hand.get(lcv) instanceof DefuseCard){
                found = true;
                index = lcv;
            }
        }
        if(index != -1)
            hand.remove(index);
        if (!found)
            eliminated = true;
    }

    /**
     * Retrieves the player's hand
     * @return the player's hand
     */
    public List<Card> getHand(){
        return hand;
    }

    /**
     * Retrieves the player's name
     * @return the player's name
     */
    public String getName(){
        return name;
    }

    /**
     * Draw a card from the deck;
     */
    public Card draw(){
        Card card = deck.draw();
        hand.add(card);
        return card;
    }

    /**
     * Plays a card from the player's hand
     * @param card the card to play from the player's hand
     */
    public void playCard(Card card){
        if(card instanceof DrawFromTheBottom)
            hand.add(deck.getDeck().remove(deck.getDeck().size() - 1));
        hand.remove(card);
        deck.setLastPlayed(card);
        card.play(deck);
    }

    public void playKitten(ExplodingKittenCard card){
        onExplode();
        hand.remove(card);
    }

    /**
     * Returns the deck
     * @return deck the game deck
     */
    public Deck getDeck(){return deck;}

    /**
     * Transfers the card to a certain player if possible
     *
     * @param other the player for the card to be transferred to
     * @param card  the card to be transferred
     */
    public void transfer(Player other, Card card){
        if(hand.remove(card)){
            other.getHand().add(card);
        }
    }

    /**
     * Adds a specific card to the Player's hand
     * @param card the type of card to add to the hand
     */
    public void addCardtoHand(Card card){
        hand.add(card);
    }

    /**
     * Gets the number of turns
     * @return numTurns the number of turns from the player
     */
    public int getNumTurns(){
        return numTurns;
    }

    /**
     * Sets the number of turns
     * @param extra the number of turns to set
     */
    public void setTurns(int extra){
        numTurns = extra;
    }

    /**
     * Retrieves whether the player has been eliminated or not
     * @return true if he was eliminated, false otherwise
     */
    public boolean isEliminated(){
        return eliminated;
    }


}
