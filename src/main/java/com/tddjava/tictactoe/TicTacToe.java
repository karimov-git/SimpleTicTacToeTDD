package com.tddjava.tictactoe;

/**
 * Created by lxuser on 6/28/17.
 */
public class TicTacToe {

    private Character[][] board = {
            {'\0'}, {'\0'}, {'\0'},
            {'\0'}, {'\0'}, {'\0'},
            {'\0'}, {'\0'}, {'\0'}
    };

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("Axis is outside board");
        }
    }

    private void setBox(int x, int y) {
        if (board[x -1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        } else {
            board[x - 1][y - 1] = 'X';
        }
    }

    private char lastPlayer = 'O';

    public void play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setBox(x, y);
        lastPlayer = nextPlayer();
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }
}
