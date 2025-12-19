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

            Move suggestedMove = null;
            if (isStarting(tttBoard, 2)) {
                // take basic move
                suggestedMove = getBasicMove(tttBoard, player);
            } else {
                suggestedMove = getSmartMove(tttBoard, player);
            }
            if (suggestedMove != null) {
                return suggestedMove;
            }

            throw new IllegalStateException();
        } else {
            throw new IllegalArgumentException("Invalid board type for AI Engine");
        }
    }

    public Move getBasicMove(TickTackToeBoard board, Player player) {
        // simple AI: choose the first empty cell
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(i,j) == null) {
//                        System.out.println("Suggesting move at: (" + i + ", " + j + ")");
                    return new Move(new Cell(i,j), player);
                }
            }
        }
        return null;
    }

    public Boolean isStarting(TickTackToeBoard board, int threshold) {
        int moveCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(i,j) != null) {
                    moveCount++;
                }
            }
        }

        return moveCount < threshold;
    }

    public Move getSmartMove(TickTackToeBoard board, Player player) {
        // smarter AI: block opponent's winning move or take winning move
        Player opponentPlayer = player.flipSymbol();
        RuleEngine ruleEngine = new RuleEngine();
        // Check for winning move
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(i,j) == null) {
                    Move current_move = new Move(new Cell(i,j), player);
                    TickTackToeBoard boardCopy = board.copy();
                    boardCopy.move(current_move);

                    if (ruleEngine.getSate(boardCopy).isOver() && ruleEngine.getSate(boardCopy).getWinner().equals(player.getPlayerSymbol())) {
//                        undoMove(current_move); // will not revert move, instead make a copy of board and test
                        return current_move;
                    }
//                    board.move(new Move(new Cell(i,j), new Player("-"))); // revert move
//                    undoMove(board, current_move); will not revert move, instead make a copy of board and test
                }
            }
        }

        // Check for blocking opponent's winning move
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(i,j) == null) {
                    Move current_move = new Move(new Cell(i,j), opponentPlayer);
                    TickTackToeBoard boardCopy = board.copy();
                    boardCopy.move(current_move);

                    if (new RuleEngine().getSate(boardCopy).isOver() && new RuleEngine().getSate(boardCopy).getWinner().equals(opponentPlayer.getPlayerSymbol())) {
//                        board.move(new Move(new Cell(i,j), new Player("-"))); // revert move
                        return new Move(new Cell(i,j), player);
                    }
//                    board.move(new Move(new Cell(i,j), new Player("-"))); // revert move
                }
            }
        }

        // If no winning or blocking move, return basic move
        return getBasicMove(board, player);
    }
}
