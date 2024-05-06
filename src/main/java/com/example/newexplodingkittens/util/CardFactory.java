package com.example.newexplodingkittens.util;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.cards.*;
import com.example.newexplodingkittens.interfaces.Card;

import java.util.*;

public class CardFactory {

    //lists of card number allocations
    private static final int[] minPlayers = {2, 3,  4, 3, 2, 4};
    private static final int[] midPlayers = {3, 7,  5, 3, 4, 6};
    private static final int[] maxPlayers = {5, 10, 9, 6, 6, 10};

    //instance variables
    int numPlayers;
    List<Card> list;

    /**
     * Allocates a new CardFactory that creates and stores the number of players and a queue of cards
     * @param numPlayers the number of players in the game
     */
    public CardFactory(int numPlayers){
        this.numPlayers = numPlayers;
        list = new ArrayList<>();
        addAllCards(getCardNum());
    }

    /**
     * Retrieves the card number allocations based on the number of players
     * @return  the integer array of card number allocations
     */
    private int[] getCardNum(){
        if(numPlayers >= 8)
            return maxPlayers;
        if(numPlayers >= 4)
            return midPlayers;
        else
            return minPlayers;
    }

    /**
     * Adds all the necessary cards to a list based on the card allocations
     * @param cardNums the integer array of card number allocations
     */
    private void addAllCards(int[] cardNums){
        for(int lcv = 0; lcv < cardNums[0]; lcv++)
            list.add(new AttackCard());
        for(int lcv = 0; lcv < cardNums[1] - numPlayers; lcv++) //take out 1 defuse card for every player
            list.add(new DefuseCard());
        for(int lcv = 0; lcv < numPlayers-1; lcv++) //include 1 less than the number of players
            list.add(new ExplodingKittenCard());
        for(int lcv = 0; lcv < cardNums[2]; lcv++)
            list.add(new NopeCard());
        for(int lcv = 0; lcv < cardNums[3]; lcv++)
            list.add(new SeeTheFuture());
        for(int lcv = 0; lcv < cardNums[4]; lcv++)
            list.add(new ShuffleCard());
        for(int lcv = 0; lcv < cardNums[5]; lcv++)
            list.add(new SkipCard());
        Collections.shuffle(list);
    }

    /**
     * Retrieves the queue of cards
     *
     * @return the queue of cards
     */
    public List<Card> getList() {
        return list;
    }
}
