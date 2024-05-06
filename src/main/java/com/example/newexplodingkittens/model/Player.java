package com.example.newexplodingkittens.model;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.cards.DefuseCard;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Deck deck;
    private List<Card> hand;

    public Player(String name, Deck deck){
        this.name = name;
        this.deck = deck;
        hand = new ArrayList<>();
    }

    /** If an ExplodingKittenCard is drawn, then this function will return
     *  true if they live, false if they die.
     *
     * @return whether they live (true) or die (false)
     */
    public boolean onExplode(){
        for (Card card : hand)
            if (card instanceof DefuseCard)
                return true;
        return false;
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
    public void draw(){
        hand.add(deck.draw());
    }

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


}
