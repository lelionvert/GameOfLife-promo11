package fr.lacombe;

import java.util.ArrayList;

public class Neighbors {
    //TODO: un set plutot qu'une liste (non duplicité de voisins)
    private ArrayList<Cell> cells;

    Neighbors() {
        this.cells = new ArrayList<>();
    }

    int livingCount() {
        return (int) cells.stream()
                .filter(cell -> cell.getState() == State.ALIVE)
                .count();
    }

    void add(Cell cell) {
        cells.add(cell);
    }

    boolean contains(Cell cell) {
        //TODO: avec un set la complexité est en temps constant plutot qu'en temps linéaire.
        return cells.contains(cell);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Neighbors{");
        sb.append("cells=").append(cells);
        sb.append('}');
        return sb.toString();
    }
}
