package com.game.boards;

import com.game.my_game.Board;
import com.game.my_game.Cell;

public class TickTackToeBoard extends Board {
    protected String cells[][] = new String[3][3];

    public String getCell(int row, int col) {
        return cells[row][col];
    }

    public void setCell(Cell cell, String value) {
        cells[cell.getRow()][cell.getCol()] = value;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result += cells[i][j] == null ? "-" : cells[i][j];
                if (j < 2) result += "|";
            }
            result += "\n";
        }
        return result;
    }

}
