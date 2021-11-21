package me.labyu.springddd.nosql.domain.feed.repository;

import me.labyu.springddd.nosql.domain.feed.model.FeedPost;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedPostRepository extends MongoRepository<FeedPost, ObjectId> {
}
