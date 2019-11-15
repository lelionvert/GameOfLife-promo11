package fr.lacombe;

public class Cell {
    private boolean alive;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void nextGeneration() {
        alive = false;
    }
}
