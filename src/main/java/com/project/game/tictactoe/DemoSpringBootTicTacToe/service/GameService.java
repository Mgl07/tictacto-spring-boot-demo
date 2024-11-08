package com.project.game.tictactoe.DemoSpringBootTicTacToe.service;


import com.project.game.tictactoe.DemoSpringBootTicTacToe.persistence.model.TicTacToeNormal;
import com.project.game.tictactoe.DemoSpringBootTicTacToe.persistence.model.TicTacToeInverted;
import com.project.game.tictactoe.DemoSpringBootTicTacToe.persistence.model.Game;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class GameService {

    private TicTacToeNormal ticTacToeNormal;
    private TicTacToeInverted ticTacToeInverted;
    private int gameTypeNormal,gameTypeInverted;

    public GameService(TicTacToeNormal ticTacToeNormal,TicTacToeInverted ticTacToeInverted){
        this.ticTacToeNormal = ticTacToeNormal;
        this.ticTacToeInverted = ticTacToeInverted;
    }

    public void startGame(int gameType, int size) {
        if (gameType == 1) {
            gameTypeNormal = gameType;
            ticTacToeNormal.initGame(size);
        } else if (gameType == 2) {
            gameTypeInverted = gameType;
            ticTacToeInverted.initGame(size);
        } else {
            throw new IllegalArgumentException("Invalid game type. Choose 'normal' or 'inverted'.");
        }
    }

    public boolean movement(String row, String col) {
        if (ticTacToeNormal != null && gameTypeNormal == 1) {
            return ticTacToeNormal.nextTurn(row, col);
        } else if (ticTacToeInverted != null && gameTypeInverted == 2) {
            return ticTacToeInverted.nextTurn(row, col);
        }else {
            throw new IllegalStateException("Game not started yet.");
        }

    }

    public void getStatusBoard(){
        ticTacToeNormal.StatusBoard();
    }
}