package org.landsreyk.interviewproblem3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Pair;

import java.util.Set;

@Entity
@Table(name = "user_table")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> friends;

    public boolean hasFriend(Long friendId) {
        return friends.stream().map(User::getId).anyMatch(friendId::equals);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", friends=" + friends.stream().map(x -> Pair.of(x.getId(), x.getName())).toList() +
                '}';
    }
}
