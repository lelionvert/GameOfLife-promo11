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
        boolean alive = true;
        Cell cell = new Cell(alive);

        boolean result = cell.isAlive();

        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void isAlive_is_false_if_a_cell_is_dead()
    {
        boolean dead = false;
        Cell cell = new Cell(dead);

        boolean result = cell.isAlive();

        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void next_generation_kill_cell_if_no_neighbors()
    {
        // Given
        boolean alive = true;
        Cell cell = new Cell(alive);

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
        boolean alive = true;
        Cell cell = new Cell(alive, 2);

        // When
        cell.nextGeneration();

        // Then
        boolean result = cell.isAlive();
        Assertions.assertThat(result).isTrue();
    }

}
