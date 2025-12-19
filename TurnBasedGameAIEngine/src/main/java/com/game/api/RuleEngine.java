package com.game.api;

import com.game.boards.TickTackToeBoard;
import com.game.my_game.Board;
import com.game.my_game.GameResult;

import java.util.function.BiFunction;
import java.util.function.Function;

public class RuleEngine {
    public GameResult getSate(Board board) {
        if (board instanceof TickTackToeBoard) {
            TickTackToeBoard tttBoard1 = (TickTackToeBoard) board;
            // check for tick-tack toe completion
            BiFunction<Integer, Integer, String> getNextRow = (i, j) -> tttBoard1.getCell(i, j);
            BiFunction<Integer, Integer, String> getNextCol = (i, j) -> tttBoard1.getCell(j, i);

            GameResult rowWin = isVictory(getNextRow);
            if (rowWin.isOver()) {
                return rowWin;
            }

            GameResult colWin = isVictory(getNextCol);
            if (colWin.isOver()) {
                return colWin;
            }

            // check for diagonal completion
            Function<Integer, String> getNextDiag = (i) -> tttBoard1.getCell(i, i);
            GameResult diagWin = isDiagVictory(getNextDiag);
            if (diagWin.isOver()) {
                return diagWin;
            }

            Function<Integer, String> getNextReverseDiag = (i) -> tttBoard1.getCell(i, 2 - i);
            GameResult reverseDiagWin = isDiagVictory(getNextReverseDiag);
            if (reverseDiagWin.isOver()) {
                return reverseDiagWin;
            }

            int countFilledCells = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tttBoard1.getCell(i, j) != null) {
                        countFilledCells++;
                    }
                }
            }

            if (countFilledCells == 9) {
                return new GameResult(true, "draw"); // return draw result
            } else {
                return new GameResult(false, ""); // game not over yet
            }
        } else {
            return new GameResult(false, ""); // unknown board type
        }
    }

    public static GameResult isVictory(BiFunction<Integer, Integer, String> getNextCharacter) {
        boolean possibleStreak = true;
        for (int i = 0; i < 3; i++) {
            possibleStreak = true;
            for (int j = 0; j < 3; j++) {
                if (getNextCharacter.apply(i,j) == null || !getNextCharacter.apply(i,0).equals(getNextCharacter.apply(i,j))) {
                    possibleStreak = false;
                    break;
                }
            }

            if (possibleStreak) {
                return new GameResult(true, getNextCharacter.apply(i,0)); // return winning result
            }
        }

        return new GameResult(false, null); // game not over yet
    }

    public GameResult isDiagVictory(Function<Integer, String> getNext) {
        boolean possibleStreak = true;
        for (int i = 0; i < 3; i++) {
            if (getNext.apply(i) == null || !getNext.apply(0).equals(getNext.apply(i))) {
                possibleStreak = false;
                break;
            }
        }

        if (possibleStreak) {
            return new GameResult(true, getNext.apply(0)); // return winning result
        } else {
            return new GameResult(false, null); // game not over yet
        }
    }
}
