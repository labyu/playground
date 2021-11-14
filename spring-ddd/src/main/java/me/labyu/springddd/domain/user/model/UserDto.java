package me.labyu.springddd.domain.user.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserDto {
    private final Long id;
    private final String email;
    private final String name;
    private final String introduction;
}
