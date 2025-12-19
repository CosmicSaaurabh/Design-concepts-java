package com.game.api;

import com.game.boards.TickTackToeBoard;
import com.game.my_game.*;

/**
 * Hello world!
 *
 */
public class GameEngine
{
    public Board start(String type) {
        if (type.equals("tick-tack-toe")) {
            return new TickTackToeBoard();
        }
        else {
            throw new UnsupportedOperationException("board type is unsupported");
        }
    }

    public void move(Board board, Move move) {
        if (board instanceof TickTackToeBoard) {
            board.move(move);
        }
    }

}


