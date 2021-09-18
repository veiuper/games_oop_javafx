package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

public class LogicTest {

    @Test(expected = FigureNotFoundException.class)
    public void whenMoveFigureNotFoundExceptionCustom()
            throws OccupiedCellException, ImpossibleMoveException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F7));
        logic.move(Cell.A1, Cell.H7);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveImpossibleMoveExceptionCustom()
            throws OccupiedCellException, ImpossibleMoveException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.move(Cell.F8, Cell.G8);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenMoveOccupiedCellExceptionCustom()
            throws OccupiedCellException, ImpossibleMoveException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new PawnBlack(Cell.G7));
        logic.move(Cell.F8, Cell.G7);
    }
}