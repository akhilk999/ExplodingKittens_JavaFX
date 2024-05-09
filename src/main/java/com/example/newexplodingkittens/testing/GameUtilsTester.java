package com.example.newexplodingkittens.testing;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.cards.*;
import com.example.newexplodingkittens.util.GameUtils;

import java.util.ArrayList;
import java.util.List;

public class GameUtilsTester {
    public static void main(String[] args){

        System.out.println("Testing GameUtils.java");
        System.out.println("Testing Shuffle");
        System.out.println();

        List<Card> list = addCards();
        System.out.println("Unshuffled List: " + list);
        for(int lcv = 0; lcv < 3; lcv++){
            list = GameUtils.shuffle(list);
            System.out.println("Shuffled List #" + (lcv+1) + ": " + list);
        }
        System.out.println();
    }

    private static List<Card> addCards(){
        List<Card> cards = new ArrayList<>();
        for(int lcv = 0; lcv < 2; lcv++)
            cards.add(new AttackCard());
        for(int lcv = 0; lcv < 1; lcv++)
            cards.add(new DefuseCard());
        for(int lcv = 0; lcv < 2; lcv++)
            cards.add(new ExplodingKittenCard());
        for(int lcv = 0; lcv < 3; lcv++)
            cards.add(new FindKitten());
        return cards;
    }
}
