package dev.vorstu.repositories.CustomerRepository;

import dev.vorstu.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByFioContainingIgnoreCase(String fullName, Pageable pageable);
}