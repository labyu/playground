package me.labyu.springddd.nosql.domain.feed.model;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@Document(collection = "feedPosts")
public class FeedPost {
    @Id
    private ObjectId objectId;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private FeedAuthor author;

    @Builder
    public FeedPost(String title, String description, LocalDateTime createdAt, FeedAuthor author) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.author = author;
    }
}
