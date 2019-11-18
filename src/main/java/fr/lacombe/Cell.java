package fr.lacombe;

class Cell {
    private State alive;
    private int nbNeighbor;

    Cell(State alive) {
        this.alive = alive;
        this.nbNeighbor = 0;
    }

    Cell(State alive, int nbNeighbor) {
        this.alive = alive;
        this.nbNeighbor = nbNeighbor;
    }

    State isAlive() {
        return alive;
    }

    void nextGeneration() {
        underpopulation();
        aliveNeighborsCondition();
        overpopulation();
    }

    private void aliveNeighborsCondition() {
        if(nbNeighbor == 3) alive = State.ALIVE;
    }

    private void overpopulation() {
        if(nbNeighbor > 3) alive = State.DEAD;
    }

    private void underpopulation() {
        if(nbNeighbor < 2) alive = State.DEAD;
    }
}
