package com.example.newexplodingkittens.interfaces;


import javax.swing.*;
import java.io.IOException;
import com.example.newexplodingkittens.model.Deck;

public  interface Card {
    void play(Deck deck);
    boolean consumesTurn();
    ImageIcon[] getImages() throws IOException;
}
