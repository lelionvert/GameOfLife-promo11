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
    public void create_a_living_cell()
    {
        boolean alive = true;
        Cell cell = new Cell(alive);

        boolean result = cell.isAlive();

        Assertions.assertThat(result).isTrue();
    }


}
