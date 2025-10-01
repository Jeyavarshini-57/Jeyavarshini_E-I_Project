package service;

import entity.Classroom;
import exception.AppException;
import util.LoggerUtil;

import java.util.*;

public class ClassroomService {
    private final Map<String, Classroom> classrooms = new HashMap<>();

    public void addClassroom(String name) {
        if (classrooms.containsKey(name)) {
            throw new AppException("Classroom already exists: " + name);
        }
        classrooms.put(name, new Classroom(name));
        LoggerUtil.info("Classroom " + name + " has been created.");
        System.out.println("Classroom " + name + " has been created.");
    }

    public Classroom getClassroom(String name) {
        Classroom classroom = classrooms.get(name);
        if (classroom == null) {
            throw new AppException("Classroom not found: " + name);
        }
        return classroom;
    }

    public List<String> listClassrooms() {
        return new ArrayList<>(classrooms.keySet());
    }
}
