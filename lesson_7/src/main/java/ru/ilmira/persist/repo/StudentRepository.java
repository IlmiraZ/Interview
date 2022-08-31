package ru.ilmira.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ilmira.persist.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
}
