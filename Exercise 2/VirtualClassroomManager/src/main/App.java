package main;

import service.*;
import util.LoggerUtil;
import exception.AppException;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        LoggerUtil.info("Starting Virtual Classroom Manager...");

        ClassroomService classroomService = new ClassroomService();
        StudentService studentService = new StudentService(classroomService);
        AssignmentService assignmentService = new AssignmentService(classroomService);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n========= Virtual Classroom Manager =========");
            System.out.println("1. Add Classroom");
            System.out.println("2. Add Student to a Classroom");
            System.out.println("3. Schedule Assignment");
            System.out.println("4. Submit Assignment");
            System.out.println("5. Show all Students in a Classroom");
            System.out.println("6. List Classrooms");
            System.out.println("7. Show all Assignments in a Classroom");
            System.out.println("8. Show Assignment Submissions in a Classroom");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Enter classroom name: ");
                        String cname = scanner.nextLine().trim();
                        classroomService.addClassroom(cname);
                    }
                    case "2" -> {
                    System.out.print("Enter classroom name: ");
                    String cname = scanner.nextLine().trim();
                    System.out.print("Enter student ID: ");
                    String sid = scanner.nextLine().trim();
                    System.out.print("Enter student name: ");  // new
                    String sname = scanner.nextLine().trim();
                    studentService.addStudent(sid, sname, cname);
                    }

                    case "3" -> {
                        System.out.print("Enter classroom name: ");
                        String cname = scanner.nextLine().trim();
                        System.out.print("Enter assignment details: ");
                        String details = scanner.nextLine().trim();
                        assignmentService.scheduleAssignment(cname, details);
                    }
                    case "4" -> {
                        System.out.print("Enter student ID: ");
                        String sid = scanner.nextLine().trim();
                        System.out.print("Enter classroom name: ");
                        String cname = scanner.nextLine().trim();
                        System.out.print("Enter assignment details: ");
                        String details = scanner.nextLine().trim();
                        assignmentService.submitAssignment(sid, cname, details);
                    }
                    case "5" -> {
                        System.out.print("Enter classroom name: ");
                        String cname = scanner.nextLine().trim();
                        var classroom = classroomService.getClassroom(cname);
                        if (classroom.getStudents().isEmpty()) {
                            System.out.println("No students enrolled in " + cname);
                        } else {
                            System.out.println("Students in " + cname + ":");
                            classroom.getStudents().values().forEach(s -> 
                                System.out.println(" - " + s.getId() + " (" + s.getName() + ")")
                            );
                        }
                    }

                    case "6" -> {
                        System.out.println("Classrooms: " + classroomService.listClassrooms());
                    }
                    case "7" -> {
                        System.out.print("Enter classroom name: ");
                        String cname = scanner.nextLine().trim();
                        assignmentService.showAssignments(cname);
                    }

                    case "8" -> {
                        System.out.print("Enter classroom name: ");
                        String cname = scanner.nextLine().trim();
                        assignmentService.showSubmittedStudents(cname);
                    }

                    case "9" -> {
                        running = false;
                        LoggerUtil.info("User requested exit.");
                        System.out.println("Exiting Virtual Classroom Manager...");
                    }
                    default -> System.out.println("Invalid choice. Please enter 1-7.");
                }
            } catch (AppException e) {
                LoggerUtil.error("Business error: " + e.getMessage());
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                LoggerUtil.error("Unexpected error: " + e.getMessage());
                System.out.println("An unexpected error occurred. Please try again.");
            }
        }


        LoggerUtil.info("Application stopped.");
        scanner.close();
    }
}
