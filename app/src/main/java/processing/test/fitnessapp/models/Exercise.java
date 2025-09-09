package processing.test.fitnessapp.models;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private final long id;
    private final String name;
    private final int workoutId;
    private final List<Set> set;

    public Exercise(long id, String name, int workoutId) {
        this.id = id;
        this.name = name;
        this.workoutId = workoutId;
        this.set = new ArrayList<>();
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getWorkoutId() {
        return this.workoutId;
    }

    public List<Set> getSets() {
        return this.set;
    }

    public void addSet(Set set) {
        this.set.add(set);
    }
}
