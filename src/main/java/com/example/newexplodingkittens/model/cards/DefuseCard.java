package com.example.newexplodingkittens.model.cards;

import com.example.newexplodingkittens.interfaces.Card;

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
    public void play() {

    }

    /**
     * Retrieves whether card type is nope-able
     * @return false b/c it is never nope-able
     */
    @Override
    public boolean isNopeable() {
        return false;
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
