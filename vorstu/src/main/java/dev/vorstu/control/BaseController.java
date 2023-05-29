package dev.vorstu.control;

import dev.vorstu.entity.Student;
import dev.vorstu.repositories.CustomerRepository.Initializer;
import dev.vorstu.repositories.CustomerRepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/base")

public class BaseController {

    private Long counter = 0L;
    private Long generateId() { return counter++; }

    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    @GetMapping("students")
    public Page<Student> getAllStudent(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort,
            @RequestParam(defaultValue = "") String filter) {
        Sort.Direction direction = Sort.Direction.fromString(sort[1]);
        Pageable pageable = PageRequest.of(page, size, direction, sort[0]);
        if (filter != null && !filter.trim().isEmpty()) {
            return studentRepository.findByFioContainingIgnoreCase(filter, pageable);
        } else {
            return studentRepository.findAll(pageable);
        }
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Autowired
    private Initializer initializer;

    // Add student
    @PostMapping(value = "students/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Student newStudent) { return addStudent(newStudent);}
    private Student addStudent(Student student) {
        student.setId(generateId());
        return initializer.SaveStudent(student);
    }

    // Remove student by id
    @DeleteMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long deleteStudent(@PathVariable("id") Long id) {
        return removeStudent(id);
    }
    private Long removeStudent(Long id) {
        studentRepository.deleteById(id);
        return id;
    }

    @GetMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentbyId(@PathVariable("id") Long id) {
        return getAllStudents().stream()
                .filter(el -> el.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("student with id: " + id + " was not found"));
    }

    @PutMapping(value = "students/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student changeStudent(@RequestBody Student changingStudent) {
        return updateStudent(changingStudent);
    }

    private Student updateStudent(Student student) {
        if(student.getId() == null) {
            throw new RuntimeException("id of changing student cannot be null");
        }

        Student changingStudent = getAllStudents().stream()
                .filter(el -> Objects.equals(el.getId(), student.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("student with id: " + student.getId() + "was not found"));

        changingStudent.setFio(student.getFio());
        changingStudent.setGroup(student.getGroup());
        changingStudent.setPhoneNumber(student.getPhoneNumber());
        return studentRepository.save(changingStudent);
    }

//    @GetMapping(value = "students/filter", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Student getStudentbyId(@RequestParam(value = "group") String group) {
//        return getAllStudents().stream()
//                .filter(el -> el.getGroup().equals(group))
//                .findFirst()
//                .orElse(null);
//    }
}
