package me.labyu.springddd.domain.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Convert(converter = UserEmail.PersistenceConverter.class)
    private UserEmail email;

    @Convert(converter = UserName.PersistenceConverter.class)
    private UserName name;

    @Convert(converter = UserIntroduction.PersistenceConverter.class)
    private UserIntroduction introduction;

    @Builder
    public User(String email, String name, String introduction) {
        this.email = new UserEmail(email);
        this.name = new UserName(name);
        this.introduction = new UserIntroduction(introduction);
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.id)
                .email(user.email.email)
                .name(user.name.name)
                .introduction(user.introduction.introduction)
                .build();
    }
}
