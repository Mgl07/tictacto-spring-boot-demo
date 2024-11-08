package com.project.game.tictactoe.DemoSpringBootTicTacToe.persistence.model;

public class Player {

    private char symbolPlayer, symbolO;

    public Player(char symbolPlayer) {
        this.symbolPlayer = symbolPlayer;
    }

    public char getSymbol() {
        return this.symbolPlayer;
    }
}
