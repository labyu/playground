package me.labyu.springddd.domain.user.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean isDuplicateEmail(String email) {
        return userRepository.findUserByEmail(new UserEmail(email)).isPresent();
    }
}
