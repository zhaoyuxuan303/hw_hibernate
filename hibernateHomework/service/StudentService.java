package hibernateHomework.service;

import hibernateHomework.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student createStudent(Student student);
    void deleteStudent(int id);  // Method to delete a student by ID
    Student updateStudent(int id, Student student);  // Method to update a student by ID
}
