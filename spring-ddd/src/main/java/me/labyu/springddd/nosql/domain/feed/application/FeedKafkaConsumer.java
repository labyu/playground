package me.labyu.springddd.nosql.domain.feed.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import me.labyu.springddd.nosql.domain.feed.model.FeedPost;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class FeedKafkaConsumer {

    private final ObjectMapper objectMapper;

//    @KafkaListener(topics = "cdc-mysql.springddd.posts", groupId = "feed-consumer-posts")
//    public void consumePost(String message) throws Exception {
//    }
}
