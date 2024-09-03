package hibernateHomework.service;

import hibernateHomework.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Student createStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Override
    @Transactional
    public Student updateStudent(int id, Student student) {
        Student existingStudent = entityManager.find(Student.class, id);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            entityManager.merge(existingStudent);  // Save the updated student entity
            return existingStudent;
        }
        return null;
    }
}
