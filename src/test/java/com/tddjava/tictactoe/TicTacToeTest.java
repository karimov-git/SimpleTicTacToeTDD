package com.tddjava.tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by lxuser on 6/28/17.
 */
public class TicTacToeTest {

    @Rule
    public ExpectedException exception =
            ExpectedException.none();
    private TicTacToe ticTacToe;

    @Before
    public final void before() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(5, 2);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 5);
    }

    @Test
    public void whenOccupiedThenRuntimeException() {
        ticTacToe.play(2, 1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 1);
    }

    @Test
    public void givenLastTurnWasXWhenNextPlayerThenO() throws Exception {
        ticTacToe.play(1, 1);
        assertEquals('O', ticTacToe.nextPlayer());
    }

    @Test
    public void givenFirstTurnWhenNexTPlayerThenX() throws Exception {
        assertEquals('X', ticTacToe.nextPlayer());
    }
}