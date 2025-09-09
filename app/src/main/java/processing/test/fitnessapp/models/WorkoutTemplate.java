package processing.test.fitnessapp.models;

import java.util.List;
import java.util.ArrayList;

public class WorkoutTemplate {
    private long id;
    private String name;
    private List<String> exerciseNames; // Will be stored as a JSON array string

    public WorkoutTemplate(String name) {
        this.name = name;
        this.exerciseNames = new ArrayList<>();
    }

    public WorkoutTemplate(long id, String name) {
        this.id = id;
        this.name = name;
        this.exerciseNames = new ArrayList<>();
    }

    public void addExerciseName(String exerciseName) {
        if (exerciseName != null && !exerciseName.trim().isEmpty() && !this.exerciseNames.contains(exerciseName.trim())) {
            this.exerciseNames.add(exerciseName.trim());
        }
    }

    public void removeExerciseName(String exerciseName) {
        this.exerciseNames.remove(exerciseName);
    }

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<String> getExerciseNames() { return exerciseNames; }
    public void setExerciseNames(List<String> exerciseNames) { this.exerciseNames = exerciseNames; }
}
