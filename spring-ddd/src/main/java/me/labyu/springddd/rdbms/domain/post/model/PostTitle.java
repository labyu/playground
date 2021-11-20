package me.labyu.springddd.rdbms.domain.post.model;

import lombok.EqualsAndHashCode;

import javax.annotation.Nonnull;
import javax.persistence.AttributeConverter;

@EqualsAndHashCode
public class PostTitle {
    final String title;

    public PostTitle(@Nonnull final String title) {
        this.title = title;
    }

    private String validate(@Nonnull final String title) {
        if (title.length() < 10) {
            throw new IllegalArgumentException("제목은 10자 이상이어야 합니다");
        }

        return title;
    }

    @Override
    public String toString() {
        return title;
    }

    public static class PersistenceConverter implements AttributeConverter<PostTitle, String> {
        @Override
        public String convertToDatabaseColumn(PostTitle attribute) {
            return attribute.title;
        }

        @Override
        public PostTitle convertToEntityAttribute(String dbData) {
            return new PostTitle(dbData);
        }
    }
}
