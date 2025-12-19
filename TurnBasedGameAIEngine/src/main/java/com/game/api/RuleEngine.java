package com.game.api;

import com.game.boards.TickTackToeBoard;
import com.game.my_game.Board;
import com.game.my_game.GameResult;

public class RuleEngine {
    public GameResult getSate(Board board) {
        if (board instanceof TickTackToeBoard) {
            TickTackToeBoard tttBoard1 = (TickTackToeBoard) board;
            // check for tick-tack toe completion
            String firstCell = "-";
            boolean rowComplete = true;
            for (int i = 0; i < 3; i++) {
                // check row
                firstCell = tttBoard1.getCell(i,0); // get cell value at (i,0)
                rowComplete = firstCell == null ? false : true;
                if (firstCell != null) {
                    for (int j = 1; j < 3; j++) {
                        // check columns
                        if (!firstCell.equals(tttBoard1.getCell(i,j))) {
                            rowComplete = false;
                            break;
                        }
                    }
                }

                if (rowComplete) {
                    return new GameResult(true, firstCell); // return winning result
                }
            }

            if (rowComplete) {
                return new GameResult(true, firstCell);
            }

            // check for column completion
            boolean colComplete = true;
            for (int j = 0; j < 3; j++) {
                // check column
                firstCell = tttBoard1.getCell(0,j); // get cell value at (0,j)
                colComplete = firstCell == null ? false : true;
                if (firstCell != null) {
                    for (int i = 1; i < 3; i++) {
                        if (!firstCell.equals(tttBoard1.getCell(i, j))) {
                            colComplete = false;
                            break;
                        }
                    }

                    if (colComplete) {
                        return new GameResult(true, firstCell); // return winning result
                    }
                }
            }

            if (colComplete) {
                return new GameResult(true, firstCell); // return winning result
            }

            // check for diagonal completion
            firstCell = tttBoard1.getCell(0,0);
            boolean diag1Complete = firstCell == null ? false : true;
            for (int i = 1; i < 3; i++) {
                if (firstCell != null &&  !firstCell.equals(tttBoard1.getCell(i,i))) {
                    diag1Complete = false;
                    break;
                }
            }

            if (diag1Complete) {
                return new GameResult(true, firstCell); // return winning result
            }

            firstCell = tttBoard1.getCell(0,2);
            boolean diag2Complete = firstCell == null ? false : true;
            for (int i = 1; i < 3; i++) {
                if (firstCell != null && !firstCell.equals(tttBoard1.getCell(i,2 - i))) {
                    diag2Complete = false;
                    break;
                }
            }

            if (diag2Complete) {
                return new GameResult(true, firstCell); // return winning result
            }

            int countFilledCells = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tttBoard1.getCell(i,j) != null) {
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
}
