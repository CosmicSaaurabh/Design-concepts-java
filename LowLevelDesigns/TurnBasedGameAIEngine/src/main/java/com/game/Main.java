package com.game;

import com.game.api.AIEngine;
import com.game.api.GameEngine;
import com.game.api.RuleEngine;
import com.game.my_game.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Turn-Based Game AI Engine!");

        GameEngine gameEngine = new GameEngine();
        AIEngine aiEngine = new AIEngine();
        RuleEngine ruleEngine = new RuleEngine();

        Board board = gameEngine.start("tick-tack-toe");
        Player currentPlayer = new Player("X");
        Player computerPlayer = new Player("O");
        Scanner sc = new Scanner(System.in);
        while (!ruleEngine.getSate(board).isOver()) {
            System.out.println("Move for Player: " + currentPlayer.getPlayerSymbol());
            int row = sc.nextInt(), col = sc.nextInt();
            gameEngine.move(board, new Move(new Cell(row, col), currentPlayer)); // get the row and column from user input

            System.out.println(board.toString());
            GameResult gameResult = ruleEngine.getSate(board);
            if (!gameResult.isOver()) {
                // computer move after player move
                Move computerMove = aiEngine.SuggestMove(board, computerPlayer);// Suggest move for computer player
                System.out.println("Computer Player Move: (" + computerMove.getCell().getRow() + ", " + computerMove.getCell().getCol() + ")");
                gameEngine.move(board, computerMove);
                System.out.println(board.toString());
            } else {
                System.out.println("Game Over! Winner: " + gameResult.getWinner());
            }
        }
    }
}
