package me.labyu.springddd.domain.user.service;

import lombok.AllArgsConstructor;
import me.labyu.springddd.domain.user.model.UserEmail;
import me.labyu.springddd.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean isDuplicateEmail(String email) {
        return userRepository.findUserByEmail(new UserEmail(email)).isPresent();
    }
}
