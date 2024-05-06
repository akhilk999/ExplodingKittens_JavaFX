package com.example.newexplodingkittens.util;

import com.example.newexplodingkittens.interfaces.Card;

import java.util.*;

/** Use for Shuffle, pick card logic, etc **/
public class GameUtils {

    /**
     * Shuffles the given queue of cards
     * @param list the given queue of cards
     * @return  the shuffled queue of cards
     */
    public static List<Card> shuffle(List<Card> list){
        Collections.shuffle(list);
        return list;
    }
}
