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
    /**
     * Rigorous Test :-)
     */
    @Test
    public void a_cell_should_be_alive()
    {
        Cell cell = new Cell();

        boolean result = cell.isAlive();

        Assertions.assertThat(result).isTrue();
    }
}
