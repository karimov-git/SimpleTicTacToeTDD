package com.tddjava.tictactoe;

/**
 * Created by lxuser on 6/28/17.
 */
public class TicTacToe {

    private Character[][] board = {
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'}
    };

    private char lastPlayer = '\0';
    private static final int SIZE = 3;

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);
        if (isWin()) {
            return lastPlayer + " is the winner";
        }
        return "No winner";
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("Axis is outside board");
        }
    }

    private void setBox(int x, int y, char lastPlayer) {
        if (board[x -1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        } else {
            board[x - 1][y - 1] = lastPlayer;
        }
    }

    private boolean isWin() {
        int playerTotal = lastPlayer * 3;
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] + board[1][i] + board[2][i] ==
                    playerTotal) {
                return true;
            } else if (board[i][0] + board[i][1] + board[i][2] ==
                    playerTotal) {
                return true;
            }
        }
        if (board[0][0] + board[1][1] + board[2][2] ==
                playerTotal) {
            return true;
        } else if (board[0][2] + board[1][1] + board[2][0] ==
                playerTotal) {
            return true;
        }
        return false;
    }
}
