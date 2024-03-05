package dev.akinaksoy.tobetobootcampproject.dataaaccess;

import dev.akinaksoy.tobetobootcampproject.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Integer> {
}
