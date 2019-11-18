package fr.lacombe;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test

    public void isAlive_is_true_if_a_cell_is_alive()
    {
        Cell cell = new Cell(true);

        boolean result = cell.isAlive();

        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void isAlive_is_false_if_a_cell_is_dead()
    {
        Cell cell = new Cell(false);

        boolean result = cell.isAlive();

        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void next_generation_kill_cell_if_no_neighbors()
    {
        // Given
        Cell cell = new Cell(true);

        // When
        cell.nextGeneration();

        // Then
        boolean result = cell.isAlive();
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void next_generation_kill_cell_if_two_living_neighbors()
    {
        // Given
        Cell cell = new Cell(true, 2);

        // When
        cell.nextGeneration();

        // Then
        boolean result = cell.isAlive();
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void next_generation_kill_cell_if_three_living_neighbors()
    {
        // Given
        Cell cell = new Cell(true, 3);

        // When
        cell.nextGeneration();

        // Then
        boolean result = cell.isAlive();
        Assertions.assertThat(result).isTrue();
    }

}
