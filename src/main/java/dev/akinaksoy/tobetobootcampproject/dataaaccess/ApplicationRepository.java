package dev.akinaksoy.tobetobootcampproject.dataaaccess;

import dev.akinaksoy.tobetobootcampproject.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
}
