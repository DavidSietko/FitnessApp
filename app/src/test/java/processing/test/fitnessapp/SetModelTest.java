package processing.test.fitnessapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import processing.test.fitnessapp.models.Set;

public class SetModelTest {

    @Test
    public void testGetters() {
        Set set = new Set(100, 5);

        assertEquals(100, set.getWeight(), 0);
        assertEquals(5, set.getReps());
    }

    @Test
    public void testSetters() {
        Set set = new Set(20.5, 5);
        set.setWeight(45);
        set.setReps(5);
        assertEquals(45, set.getWeight(), 0);
        assertEquals(5, set.getReps());
    }

    @Test
    public void testSettersWithNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            Set set = new Set(100, 5);
            set.setWeight(-100);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Set set = new Set(100, 5);
            set.setReps(-5);
        });
    }

    @Test
    public void testNegativeValuesInConstructor() {
        assertThrows(IllegalArgumentException.class, () ->
        {Set set = new Set(-100, 5);});

        assertThrows(IllegalArgumentException.class, () -> {
            Set set = new Set(100, -5);
        });
    }
}
