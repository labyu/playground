package me.labyu.springddd.nosql.domain.feed.api;

import lombok.AllArgsConstructor;
import me.labyu.springddd.nosql.domain.feed.application.FeedApplication;
import me.labyu.springddd.nosql.domain.feed.model.Feed;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class FeedApi {
    private final FeedApplication feedApplication;

    @GetMapping("/feed")
    public Feed getFeed() {
        return feedApplication.getFeed(Pageable.ofSize(10));
    }
}
