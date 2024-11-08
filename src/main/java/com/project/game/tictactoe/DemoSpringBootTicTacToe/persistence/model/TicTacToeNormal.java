package com.project.game.tictactoe.DemoSpringBootTicTacToe.persistence.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TicTacToeNormal extends Game {

    @Value("${symbol.player.x}")
    private char playerX;

    @Value("${symbol.player.o}")
    private char playerO;

    public TicTacToeNormal(@Value("${board.size}") int size) {
        super(size);
        this.player1 = new Player(playerX);
        this.player2 = new Player(playerO);
        this.currentPlayer = this.player1;
    }

    public void initGame(int size){
        this.board = new Board(size);
    }

    public void StatusBoard(){
        this.board.drawBoard();
    }

    @Override
    public boolean isGameOver() {
        if (this.isWinner()) {
            System.out.println("Player " + this.currentPlayer.getSymbol() + " is the winner.");
            return true;
        } else if (this.isBoardFull()) {
            System.out.println("It's a tie!");
            return true;
        }
        return false;
    }

    @Override
    public boolean nextTurn(String row, String col) {
        /*Scanner input = new Scanner(System.in);*/
        System.out.println("Player " + this.currentPlayer.getSymbol() + " turn");
        /*String rowInput = input.next();
        String colInput = input.next();*/
        if (isNumeric(row) && isNumeric(col)) {
            int x = Integer.parseInt(row) - 1;
            int y = Integer.parseInt(col) - 1;
            if (this.board.validateMove(x, y)) {
                this.board.updateBoard(x, y, this.currentPlayer.getSymbol());
                this.board.drawBoard();
                if (isGameOver()) {
                    return true;
                }
                switchPlayer();
            } else {
                System.out.println("Invalid move, try again.");
            }
        } else {
            System.out.println("Invalid input, please enter numbers only for row and column.");
        }
        return false;
    }

    private boolean isNumeric(String number) {
        return number.matches("\\d");
    }

    private void switchPlayer() {
        this.currentPlayer = (this.currentPlayer == this.player1) ? this.player2 : this.player1;
    }

    private boolean isWinner() {
        int i;
        char player;

        for(i = 0; i < this.board.size; ++i) {
            player = this.board.board[i][0];
            if (player != Symbol.EMPTY.getSymbol() && allEqual(player, this.board.board[i])) {
                return true;
            }
        }

        for(i = 0; i < this.board.size; ++i) {
            player = this.board.board[0][i];
            if (player != Symbol.EMPTY.getSymbol() && allEqual(player, this.getColumn(i))) {
                return true;
            }
        }

        player = this.board.board[0][0];

        if (player != Symbol.EMPTY.getSymbol() && allEqual(player, this.getDiagonal(true))) {
            return true;
        } else {
            player = this.board.board[0][this.board.size - 1];
            if (player != Symbol.EMPTY.getSymbol() && allEqual(player, this.getDiagonal(false))) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static boolean allEqual(char player, char[] line) {
        char[] var2 = line;
        int var3 = line.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            char cell = var2[var4];
            if (cell != player) {
                return false;
            }
        }

        return true;
    }

    private char[] getColumn(int col) {
        char[] column = new char[this.board.size];

        for(int i = 0; i < this.board.size; ++i) {
            column[i] = this.board.board[i][col];
        }

        return column;
    }

    private char[] getDiagonal(boolean mainDiagonal) {
        char[] diagonal = new char[this.board.size];

        for(int i = 0; i < this.board.size; ++i) {
            diagonal[i] = mainDiagonal ? this.board.board[i][i] : this.board.board[i][this.board.size - 1 - i];
        }
        return diagonal;
    }

    private boolean isBoardFull() {
        for(int i = 0; i < this.board.size; ++i) {
            for(int j = 0; j < this.board.size; ++j) {
                if (this.board.board[i][j] == Symbol.EMPTY.getSymbol()) {
                    return false;
                }
            }
        }
        return true;
    }
}