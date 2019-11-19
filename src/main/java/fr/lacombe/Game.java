package fr.lacombe;

public class Game {
    private final Cell cell1;
    private final Cell cell2;
    private final Cell cell3;

    public Game(Cell cell1, Cell cell2, Cell cell3) {

        this.cell1 = cell1;
        this.cell2 = cell2;
        this.cell3 = cell3;
    }

    public void nextGeneration() {
        cell1.nextGeneration();
        cell2.nextGeneration();
        cell3.nextGeneration();
     }
}
