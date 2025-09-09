package processing.test.fitnessapp.models;

import java.time.LocalDate;
import java.util.Date;

public class Workout {
    private long id;
    private long templateId;
    private LocalDate date;

    public Workout(long id, long templateId, LocalDate date) {
        this.id = id;
        this.templateId = templateId;
        this.date = date;
    }
    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public long getTemplateId() { return templateId; }
    public void setTemplateId(long templateId) { this.templateId = templateId; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
