package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class NeighborsTest {

    @Test
    public void living_count_should_return_zero_if_cell_has_dead_neighbors() {
        //Given
        Neighbors neighbor = new Neighbors();
        neighbor.add(new Cell(State.DEAD));

        //When
        int result = neighbor.livingCount();

        //Then
        Assertions.assertThat(result).isEqualTo(0);
    }
}
