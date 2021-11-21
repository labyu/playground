package me.labyu.springddd.nosql.domain.feed.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FeedAuthor {
    private Long id;
    private String email;
    private String name;
    private String intorudction;
}
