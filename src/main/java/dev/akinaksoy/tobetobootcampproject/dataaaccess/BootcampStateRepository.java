package dev.akinaksoy.tobetobootcampproject.dataaaccess;

import dev.akinaksoy.tobetobootcampproject.entities.BootcampState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampStateRepository extends JpaRepository<BootcampState,Integer> {
}
