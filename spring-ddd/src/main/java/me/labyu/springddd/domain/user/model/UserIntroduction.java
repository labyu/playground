package me.labyu.springddd.domain.user.model;

import javax.annotation.Nonnull;
import javax.persistence.AttributeConverter;

public class UserIntroduction {
    final String introduction;

    public UserIntroduction(@Nonnull String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return introduction;
    }

    public static class PersistenceConverter implements AttributeConverter<UserIntroduction, String> {
        @Override
        public String convertToDatabaseColumn(UserIntroduction attribute) {
            return attribute == null ? null : attribute.introduction;
        }

        @Override
        public UserIntroduction convertToEntityAttribute(String dbData) {
            return dbData == null ? null : new UserIntroduction(dbData);
        }
    }
}
