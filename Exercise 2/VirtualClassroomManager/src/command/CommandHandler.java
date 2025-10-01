package command;

import service.*;
import util.LoggerUtil;

public class CommandHandler {
    private final ClassroomService classroomService = new ClassroomService();
    private final StudentService studentService = new StudentService(classroomService);
    private final AssignmentService assignmentService = new AssignmentService(classroomService);

    public void execute(String input) {
        try {
            // Split command into at most 4 parts (for add_student with name)
            String[] parts = input.split(" ", 4);
            String cmd = parts[0];

            switch (cmd) {
                case "add_classroom" -> {
                    if (parts.length < 2) throw new IllegalArgumentException("Missing classroom name.");
                    classroomService.addClassroom(parts[1]);
                }
                case "add_student" -> {
                    if (parts.length < 4) throw new IllegalArgumentException("Usage: add_student <ID> <Name> <ClassName>");
                    String studentId = parts[1];
                    String studentName = parts[2];
                    String className = parts[3];
                    studentService.addStudent(studentId, studentName, className);
                }
                case "schedule_assignment" -> {
                    if (parts.length < 3) throw new IllegalArgumentException("Usage: schedule_assignment <ClassName> <AssignmentDetails>");
                    assignmentService.scheduleAssignment(parts[1], parts[2]);
                }
                case "submit_assignment" -> {
                    if (parts.length < 2) throw new IllegalArgumentException(
                        "Usage: submit_assignment <StudentID>,<ClassName>,<AssignmentDetails>"
                    );
                    String[] args = parts[1].split(",");
                    if (args.length < 3) throw new IllegalArgumentException(
                        "Usage: submit_assignment <StudentID>,<ClassName>,<AssignmentDetails>"
                    );
                    assignmentService.submitAssignment(args[0], args[1], args[2]);
                }
                case "list_classrooms" -> System.out.println("Classrooms: " + classroomService.listClassrooms());
                default -> System.out.println("Unknown command.");
            }
        } catch (Exception e) {
            LoggerUtil.error("Command execution failed: " + e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }
    }
}
