package org.landsreyk.interviewproblem3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "friendship")
@Getter
@Setter
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_1", nullable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user_2", nullable = false)
    private User user2;

}
