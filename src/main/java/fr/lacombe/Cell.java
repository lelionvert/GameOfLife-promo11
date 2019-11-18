package fr.lacombe;

class Cell {
    private State alive;
    private Neighbors neighbors;

    Cell(State alive) {
        this.alive = alive;
        this.neighbors = new Neighbors(0);
    }

    Cell(State alive, int nbNeighbors) {
        this.alive = alive;
        this.neighbors = new Neighbors(nbNeighbors);
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
        if(neighbors.living() == 3) alive = State.ALIVE;
    }

    private void overpopulation() {
        if(neighbors.living() > 3) alive = State.DEAD;
    }

    private void underpopulation() {
        if(neighbors.living() < 2) alive = State.DEAD;
    }
}
