package dev.vorstu.control;

import dev.vorstu.dto.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/base")

public class BaseController {

    private Long counter = 0L;
    private Long generateId() { return counter++; }
    private final List<Student> students = new ArrayList<>();

    @PostConstruct
    private void init() {
        students.add(new Student(0L, "User1", "VM", "+7"));
        students.add(new Student(1L, "User2", "VM", "+8"));
        students .add(new Student(2L, "User3", "AM", "+9"));
    }

    @PostMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Student newStudent) { return addStudent(newStudent);}

    private Student addStudent(Student student) {
        student.setId(generateId());
        students.add(student);
        return student;
    }

    @PutMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student changeStudent(@RequestBody Student changingStudent) {
        return updateStudent(changingStudent);
    }

    private Student updateStudent(Student student) {
        if(student.getId() == null) {
            throw new RuntimeException("id of changing student cannot be null");
        }

        Student changingStudent = students.stream()
                .filter(el -> Objects.equals(el.getId(), student.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("student with id: " + student.getId() + "was not found"));

        changingStudent.setFio(student.getFio());
        changingStudent.setGroup(student.getGroup());
        changingStudent.setPhoneNumber(student.getPhoneNumber());
        return student;
    }

    @DeleteMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long deleteStudent(@PathVariable("id") Long id) {
        return removeStudent(id);
    }

    private Long removeStudent(Long id) {
        students.removeIf(el -> el.getId().equals(id));
        return id;
    }

    @GetMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentbyId(@PathVariable("id") Long id) {
        return students.stream()
                .filter(el -> el.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("student with id: " + id + " was not found"));
    }
    @GetMapping(value = "students/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentbyId(@RequestParam(value = "group") String group) {
        return students.stream()
                .filter(el -> el.getGroup().equals(group))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("students")
    public List<Student> getAllStudents() {
        return students;
    }
}
