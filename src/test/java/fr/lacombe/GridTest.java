package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GridTest {
    @Test
    void create_game_with_three_living_cells_should_return_one_living_cell() {
        Cell cell1 = new Cell(State.ALIVE);
        Cell cell2 = new Cell(State.ALIVE);
        Cell cell3 = new Cell(State.ALIVE);

        cell1.makeNeighbors(cell2);
        cell2.makeNeighbors(cell3);

        Game game = new Game(cell1, cell2, cell3);
        game.nextGeneration();

        Assertions.assertThat(cell1.getNextState()).isEqualTo(State.DEAD);
        Assertions.assertThat(cell2.getNextState()).isEqualTo(State.ALIVE);
        Assertions.assertThat(cell3.getNextState()).isEqualTo(State.DEAD);
    }
}
