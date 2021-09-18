package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position(), dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int deltaX = dest.getX() - position().getX();
        int deltaY = dest.getY() - position().getY();
        int size = Math.abs(deltaX);
        Cell[] steps = new Cell[size];
        for (int i = 0; i < size; i++) {
            int curX = (deltaX < 0) ? position().getX() - 1 - i : position().getX() + 1 + i;
            int curY = (deltaY < 0) ? position().getY() - 1 - i : position().getY() + 1 + i;
            steps[i] = Cell.findBy(curX, curY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY()));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
