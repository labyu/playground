package me.labyu.springddd.domain.user.api;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateCommand {
    private String email;
    private String name;
    private String introduction;
}
