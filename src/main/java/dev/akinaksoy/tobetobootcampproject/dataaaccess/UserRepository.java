package dev.akinaksoy.tobetobootcampproject.dataaaccess;

import dev.akinaksoy.tobetobootcampproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
