package com.game.GameEngineTest;

import com.game.api.AIEngine;
import com.game.api.GameEngine;
import com.game.api.RuleEngine;
import com.game.my_game.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class GamePlayTest {
    GameEngine gameEngine;
    RuleEngine ruleEngine;
    AIEngine aiEngine;
    @Before
    public void setUp() {
        // Setup logic will be implemented here
        gameEngine = new GameEngine();
        ruleEngine = new RuleEngine();
        aiEngine = new AIEngine();
    }

    private void runGame(Board board, int[][] moves) {
        int next = 0;
        // Game running logic will be implemented here
        Player currentPlayer = new Player("X");
        Player computerPlayer = new Player("O");

        while (!ruleEngine.getSate(board).isOver()) {
            System.out.println("Move for Player: " + currentPlayer.getPlayerSymbol());
            int row = moves[next][0], col = moves[next][1];
            gameEngine.move(board, new Move(new Cell(row, col), currentPlayer)); // get the row and column from user input
            next++;
            System.out.println(board.toString());
            GameResult gameResult = ruleEngine.getSate(board);
            if (!gameResult.isOver()) {
                // computer move after player move
                Move computerMove = aiEngine.SuggestMove(board, computerPlayer);// Suggest move for computer player
                System.out.println("Computer Player Move: (" + computerMove.getCell().getRow() + ", " + computerMove.getCell().getCol() + ")");
                gameEngine.move(board, computerMove);
            } else {
                System.out.println("Game Over! Winner: " + gameResult.getWinner());
            }
        }
    }

    @Test
    public void checkForRowWin() {
        // Test logic will be implemented here
        Board board = gameEngine.start("tick-tack-toe");

        int moves[][] = new int[][] {{1,0}, {1,1}, {1,2}}; // predefined moves for testing
        int next = 0;
        runGame(board, moves);

        Assert.assertTrue(ruleEngine.getSate(board).isOver());
        Assert.assertEquals("X", ruleEngine.getSate(board).getWinner());
    }

    @Test
    public void checkForColumnWin() {
        // Test logic will be implemented here
        Board board = gameEngine.start("tick-tack-toe");

        int moves[][] = new int[][] {{0,2}, {1,2}, {2,2}}; // predefined moves for testing
        int next = 0;
        runGame(board, moves);

        Assert.assertTrue(ruleEngine.getSate(board).isOver());
        Assert.assertEquals("X", ruleEngine.getSate(board).getWinner());
    }

    @Test
    public void checkForDiagonalWin() {
        // Test logic will be implemented here
        Board board = gameEngine.start("tick-tack-toe");

        int moves[][] =  new int[][] {{0,0}, {1,1}, {2,2}}; // predefined moves for testing
        int next = 0;
        runGame(board, moves);
        Assert.assertTrue(ruleEngine.getSate(board).isOver());
        Assert.assertEquals("X", ruleEngine.getSate(board).getWinner());
    }

    @Test
    public void checkForReverseDiagonalWin() {
        // Test logic will be implemented here
        Board board = gameEngine.start("tick-tack-toe");

        int moves[][] =  new int[][] {{0,2}, {1,1}, {2,0}}; // predefined moves for testing
        int next = 0;
        runGame(board, moves);
        Assert.assertTrue(ruleEngine.getSate(board).isOver());
        Assert.assertEquals("X", ruleEngine.getSate(board).getWinner());
    }

    @Test
    public void checkForComputerWin() {
        // Test logic will be implemented here
        Board board = gameEngine.start("tick-tack-toe");

        int moves[][] =  new int[][] {{0,1}, {1,1}, {2,0}}; // predefined moves for testing
        int next = 0;
        runGame(board, moves);
        Assert.assertTrue(ruleEngine.getSate(board).isOver());
        Assert.assertEquals("O", ruleEngine.getSate(board).getWinner());
    }
}
