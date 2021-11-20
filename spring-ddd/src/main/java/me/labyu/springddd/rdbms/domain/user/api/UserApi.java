package me.labyu.springddd.rdbms.domain.user.api;

import lombok.AllArgsConstructor;
import me.labyu.springddd.rdbms.domain.user.application.UserApplication;
import me.labyu.springddd.rdbms.domain.user.application.UserDto;
import me.labyu.springddd.rdbms.domain.user.application.command.UserCreateCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserApi {
    private final UserApplication userApplication;

    @PostMapping("/user")
    public UserDto create(@RequestBody final UserCreateCommand command) {
        return userApplication.create(command);
    }
}
