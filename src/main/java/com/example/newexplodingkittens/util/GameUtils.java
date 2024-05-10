/**
 * The GameUtils class contains various tools for use in the game
 * @author Akhil Kasamsetty, Anish Alle, Andrew Li
 * Collaborators: N/A
 * Teacher Name: Ms. Bailey
 * Period: 6
 * Due Date: 5-10-2024
 */

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
