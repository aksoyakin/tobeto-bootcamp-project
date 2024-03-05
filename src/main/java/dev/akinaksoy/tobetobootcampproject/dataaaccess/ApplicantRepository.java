package dev.akinaksoy.tobetobootcampproject.dataaaccess;

import dev.akinaksoy.tobetobootcampproject.entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant,Integer> {
}
