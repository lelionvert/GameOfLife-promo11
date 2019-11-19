package fr.lacombe;

import java.util.ArrayList;

public class Neighbors {
    private int aliveNeighbors;
    private ArrayList<Cell> cells;
    private int MAX_NEIGHBORS = 8;

    public Neighbors(int aliveNeighbors) {
        this.aliveNeighbors = aliveNeighbors;
        this.cells = new ArrayList<>();
    }

    public int living() {
        return aliveNeighbors;
    }

    public void add(Cell cellRight) {
        cells.add(cellRight);
    }

    public boolean contains(Cell cellRight) {
        boolean equal = false;
        for(int i = 0; i<aliveNeighbors; i++) {
            if(cellRight.equals(cells.get(i)))
                equal = true;
        }
        return equal;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Neighbors{");
        sb.append("aliveNeighbors=").append(aliveNeighbors);
        sb.append(", cells=").append(cells);
        sb.append(", MAX_NEIGHBORS=").append(MAX_NEIGHBORS);
        sb.append('}');
        return sb.toString();
    }
}
