package me.labyu.springddd.nosql.domain.feed.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Document
public class FeedPost {
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private FeedAuthor author;
}
