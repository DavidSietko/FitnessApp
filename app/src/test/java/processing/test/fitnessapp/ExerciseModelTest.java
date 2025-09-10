package processing.test.fitnessapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import processing.test.fitnessapp.models.Exercise;
import processing.test.fitnessapp.models.Set;

public class ExerciseModelTest {

    @Test
    public void testExerciseCreation() {
        Exercise exercise = new Exercise(1, "Bench Press", 1);
        assertEquals(1, exercise.getId());
        assertEquals("Bench Press", exercise.getName());
        assertEquals(1, exercise.getWorkoutId());
    }

    @Test
    public void testExerciseCreationWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            Exercise exercise = new Exercise(1, "", 1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Exercise exercise = new Exercise(1, "  ", 1);
        });
    }

    @Test
    public void testGetters() {
        Exercise exercise = new Exercise(1, "Bench Press", 1);
        assertEquals(1, exercise.getId());
        assertEquals("Bench Press", exercise.getName());
        assertEquals(1, exercise.getWorkoutId());
    }

    @Test
    public void testSetAdding() {
        Exercise exercise = new Exercise(1, "Bench Press", 1);
        Set set = new Set(100, 5);
        exercise.addSet(set);
        assertEquals(1, exercise.getSets().size());
        assertTrue(set.equals(exercise.getSets().get(0)));
    }

    @Test
    public void TestSetDeletion() {
        Exercise exercise = new Exercise(1, "Bench Press", 1);
        Set set = new Set(100, 5);
        exercise.addSet(set);
        exercise.removeSet(0);
        assertEquals(0, exercise.getSets().size());
    }

    @Test
    public void TestSetDeletionInvalidIndex() {
        Exercise exercise = new Exercise(1, "Bench Press", 1);
        Set set = new Set(100, 5);
        exercise.addSet(set);
        assertThrows(IllegalArgumentException.class, () -> {
            exercise.removeSet(1);
        });
    }
}
