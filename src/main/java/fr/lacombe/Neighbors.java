package fr.lacombe;

import java.util.ArrayList;

public class Neighbors {
    private ArrayList<Cell> cells;

    Neighbors() {
        this.cells = new ArrayList<>();
    }

    int living() {
        int cpt = 0;
        for (Cell cell: cells) {
            if(cell.getState() == State.DEAD) return 0;
            cpt++;
        }
        return cpt;
    }

    void add(Cell cellRight) {
        cells.add(cellRight);
    }

    boolean contains(Cell cellRight) {
        boolean equal = false;
        for (Cell cell : cells) {
            if (cellRight.equals(cell))
                equal = true;
        }
        return equal;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Neighbors{");
        sb.append("cells=").append(cells);
        sb.append('}');
        return sb.toString();
    }
}
