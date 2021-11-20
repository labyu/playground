package me.labyu.springddd.rdbms.domain.post.repository;

import me.labyu.springddd.rdbms.domain.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
