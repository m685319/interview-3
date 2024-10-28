package org.landsreyk.interviewproblem3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Table(name = "user_table")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    // Множество друзей пользователя
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "friendship", // имя таблицы связи
            joinColumns = @JoinColumn(name = "user_1"), // первичный ключ пользователя
            inverseJoinColumns = @JoinColumn(name = "user_2") // первичный ключ друга
    )
    private Set<User> friends;

    public boolean hasFriend(long friendId) {
        return friends.stream().map(User::getId).anyMatch(x -> friendId == x);
    }
}
