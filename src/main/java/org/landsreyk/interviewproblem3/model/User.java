package org.landsreyk.interviewproblem3.model;

import jakarta.persistence.*;
import lombok.*;
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
