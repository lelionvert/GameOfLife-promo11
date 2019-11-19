package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class NeighborsTest {

    @Test
    public void living_should_return_zero_if_cell_has_dead_neighbors() {
        Neighbors neighbor = new Neighbors();
        neighbor.add(new Cell(State.DEAD));
        Assertions.assertThat(neighbor.living()).isEqualTo(0);
    }
}
