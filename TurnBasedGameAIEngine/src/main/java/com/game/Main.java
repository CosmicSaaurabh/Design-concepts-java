package com.game;

import com.game.api.GameEngine;
import com.game.my_game.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Turn-Based Game AI Engine!");

        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("tick-tack-toe");
        Player currentPlayer = new Player("X");
        Player computerPlayer = new Player("O");
        Scanner sc = new Scanner(System.in);
        while (!gameEngine.isComplete(board).isOver()) {
            System.out.println("Move for Player: " + currentPlayer.getPlayerSymbol());
            int row = sc.nextInt(), col = sc.nextInt();
            gameEngine.move(board, currentPlayer, new Move(new Cell(row, col), currentPlayer)); // get the row and column from user input

            System.out.println(board.toString());
            GameResult gameResult = gameEngine.isComplete(board);
            if (!gameResult.isOver()) {
                // computer move after player move
                Move computerMove = gameEngine.SuggestMove(board, computerPlayer);// Suggest move for computer player
                System.out.println("Computer Player Move: (" + computerMove.getCell().getRow() + ", " + computerMove.getCell().getCol() + ")");
                gameEngine.move(board, computerPlayer, computerMove);
                System.out.println(board.toString());
            } else {
                System.out.println("Game Over! Winner: " + gameResult.getWinner());
            }
        }
    }
}
