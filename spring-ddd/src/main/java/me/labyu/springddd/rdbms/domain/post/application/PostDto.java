package me.labyu.springddd.rdbms.domain.post.application;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostDto {
    private Long id;
    private Long authorUserId;
    private String title;
    private String description;
}
