package com.example.newexplodingkittens.model.cards;

import com.example.newexplodingkittens.interfaces.Card;
import com.example.newexplodingkittens.model.Deck;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class DefuseCard implements Card {

    /**
     * Place a card and carry out it's action, removing the card
     * from the user's hand
     */
    @Override
    public void play(Deck deck) {

    }

    /**
     * Retrieves whether card consumes turn when played
     * @return true b/c it consumes turn
     */
    @Override
    public boolean consumesTurn() {
        return true;
    }

    /**
     * Retrieves the card's images
     * @return array of card's images
     */
    @Override
    public ImageIcon[] getImages() throws IOException {
        ImageIcon[] images = new ImageIcon[5];
        images[0] = new ImageIcon(ImageIO.read(new File("src/images/defuse/Laser-Pointer.jpg")));
        return images;
    }

    /**
     * Retrieves the name of the card
     * @return  the card's name
     */
    @Override
    public String toString(){
        return "Defuse";
    }

}
