package fr.lacombe;

public class Cell {
    private boolean alive;
    private int nbNeighbor;

    public Cell(boolean alive) {
        this.alive = alive;
        this.nbNeighbor = 0;
    }

    public Cell(boolean alive, int nbNeighbor) {
        this.alive = alive;
        this.nbNeighbor = nbNeighbor;
    }

    public boolean isAlive() {
        return alive;
    }

    public void nextGeneration() {
        if(nbNeighbor == 2) return;
        alive = false;
    }
}
