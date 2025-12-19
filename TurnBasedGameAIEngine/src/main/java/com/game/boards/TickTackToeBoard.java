package com.game.boards;

import com.game.my_game.Board;
import com.game.my_game.Cell;
import com.game.my_game.Move;
import com.game.my_game.Player;

public class TickTackToeBoard implements Board {
    private String cells[][] = new String[3][3];

    public String getCell(int row, int col) {
        return cells[row][col];
    }

    private void setCell(Cell cell, String value) {
        if (getCell(cell.getRow(), cell.getCol()) != null) {
            throw new IllegalArgumentException("Cell is already occupied");
        }

        cells[cell.getRow()][cell.getCol()] = value;
    }

    @Override
    public void move(Move move) {
        Cell cell = move.getCell();
        Player player = move.getPlayer();
        setCell(cell, player.getPlayerSymbol());
    }

    @Override
    public TickTackToeBoard copy() {
        TickTackToeBoard newBoard = new TickTackToeBoard();
        for (int i = 0; i < 3; i++) {
            System.arraycopy(this.cells[i], 0, newBoard.cells[i], 0, 3);
        }
        return newBoard;
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
