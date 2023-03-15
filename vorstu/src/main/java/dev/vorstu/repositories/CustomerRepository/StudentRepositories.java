package dev.vorstu.repositories.CustomerRepository;

import dev.vorstu.dto.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepositories extends CrudRepository<Student, Long> {
}