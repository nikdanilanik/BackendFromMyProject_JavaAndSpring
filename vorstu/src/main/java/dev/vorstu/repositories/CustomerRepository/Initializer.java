package dev.vorstu.repositories.CustomerRepository;

import dev.vorstu.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {
    @Autowired
    private StudentRepositories studentRepository;
    public void initial() {
        studentRepository.save(new Student("fio", "def_group", "+79"));
        studentRepository.save(new Student("fio1", "def_group1", "+791"));
        studentRepository.save(new Student("fio2", "def_group2", "+792"));
    }

}
