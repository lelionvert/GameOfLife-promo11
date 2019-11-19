package fr.lacombe;

class Cell {
    private State actualStateLife;
    private State nextStateLife;
    private Neighbors neighbors;

    Cell(State alive) {
        this.actualStateLife = alive;
        this.neighbors = new Neighbors();
    }

    State isAlive() {
        return actualStateLife;
    }
    State willBeAlive() {
        return nextStateLife;
    }

    void nextGeneration() {
        underpopulation();
        aliveNeighborsCondition();
        overpopulation();
    }

    private void aliveNeighborsCondition() {
        if(neighbors.living() == 3) {
            nextStateLife = State.ALIVE;
        }
        if(neighbors.living() == 2) {
            nextStateLife = actualStateLife;
        }
    }

    private void overpopulation() {
        if(neighbors.living() > 3) {
            nextStateLife = State.DEAD;
        }
    }

    private void underpopulation() {
        if(neighbors.living() < 2) {
            nextStateLife = State.DEAD;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cell{");
        sb.append("alive=").append(actualStateLife);
        sb.append(", nextGenerationState=").append(nextStateLife);
        sb.append(", neighbors=").append(neighbors);
        sb.append('}');
        return sb.toString();
    }

    public boolean isNeighborOf(Cell cellRight) {
        return neighbors.contains(cellRight);
    }

    public void addNeighbor(Cell cellRight) {
        neighbors.add(cellRight);
    }
}
