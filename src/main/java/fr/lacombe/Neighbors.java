package fr.lacombe;

import java.util.ArrayList;

public class Neighbors {
    private int aliveNeighbors;
    private ArrayList<Cell> cells = new ArrayList<>();
    private int MAX_NEIGHBORS = 8;

    public Neighbors(int aliveNeighbors) {
        this.aliveNeighbors = aliveNeighbors;
        for(int i = 0; i<aliveNeighbors; i++) {
            cells.add(new Cell(State.ALIVE));
            System.out.print(cells.get(i));
        }

    }

    public int living() {
        return aliveNeighbors;
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
