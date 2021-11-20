package me.labyu.springddd.rdbms.domain.user.application.command;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateCommand {
    private String email;
    private String name;
    private String introduction;
}
