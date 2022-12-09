package kosariev.cs22m.lab1;

import kosariev.cs22m.lab1.model.Student;
import kosariev.cs22m.lab1.repository.StudentRepository;
import kosariev.cs22m.lab1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/test")
public class Lab1Controller {

    @Autowired
    private final StudentService studentService;

    @Autowired
    StudentRepository repository;

    public Lab1Controller(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public @ResponseBody List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/student")
    public @ResponseBody Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable(value = "id") int student_id) {
        Student student = studentService.getStudentById(student_id);
        if (student != null) {
            studentService.deleteStudentById(student_id);
            return null;
        }
        return null;
    }

    @GetMapping("/student/{id}")
    public @ResponseBody Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/student/{id}")
    public @ResponseBody Student updateStudentById(@RequestBody Student student) {
        return studentService.updateStudentById(student);
    }
}
