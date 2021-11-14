package me.labyu.springddd.domain.user.service;

import lombok.AllArgsConstructor;
import me.labyu.springddd.domain.user.api.UserCreateCommand;
import me.labyu.springddd.domain.user.model.User;
import me.labyu.springddd.domain.user.model.UserDto;
import me.labyu.springddd.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserApplication {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserDto create(UserCreateCommand command) {
        if (userService.isDuplicateEmail(command.getEmail())) {
            throw new RuntimeException("중복된 이메일입니다");
        }

        User user = User.builder()
                .email(command.getEmail())
                .name(command.getName())
                .introduction(command.getIntroduction())
                .build();

        return User.toDto(userRepository.save(user));
    }
}
