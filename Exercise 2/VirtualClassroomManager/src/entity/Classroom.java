package entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Classroom {
    private final String name;
    private final Map<String, Student> students = new HashMap<>();
    private final Map<String, String> assignments = new HashMap<>(); // assignment details -> scheduled

    public Classroom(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Classroom name cannot be empty.");
        }
        this.name = name.trim();
    }

    public String getName() { return name; }

    public Map<String, Student> getStudents() { return Collections.unmodifiableMap(students); }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public Map<String, String> getAssignments() { return Collections.unmodifiableMap(assignments); }

    public void addAssignment(String assignmentDetail) {
        assignments.put(assignmentDetail, "Scheduled");
    }
}
