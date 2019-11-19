package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NeighborsTest {
    @Test
    void add_neighbor_cell2_to_cell1_should_make_cell2_neighbor_of_cell1() {
        Cell cell1 = new Cell(State.ALIVE);
        Cell cell2 = new Cell(State.ALIVE);
        cell1.addNeighbor(cell2);
        boolean result = cell1.hasNeighborOf(cell2);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void add_neighbor_cell2_to_cell1_should_make_cell1_neighbor_of_cell2() {
        Cell cell1 = new Cell(State.ALIVE);
        Cell cell2 = new Cell(State.ALIVE);
        cell1.addNeighbor(cell2);
        boolean result = cell2.hasNeighborOf(cell1);

        Assertions.assertThat(result).isTrue();
    }
}
