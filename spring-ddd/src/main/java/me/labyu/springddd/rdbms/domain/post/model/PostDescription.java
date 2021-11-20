package me.labyu.springddd.rdbms.domain.post.model;

import lombok.EqualsAndHashCode;

import javax.annotation.Nonnull;
import javax.persistence.AttributeConverter;

@EqualsAndHashCode
public class PostDescription {
    final String description;

    public PostDescription(@Nonnull final String description) {
        this.description = validate(description);
    }

    private String validate(@Nonnull final String description) {
        return description;
    }

    public static class PersistenceConverter implements AttributeConverter<PostDescription, String> {
        @Override
        public String convertToDatabaseColumn(PostDescription attribute) {
            return attribute.description;
        }

        @Override
        public PostDescription convertToEntityAttribute(String dbData) {
            return new PostDescription(dbData);
        }
    }
}
