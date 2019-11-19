package fr.lacombe;

class Cell {
    private State actualStateLife;
    private State nextStateLife;
    private Neighbors neighbors;

    Cell(State alive) {
        this.actualStateLife = alive;
        this.neighbors = new Neighbors();
    }

    State getState() {
        return actualStateLife;
    }
    State willBeAlive() { return nextStateLife; }

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

    boolean hasNeighborOf(Cell cell) {
        return neighbors.contains(cell);
    }

    void makeNeighbors(Cell cell) {
        addNeighbor(cell);
        cell.addNeighbor(this);
    }

    private void addNeighbor(Cell cell) {
        neighbors.add(cell);
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
}
