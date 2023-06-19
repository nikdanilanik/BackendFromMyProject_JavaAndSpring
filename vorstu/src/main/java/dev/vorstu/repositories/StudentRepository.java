package dev.vorstu.repositories;

import dev.vorstu.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    final Map<Long, Student> students = null;
    Page<Student> findByFioContainingIgnoreCase(String fullName, Pageable pageable);
    Student findByFio(String fullName);
}