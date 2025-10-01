package service;

import entity.Classroom;
import entity.Student;
import exception.AppException;
import util.LoggerUtil;

import java.util.List;
import java.util.stream.Collectors;

public class AssignmentService {
    private final ClassroomService classroomService;

    public AssignmentService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    public void scheduleAssignment(String className, String assignmentDetail) {
        Classroom classroom = classroomService.getClassroom(className);
        classroom.addAssignment(assignmentDetail);
        LoggerUtil.info("Assignment for " + className + " has been scheduled.");
        System.out.println("Assignment for " + className + " has been scheduled.");
    }

    public void submitAssignment(String studentId, String className, String assignmentDetail) {
        Classroom classroom = classroomService.getClassroom(className);
        Student student = classroom.getStudents().get(studentId);
        if (student == null) throw new AppException("Student " + studentId + " not found in " + className);
        student.submitAssignment(assignmentDetail);
        LoggerUtil.info("Assignment submitted by Student " + studentId + " in " + className);
        System.out.println("Assignment submitted by Student " + studentId + " in " + className);
    }

    // New: Show all assignments in a classroom
    public void showAssignments(String className) {
        Classroom classroom = classroomService.getClassroom(className);
        if (classroom.getAssignments().isEmpty()) {
            System.out.println("No assignments scheduled in " + className);
        } else {
            System.out.println("Assignments in " + className + ":");
            classroom.getAssignments().keySet().forEach(a -> System.out.println(" - " + a));
        }
    }

    // New: Show students who submitted assignments in a classroom
    public void showSubmittedStudents(String className) {
        Classroom classroom = classroomService.getClassroom(className);
        if (classroom.getAssignments().isEmpty()) {
            System.out.println("No assignments scheduled in " + className);
            return;
        }

        classroom.getAssignments().keySet().forEach(assignment -> {
            List<Student> submittedStudents = classroom.getStudents().values().stream()
                    .filter(s -> s.getSubmissions().containsKey(assignment))
                    .collect(Collectors.toList());
            System.out.println("Assignment: " + assignment);
            if (submittedStudents.isEmpty()) {
                System.out.println("  No students have submitted yet.");
            } else {
                submittedStudents.forEach(s -> System.out.println("  - " + s.getId() + " (" + s.getName() + ")"));
            }
        });
    }
}
