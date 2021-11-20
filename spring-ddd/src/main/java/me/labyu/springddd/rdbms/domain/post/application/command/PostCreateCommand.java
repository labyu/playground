package me.labyu.springddd.rdbms.domain.post.application.command;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateCommand {
    private String title;
    private String description;
}
