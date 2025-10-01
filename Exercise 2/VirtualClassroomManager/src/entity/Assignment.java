package entity;

import java.util.*;

public class Assignment {
    private final String details;
    private final Map<String, String> submissions = new HashMap<>();

    public Assignment(String details) {
        if (details == null || details.isBlank()) {
            throw new IllegalArgumentException("Assignment details cannot be empty.");
        }
        this.details = details.trim();
    }

    public String getDetails() { return details; }
    public Map<String, String> getSubmissions() { return Collections.unmodifiableMap(submissions); }

    public void recordSubmission(String studentId) {
        submissions.put(studentId, "Submitted");
    }
}
