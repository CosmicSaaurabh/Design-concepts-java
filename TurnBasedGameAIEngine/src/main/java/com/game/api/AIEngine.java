package com.game.api;

import com.game.boards.TickTackToeBoard;
import com.game.my_game.Board;
import com.game.my_game.Cell;
import com.game.my_game.Move;
import com.game.my_game.Player;

public class AIEngine {
    public Move SuggestMove(Board board, Player player) {
        if (board instanceof TickTackToeBoard) {
            TickTackToeBoard tttBoard = (TickTackToeBoard) board;
            // simple AI: choose the first empty cell
//            System.out.println("Suggesting move for player: " + player.getPlayerSymbol());
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tttBoard.getCell(i,j) == null) {
//                        System.out.println("Suggesting move at: (" + i + ", " + j + ")");
                        return new Move(new Cell(i,j), player);
                    }
                }
            }
        }

        return null; // no move possible
    }
}
