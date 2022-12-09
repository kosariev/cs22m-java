package kosariev.cs22m.lab1.service;

import kosariev.cs22m.lab1.model.Student;
import kosariev.cs22m.lab1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int student_id) {
        return repository.findById(student_id);
    }

    public Student addStudent(Student student) {
        if (repository.insert(student) > 0) {
            return repository.findById(student.getId());
        }
        return null;
    }

    public Student updateStudentById(Student student) {
        if (repository.update(student) > 0) {
            return repository.findById(student.getId());
        }
        return null;
    }

    public void deleteStudentById(int student_id) {
        repository.deleteById(student_id);
    }
}
