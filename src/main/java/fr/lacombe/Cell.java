package fr.lacombe;

class Cell {
    private boolean alive;
    private int nbNeighbor;

    Cell(boolean alive) {
        this.alive = alive;
        this.nbNeighbor = 0;
    }

    Cell(boolean alive, int nbNeighbor) {
        this.alive = alive;
        this.nbNeighbor = nbNeighbor;
    }

    boolean isAlive() {
        return alive;
    }

    void nextGeneration() {
        underpopulation();
        aliveNeighborsCondition();
        overpopulation();
    }

    private void aliveNeighborsCondition() {
        if(nbNeighbor == 3) alive = true;
    }

    private void overpopulation() {
        if(nbNeighbor > 3) alive = false;
    }

    private void underpopulation() {
        if(nbNeighbor < 2) alive = false;
    }
}
