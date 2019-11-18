package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test

    public void isAlive_is_true_if_a_cell_is_alive() {
        Cell cell = new Cell(true);

        boolean result = cell.isAlive();

        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void isAlive_is_false_if_a_cell_is_dead() {
        Cell cell = new Cell(false);

        boolean result = cell.isAlive();

        Assertions.assertThat(result).isFalse();
    }


    @Test
    public void next_generation_kill_cell_if_no_neighbors() {
        // Given
        Cell cell = new Cell(true);

        // When
        cell.nextGeneration();

        // Then
        boolean result = cell.isAlive();
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void next_generation_kill_cell_if_two_living_neighbors() {
        // Given
        Cell cell = new Cell(true, 2);

        // When
        cell.nextGeneration();

        // Then
        boolean result = cell.isAlive();
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void next_generation_kill_cell_if_three_living_neighbors() {
        // Given
        Cell cell = new Cell(true, 3);

        // When
        cell.nextGeneration();

        // Then
        boolean result = cell.isAlive();
        Assertions.assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {
            //underpopulation
            "true, 0, false",
            "true, 1, false",
            //viable
            "true, 2, true",
            "true, 3, true",
            //overpopulation
            "true, 4, false",
            "true, 5, false",
            //still dead
            "false, 2, false"
            //birth of dead cell
            //"false, 3, true"
    })
    public void toto(
            boolean alive, int nbNeighbours, boolean expected) {
        // Given
        Cell cell = new Cell(alive, nbNeighbours);

        // When
        cell.nextGeneration();

        // Then
        boolean result = cell.isAlive();
        Assertions.assertThat(result).isEqualTo(expected);
    }


}
