package com.project.game.tictactoe.DemoSpringBootTicTacToe.config;

import com.project.game.tictactoe.DemoSpringBootTicTacToe.persistence.model.TicTacToeInverted;
import com.project.game.tictactoe.DemoSpringBootTicTacToe.persistence.model.TicTacToeNormal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    @Value("${board.size}")
    private int boardSize;

    @Bean
    public TicTacToeNormal ticTacToeNormal(){
        return new TicTacToeNormal(boardSize);
    }

    @Bean
    public TicTacToeInverted ticTacToeInverted(){
        return new TicTacToeInverted(boardSize);
    }
}
