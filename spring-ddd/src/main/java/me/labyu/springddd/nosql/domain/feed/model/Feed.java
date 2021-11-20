package me.labyu.springddd.nosql.domain.feed.model;

import java.util.List;

public class Feed {
    private final List<FeedPost> posts;

    public Feed(List<FeedPost> posts) {
        this.posts = posts;
    }
}
