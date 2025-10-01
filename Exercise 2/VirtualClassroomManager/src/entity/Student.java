package entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private final String id;
    private final String name; // new
    private final Map<String, String> submissions = new HashMap<>();

    public Student(String id, String name) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Student ID cannot be empty.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        this.id = id.trim();
        this.name = name.trim();
    }

    public String getId() { return id; }
    public String getName() { return name; } // getter
    public Map<String, String> getSubmissions() { return Collections.unmodifiableMap(submissions); }

    public void submitAssignment(String assignmentDetail) {
        submissions.put(assignmentDetail, "Submitted");
    }

    @Override
    public String toString() {
        return id + " (" + name + ")";
    }
}
