package com.project.game.tictactoe.DemoSpringBootTicTacToe.persistence.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Board {
    int size;
    char[][] board;

    public Board(@Value("${board.size}") int size) {
        this.size = size;
        this.board = new char[size][size];
        initBoard();
    }

    public void drawBoard() {
        System.out.println("-------------");
        for (int i = 0; i < this.size; ++i) {
            System.out.print("| ");
            for (int j = 0; j < this.size; ++j) {
                System.out.print(this.board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public void initBoard() {
        for (int i = 0; i < this.size; ++i) {
            for (int j = 0; j < this.size; ++j) {
                this.board[i][j] = Symbol.EMPTY.getSymbol();
            }
        }
    }

    public void updateBoard(int x, int y, char symbol) {
        this.board[x][y] = symbol;
    }

    public boolean validateMove(int x, int y) {
        return x >= 0 && x < this.size && y >= 0 && y < this.size && this.board[x][y] == Symbol.EMPTY.getSymbol();
    }
}