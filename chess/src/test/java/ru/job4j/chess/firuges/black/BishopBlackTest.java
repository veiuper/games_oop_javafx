package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

public class BishopBlackTest {

    @Test
    public void whenPositionForStartingNewGame() {
        Cell expected = Cell.F8;
        BishopBlack actual = new BishopBlack(expected);
        Assert.assertEquals(expected, actual.position());
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNotDiagonalWayCustom() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        bishopBlack.way(Cell.F7);
    }

    @Test
    public void whenWayCustom() {
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] actual = bishopBlack.way(Cell.G5);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void whenWayIsIncreasedXIsIncreasedY2Steps() {
        Cell[] expected = new Cell[]{Cell.E3, Cell.F2};
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] actual = bishopBlack.way(Cell.F2);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void whenWayIsNotIncreasedXIsNotIncreasedY2Steps() {
        Cell[] expected = new Cell[]{Cell.C5, Cell.B6};
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] actual = bishopBlack.way(Cell.B6);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void whenWayIsNotIncreasedXIsIncreasedY2Steps() {
        Cell[] expected = new Cell[]{Cell.C3, Cell.B2};
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] actual = bishopBlack.way(Cell.B2);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void whenWayIsIncreasedXIsNotIncreasedY2Steps() {
        Cell[] expected = new Cell[]{Cell.E5, Cell.F6};
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] actual = bishopBlack.way(Cell.F6);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void whenIsDiagonalCustom() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        boolean actual = bishopBlack.isDiagonal(bishopBlack.position(), Cell.E7);
        Assert.assertTrue(actual);
    }

    @Test
    public void whenNotDiagonalCustom() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        boolean actual = bishopBlack.isDiagonal(bishopBlack.position(), Cell.E6);
        Assert.assertFalse(actual);
    }

    @Test
    public void whenCopyCustomA8A3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell actual = bishopBlack.copy(Cell.A3).position();
        Assert.assertEquals(Cell.A3, actual);
    }
}