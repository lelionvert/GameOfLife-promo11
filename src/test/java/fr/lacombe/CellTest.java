package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit test for simple App.
 */
public class CellTest {
    @Test

    public void isAlive_is_alive_if_a_cell_is_alive() {
        Cell cell = new Cell(State.ALIVE);

        State result = cell.isAlive();

        Assertions.assertThat(result).isEqualTo(State.ALIVE);
    }

    @Test
    public void isAlive_is_dead_if_a_cell_is_dead() {
        Cell cell = new Cell(State.DEAD);

        State result = cell.isAlive();

        Assertions.assertThat(result).isEqualTo(State.DEAD);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "ALIVE, 0, DEAD",
            "ALIVE, 1, DEAD"
    })
    public void next_generation_dies_because_of_underpopulation(State alive, int nbNeighbours, State expected) {
        // Given
        Cell cell = new Cell(alive, nbNeighbours);

        // When
        cell.nextGeneration();

        // Then
        State result = cell.willBeAlive();
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "ALIVE, 4, DEAD",
            "ALIVE, 5, DEAD",
            "ALIVE, 6, DEAD",
            "ALIVE, 7, DEAD",
            "ALIVE, 8, DEAD",
    })
    public void next_generation_dies_because_of_overpopulation(State alive, int nbNeighbours, State expected) {
        // Given
        Cell cell = new Cell(alive, nbNeighbours);

        // When
        cell.nextGeneration();

        // Then
        State result = cell.willBeAlive();
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "ALIVE, 2, ALIVE",
            "ALIVE, 3, ALIVE"
    })
    public void next_generation_maintains_cell_alive_if_two_or_three_living_neighbors
            (State alive, int nbNeighbours, State expected) {
        // Given
        Cell cell = new Cell(alive, nbNeighbours);

        // When
        cell.nextGeneration();

        // Then
        State result = cell.willBeAlive();
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "DEAD, 0, DEAD",
            "DEAD, 1, DEAD",
            "DEAD, 2, DEAD"
    })
    public void next_generation_maintains_died_cell_because_of_underpopulation
            (State alive, int nbNeighbours, State expected) {
        // Given
        Cell cell = new Cell(alive, nbNeighbours);

        // When
        cell.nextGeneration();

        // Then
        State result = cell.willBeAlive();
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void next_generation_give_birth_to_cell_if_three_neighbours() {
        // Given
        Cell cell = new Cell(State.DEAD, 3);

        // When
        cell.nextGeneration();

        // Then
        State result = cell.willBeAlive();
        Assertions.assertThat(result).isEqualTo(State.ALIVE);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "DEAD, 4, DEAD",
            "DEAD, 5, DEAD",
            "DEAD, 6, DEAD",
            "DEAD, 7, DEAD",
            "DEAD, 8, DEAD"
    })
    public void next_generation_maintains_died_cell_because_of_overpopulation(State alive, int nbNeighbours, State expected) {
        // Given
        Cell cell = new Cell(alive, nbNeighbours);

        // When
        cell.nextGeneration();

        // Then
        State result = cell.willBeAlive();
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @Ignore("WIP")
    public void neighborhood_between_two_cells() {
        Cell cellLeft = new Cell(State.ALIVE);
        Cell cellRight = new Cell(State.ALIVE);
        cellLeft.addNeighbor(cellRight);

        boolean result = cellLeft.isNeighborOf(cellRight);

        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @Ignore("WIP")
    public void not_neighborhood_between_two_cells() {
        Cell cellLeft = new Cell(State.ALIVE);
        Cell cellRight = new Cell(State.ALIVE);

        boolean result = cellLeft.isNeighborOf(cellRight);

        Assertions.assertThat(result).isEqualTo(false);
    }
}
