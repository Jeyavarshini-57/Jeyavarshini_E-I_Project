package service;

import entity.Classroom;
import entity.Student;
import exception.AppException;
import util.LoggerUtil;

public class StudentService {
    private final ClassroomService classroomService;

    public StudentService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    // Updated to take student name
    public void addStudent(String studentId, String studentName, String className) {
        Classroom classroom = classroomService.getClassroom(className);
        if (classroom.getStudents().containsKey(studentId)) {
            throw new AppException("Student already enrolled: " + studentId);
        }
        Student student = new Student(studentId, studentName);
        classroom.addStudent(student);
        LoggerUtil.info("Student " + studentId + " (" + studentName + ") enrolled in " + className);
        System.out.println("Student " + studentId + " (" + studentName + ") has been enrolled in " + className + ".");
    }
}
