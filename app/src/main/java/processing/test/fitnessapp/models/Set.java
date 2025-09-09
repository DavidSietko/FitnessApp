package processing.test.fitnessapp.models;

public class Set {
    private double weight;
    private int reps;

    public Set(double weight, int reps) {
        this.weight = weight;
        this.reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public int getReps() {
        return reps;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
