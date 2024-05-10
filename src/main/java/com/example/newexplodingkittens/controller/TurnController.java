/**
 * The TurnController class manages each player's turn
 * by storing and updating necessary info
 * @author Akhil Kasamsetty, Anish Alle, Andrew Li
 * Collaborators: N/A
 * Teacher Name: Ms. Bailey
 * Period: 6
 * Due Date: 5-10-2024
 */

package com.example.newexplodingkittens.controller;

import com.example.newexplodingkittens.model.Player;

import java.util.List;

public class TurnController {
    List<Player> playerList;
    Player currentPlayer;
    int index;

    /**
     * Creates a TurnController object
     * @param playerList the list of players that the controller is controlling
     */
    public TurnController(List<Player> playerList){
        this.playerList = playerList;
        currentPlayer = this.playerList.get(0);
        index = 0;
    }

    /**
     * Goes to the next player in the list
     * @return the next player in the list
     */
    public Player next(){
        if(index >= playerList.size()-1)
            index = 0;
        else
            index++;
        currentPlayer = playerList.get(index);
        return currentPlayer;
    }

    /**
     * Updates the player list
     * @param playerList the new player list to be updated with
     */
    public void updatePlayerList(List<Player> playerList){
        this.playerList = playerList;
    }

    /**
     * Retrieves the current player that is being managed
     * @return the current player
     */
    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    /**
     * Retrieves the index of the current player in the list of players
     * @return the index of the current player
     */
    public int getIndex(){return index;}

    /**
     * Retrieves the next player in the list of players
     * @return the next player
     */
    public Player getNextPlayer(){
        return playerList.get((index >= playerList.size() - 1) ? 0 : index+1);
    }

    /**
     * Sets the index value
     * @param newIndex the new index value
     * @return the new index value
     */
    public int setIndex(int newIndex) {
        index = newIndex;
        return index;
    }

}
