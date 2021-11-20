package me.labyu.springddd.rdbms.domain.user.repository;

import me.labyu.springddd.rdbms.domain.user.model.User;
import me.labyu.springddd.rdbms.domain.user.model.UserEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(UserEmail email);
}
