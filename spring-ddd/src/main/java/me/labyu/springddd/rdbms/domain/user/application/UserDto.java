package me.labyu.springddd.rdbms.domain.user.application;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDto {
    private final Long id;
    private final String email;
    private final String name;
    private final String introduction;
}
