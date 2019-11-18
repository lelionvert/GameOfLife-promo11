package fr.lacombe;

public class Neighbors {
    private int aliveNeighbors;

    public Neighbors(int aliveNeighbors) {
        this.aliveNeighbors = aliveNeighbors;
    }

    public int living() {
        return aliveNeighbors;
    }
}
