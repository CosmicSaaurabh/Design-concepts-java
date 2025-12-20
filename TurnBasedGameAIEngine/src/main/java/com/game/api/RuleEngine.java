package com.game.api;

import com.game.boards.TickTackToeBoard;
import com.game.my_game.Board;
import com.game.my_game.GameResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class RuleEngine {
    Map<String, List<Rule>> ruleMap = new HashMap<>();

    public RuleEngine() {
        // initialize rules for different board types
        ruleMap.put(TickTackToeBoard.class.getName(), new ArrayList<>());
    }
    public GameResult getSate(Board board) {
        if (board instanceof TickTackToeBoard) {
            TickTackToeBoard tttBoard1 = (TickTackToeBoard) board;
//            List<Rule> rules = ruleMap.get(TickTackToeBoard.class.getName());
//            for (Rule rule: rules) {
//                if (rule.conditions.apply(tttBoard1)) {
//                    // return rule result
//                    // return new GameResult(true, "X"); // example
//                }
//            }
            // check for tick-tack toe completion
            BiFunction<Integer, Integer, String> getNextRow = (i, j) -> tttBoard1.getCell(i, j);

            GameResult rowWin = OuterTraversal(getNextRow);
            if (rowWin.isOver()) return rowWin;

            BiFunction<Integer, Integer, String> getNextCol = (i, j) -> tttBoard1.getCell(j, i);
            GameResult colWin = OuterTraversal(getNextCol);
            if (colWin.isOver()) return colWin;


            // check for diagonal completion
            Function<Integer, String> getNextDiag = (i) -> tttBoard1.getCell(i, i);
            GameResult diagWin = Traversal(getNextDiag);
            if (diagWin.isOver()) return diagWin;


            Function<Integer, String> getNextReverseDiag = (i) -> tttBoard1.getCell(i, 2 - i);
            GameResult reverseDiagWin = Traversal(getNextReverseDiag);
            if (reverseDiagWin.isOver()) return reverseDiagWin;


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

    public static GameResult OuterTraversal(BiFunction<Integer, Integer, String> getNextCharacter) {
        GameResult result = new GameResult(false, "-");
        for (int i = 0; i < 3; i++) {
            final int ii = i;
            GameResult traversal = Traversal(j -> getNextCharacter.apply(ii, j));
            if (traversal.isOver()) {
                result = traversal;
                break;
            }
        }

        return result; // game not over yet
    }

    public static GameResult Traversal(Function<Integer, String> getNextCharacter) {
        GameResult result = new GameResult(false, "-");
        for (int j = 0; j < 3; j++) {
            if (getNextCharacter.apply(j) == null || !getNextCharacter.apply(0).equals(getNextCharacter.apply(j))) {
                return result;
            }
        }

        return new GameResult(true, getNextCharacter.apply(0)); // return winning result
    }
}

class Rule {
    Function<Board, Boolean> conditions;

    Rule(Function<Board, Boolean> conditions) {
        this.conditions = conditions;
    }
}
