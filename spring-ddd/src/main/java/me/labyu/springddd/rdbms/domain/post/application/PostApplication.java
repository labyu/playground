package me.labyu.springddd.rdbms.domain.post.application;

import lombok.AllArgsConstructor;
import me.labyu.springddd.rdbms.domain.post.application.command.PostCreateCommand;
import me.labyu.springddd.rdbms.domain.post.model.Post;
import me.labyu.springddd.rdbms.domain.post.model.PostDescription;
import me.labyu.springddd.rdbms.domain.post.model.PostTitle;
import me.labyu.springddd.rdbms.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostApplication {
    private final PostRepository postRepository;

    public PostDto create(PostCreateCommand command, Long authorUserId) {
        Post post = Post.builder()
            .authorUserId(authorUserId)
            .title(new PostTitle(command.getTitle()))
            .description(new PostDescription(command.getDescription()))
            .build();

        return Post.toDto(postRepository.save(post));
    }
}
