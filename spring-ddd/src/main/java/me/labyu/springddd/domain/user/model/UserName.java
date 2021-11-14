package me.labyu.springddd.domain.user.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.annotation.Nonnull;
import javax.persistence.AttributeConverter;

@EqualsAndHashCode
public class UserName {
    final String name;

    public UserName(@Nonnull final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static class PersistenceConverter implements AttributeConverter<UserName, String> {
        @Override
        public String convertToDatabaseColumn(UserName attribute) {
            return attribute == null ? null : attribute.name;
        }

        @Override
        public UserName convertToEntityAttribute(String dbData) {
            return dbData == null ? null : new UserName(dbData);
        }
    }
}
