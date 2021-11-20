package me.labyu.springddd.rdbms.domain.post.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.labyu.springddd.rdbms.domain.post.application.PostDto;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "posts")
@NoArgsConstructor
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name="author_user_id")
    private Long authorUserId;

    @Column(nullable = false)
    @Convert(converter = PostTitle.PersistenceConverter.class)
    private PostTitle title;

    @Column(nullable = false)
    @Convert(converter = PostDescription.PersistenceConverter.class)
    private PostDescription description;

    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public Post(Long authorUserId, PostTitle title, PostDescription description) {
        this.authorUserId = authorUserId;
        this.title = title;
        this.description = description;
    }

    public static PostDto toDto(Post post) {
        return PostDto.builder()
                .id(post.id)
                .title(post.title.title)
                .description(post.description.description)
                .build();
    }
}
