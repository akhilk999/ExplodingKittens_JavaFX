package com.example.newexplodingkittens.model;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.cards.DefuseCard;
import com.example.newexplodingkittens.model.cards.DrawFromTheBottom;
import com.example.newexplodingkittens.model.cards.ExplodingKittenCard;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Deck deck;
    private List<Card> hand;
    private boolean eliminated;
    public int numTurns;

    public Player(String name, Deck deck){
        this.name = name;
        this.deck = deck;
        hand = new ArrayList<>();
        eliminated = false;
        numTurns = 1;
    }

    /** If an ExplodingKittenCard is drawn, then this function will return
     *  true if they live, false if they die.
     *
     * @return whether they live (true) or die (false)
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
     * @param other the player for the card to be transferred to
     * @param card the card to be transferred
     * @return true if transferred, false if not
     */
    public boolean transfer(Player other, Card card){
        if(hand.remove(card)){
            other.getHand().add(card);
            return true;
        }
        return false;
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
    public boolean isEliminated(){
        return eliminated;
    }


}
