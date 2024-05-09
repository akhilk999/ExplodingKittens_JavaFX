package com.example.newexplodingkittens.controller;

import com.example.newexplodingkittens.model.Player;

import java.util.List;

public class TurnController {
    List<Player> playerList;
    Player currentPlayer;
    int index;
    boolean isDone;
    public TurnController(List<Player> playerList){
        this.playerList = playerList;
        currentPlayer = this.playerList.get(0);
        index = 0;
        isDone = false;
    }

    public Player next(){
        if(index == playerList.size()-1)
            index = 0;
        else
            index++;
        currentPlayer = playerList.get(index);
        return currentPlayer;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public boolean getIsDone(){return isDone;}
    public void endGame(){
        isDone = true;
    }

}
