package me.labyu.springddd.domain.user.api;

import lombok.AllArgsConstructor;
import me.labyu.springddd.domain.user.service.UserApplication;
import me.labyu.springddd.domain.user.model.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/user")
@RestController
public class UserApi {
    private final UserApplication userApplication;

    @PostMapping("")
    public UserDto create(@RequestBody final UserCreateCommand command) {
        return userApplication.create(command);
    }
}
