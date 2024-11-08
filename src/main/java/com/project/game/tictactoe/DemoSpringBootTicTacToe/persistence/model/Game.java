package com.project.game.tictactoe.DemoSpringBootTicTacToe.persistence.model;

public abstract class Game {
    Board board;
    Player player1;
    Player player2;
    Player currentPlayer;

    public Game(int size) {
        this.board = new Board(size);
    }

    public abstract boolean nextTurn(String row, String col);

    public abstract boolean isGameOver();
}