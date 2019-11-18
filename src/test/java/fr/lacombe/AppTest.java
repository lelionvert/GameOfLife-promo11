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

    @ParameterizedTest
    @CsvSource(value = {
            "true, 0, false",
            "true, 1, false"
    })
    public void next_generation_dies_because_of_underpopulation(boolean alive, int nbNeighbours, boolean expected) {
        // Given
        Cell cell = new Cell(alive, nbNeighbours);

        // When
        cell.nextGeneration();

        // Then
        boolean result = cell.isAlive();
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "true, 4, false",
            "true, 5, false",
            "true, 6, false",
            "true, 7, false",
            "true, 8, false",
    })
    public void next_generation_dies_because_of_overpopulation(boolean alive, int nbNeighbours, boolean expected) {
        // Given
        Cell cell = new Cell(alive, nbNeighbours);

        // When
        cell.nextGeneration();

        // Then
        boolean result = cell.isAlive();
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "true, 2, true",
            "true, 3, true"
    })
    public void next_generation_maintains_cell_alive_if_two_or_three_living_neighbors
            (boolean alive, int nbNeighbours, boolean expected) {
        // Given
        Cell cell = new Cell(alive, nbNeighbours);

        // When
        cell.nextGeneration();

        // Then
        boolean result = cell.isAlive();
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "false, 0, false",
            "false, 1, false",
            "false, 2, false"
    })
    public void next_generation_maintains_died_cell_because_of_underpopulation
            (boolean alive, int nbNeighbours, boolean expected) {
        // Given
        Cell cell = new Cell(alive, nbNeighbours);

        // When
        cell.nextGeneration();

        // Then
        boolean result = cell.isAlive();
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "false, 4, false",
            "false, 5, false",
            "false, 6, false",
            "false, 7, false",
            "false, 8, false"
    })
    public void next_generation_maintains_died_cell_because_of_overpopulation
            (boolean alive, int nbNeighbours, boolean expected) {
        // Given
        Cell cell = new Cell(alive, nbNeighbours);

        // When
        cell.nextGeneration();

        // Then
        boolean result = cell.isAlive();
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
