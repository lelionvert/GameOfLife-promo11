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
        if(nbNeighbor == 3 && !alive){
            alive = true;
            return;
        };
        if(nbNeighbor == 3) return;
        if(nbNeighbor == 2) return;
        alive = false;
    }
}
