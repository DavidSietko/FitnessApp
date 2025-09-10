package processing.test.fitnessapp.models;

public class Set {
    private double weight;
    private int reps;

    public Set(double weight, int reps) {
        if(weight < 0 || reps < 0) {
            throw new IllegalArgumentException("Weight or reps cannot be negative");
        }
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
        if(weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        this.weight = weight;
    }

    public void setReps(int reps) {
        if(reps < 0) {
            throw new IllegalArgumentException("Reps cannot be negative");
        }
        this.reps = reps;
    }

    public boolean equals(Set set) {
        return this.getWeight() == set.getWeight() && this.getReps() == set.getReps();
    }
}
