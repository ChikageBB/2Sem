package ru.itis.inf403.db;

import ru.itis.inf403.db.db.DBUtils;
import ru.itis.inf403.db.model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        student.setName("Artem");
        student.setLastName("Kuzmin");
        student.setFatherName("Ruslanovich");
        student.setGroup("11-403");
        student.setId(14);

        DBUtils.appendObject(student);


        DBUtils.readAll().forEach(students -> {
            System.out.println(students.getFatherName() + " " + students.getName());
        }
        );

    }
}
