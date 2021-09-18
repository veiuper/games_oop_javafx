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
        int ratioX = (dest.getX() > position().getX()) ? 1 : -1;
        int ratioY = (dest.getY() > position().getY() ? 1 : -1);
        int size = Math.abs(dest.getX() - position().getX());
        Cell[] steps = new Cell[size];
        for (int i = 0; i < size; i++) {
            int curX = position().getX() + ratioX * (i + 1);
            int curY = position().getY() + ratioY * (i + 1);
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
