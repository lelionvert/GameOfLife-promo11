package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NeighborsTest {
    @Test
    void add_cell_to_neighborhood() {
        Cell cell1 = new Cell(State.ALIVE);
        Cell cell2 = new Cell(State.ALIVE);
        cell1.addNeighbor(cell2);
        boolean result = cell1.isNeighborOf(cell2);
        boolean expected = cell2.isNeighborOf(cell1);

        Assertions.assertThat(result).isEqualTo(expected);

    }
}
