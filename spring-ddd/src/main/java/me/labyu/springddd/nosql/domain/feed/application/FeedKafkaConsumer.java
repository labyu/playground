package me.labyu.springddd.nosql.domain.feed.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import me.labyu.springddd.nosql.domain.feed.model.FeedAuthor;
import me.labyu.springddd.nosql.domain.feed.model.FeedPost;
import me.labyu.springddd.nosql.domain.feed.repository.FeedPostRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class FeedKafkaConsumer {
    private final ObjectMapper objectMapper;
    private final FeedPostRepository feedPostRepository;

    @KafkaListener(topics = "FEED_STREAM", groupId = "feed-stream-consumer-1")
    public void consumePost(String message) throws Exception {
        Map<String, Object> messageMap = objectMapper.readValue(message, Map.class);
        Map<String, Object> authorMap = (Map<String, Object>) messageMap.get("AUTHOR");
        FeedPost feedPost = FeedPost.builder()
                .title(messageMap.get("TITLE").toString())
                .description(messageMap.get("DESCRIPTION").toString())
                .createdAt(null)
                .author(
                        FeedAuthor.builder()
                            .id(Long.valueOf(authorMap.get("USER_ID").toString()))
                            .email(authorMap.get("EMAIL").toString())
                            .name(authorMap.get("NAME").toString())
                            .build()
                )
                .build();

        feedPostRepository.save(feedPost);
    }
}
