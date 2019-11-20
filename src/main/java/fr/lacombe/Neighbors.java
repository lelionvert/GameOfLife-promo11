package fr.lacombe;

import java.util.ArrayList;

public class Neighbors {
    private ArrayList<Cell> cells;

    Neighbors() {
        this.cells = new ArrayList<>();
    }

    int living() {
        return (int) cells.stream()
                .filter(cell -> cell.getState() == State.ALIVE)
                .count();
    }

    void add(Cell cell) {
        cells.add(cell);
    }

    boolean contains(Cell cell) {
        return cells.stream().anyMatch(cell::equals);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Neighbors{");
        sb.append("cells=").append(cells);
        sb.append('}');
        return sb.toString();
    }
}
