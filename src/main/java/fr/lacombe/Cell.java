package fr.lacombe;

class Cell {
    private State alive;
    private State nextGenerationState;
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
    State willBeAlive() {
        return nextGenerationState;
    }

    void nextGeneration() {
        underpopulation();
        aliveNeighborsCondition();
        overpopulation();
    }

    private void aliveNeighborsCondition() {
        if(neighbors.living() == 3) {
            nextGenerationState = State.ALIVE;
        }
        if(neighbors.living() == 2) {
            nextGenerationState = alive;
        }
    }

    private void overpopulation() {
        if(neighbors.living() > 3) {
            nextGenerationState = State.DEAD;
        }
    }

    private void underpopulation() {
        if(neighbors.living() < 2) {
            nextGenerationState = State.DEAD;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cell{");
        sb.append("alive=").append(alive);
        sb.append(", nextGenerationState=").append(nextGenerationState);
        sb.append(", neighbors=").append(neighbors);
        sb.append('}');
        return sb.toString();
    }
}
