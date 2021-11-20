package me.labyu.springddd.rdbms.domain.user.model;

import lombok.EqualsAndHashCode;

import javax.annotation.Nonnull;
import javax.persistence.AttributeConverter;

@EqualsAndHashCode
public class UserEmail {
    final String email;

    public UserEmail(@Nonnull final String email) {
        this.email = validate(email);
    }

    private String validate(@Nonnull final String email) {
        if (email.length() < 10) {
            throw new IllegalArgumentException("이메일은 10자 이상이어야 합니다");
        }

        return email;
    }

    @Override
    public String toString() {
        return email;
    }

    public static class PersistenceConverter implements AttributeConverter<UserEmail, String> {
        @Override
        public String convertToDatabaseColumn(UserEmail attribute) {
            return attribute == null ? null : attribute.email;
        }

        @Override
        public UserEmail convertToEntityAttribute(String dbData) {
            return dbData == null ? null : new UserEmail(dbData);
        }
    }
}
