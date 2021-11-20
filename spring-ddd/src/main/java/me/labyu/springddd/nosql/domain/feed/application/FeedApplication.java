package me.labyu.springddd.nosql.domain.feed.application;

import lombok.AllArgsConstructor;
import me.labyu.springddd.nosql.domain.feed.model.Feed;
import me.labyu.springddd.nosql.domain.feed.model.FeedPost;
import me.labyu.springddd.nosql.domain.feed.repository.FeedPostRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedApplication {
    private final FeedPostRepository feedPostRepository;

    public Feed getFeed(Pageable pageable) {
        List<FeedPost> posts = feedPostRepository.findAll();
        return new Feed(posts);
    }
}
