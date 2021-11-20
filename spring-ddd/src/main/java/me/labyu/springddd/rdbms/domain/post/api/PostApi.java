package me.labyu.springddd.rdbms.domain.post.api;

import lombok.AllArgsConstructor;
import me.labyu.springddd.rdbms.domain.post.application.PostApplication;
import me.labyu.springddd.rdbms.domain.post.application.PostDto;
import me.labyu.springddd.rdbms.domain.post.application.command.PostCreateCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostApi {
    private final PostApplication postApplication;

    @PostMapping("/post")
    public PostDto create(@RequestBody final PostCreateCommand command, @RequestParam Long authorUserId) {
        return postApplication.create(command, authorUserId);
    }
}
