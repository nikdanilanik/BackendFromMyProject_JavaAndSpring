package dev.vorstu.repositories.CustomerRepository;

import dev.vorstu.entity.Password;
import dev.vorstu.entity.Role;
import dev.vorstu.entity.Student;
import dev.vorstu.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
@Slf4j
public class Initializer {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;
    public void initial() {
        studentRepository.save(new Student("fio1", "def_group1", "+791"));
        studentRepository.save(new Student("fio2", "def_group2", "+792"));
        studentRepository.save(new Student("fio3", "def_group3", "+793"));
        studentRepository.save(new Student("fio4", "def_group4", "+794"));
        studentRepository.save(new Student("fio5", "def_group5", "+795"));
        studentRepository.save(new Student("fio6", "def_group6", "+796"));

        User student = new User (
                null,
                "student",
                Role.STUDENT,
                new Password("1234"),
                true
        );
        userRepository.save(student);

        String encoding =           Base64.getEncoder().encodeToString((student.getUsername() + ":" + student.getPassword()).getBytes());
        String encode   = java.util.Base64.getEncoder().encodeToString((student.getUsername() + ":" + student.getPassword()).getBytes());
        log.info(encoding);
    }
    public Student SaveStudent(Student student) {
        return studentRepository.save(student);
    }
}
