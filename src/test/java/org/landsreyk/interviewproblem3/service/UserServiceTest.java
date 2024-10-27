package org.landsreyk.interviewproblem3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.landsreyk.interviewproblem3.dao.UserRepository;
import org.landsreyk.interviewproblem3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        var user1 = new User(1L, "John", "john@email.com", new HashSet<>());
        var user2 = new User(2L, "Andrew", "andrew@email.com", new HashSet<>());
        var user3 = new User(3L, "Jane", "jane@email.com", new HashSet<>());
        var user4 = new User(4L, "Jack", "jack@email.com", new HashSet<>());
        var user5 = new User(5L, "Albert", "albert@email.com", new HashSet<>());
        var user6 = new User(6L, "Bob", "bob@email.com", new HashSet<>());
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        user1.getFriends().add(user2);
        user2.getFriends().add(user1);
        user2.getFriends().add(user3);
        user3.getFriends().add(user2);
        user3.getFriends().add(user4);
        user4.getFriends().add(user3);
        user4.getFriends().add(user5);
        user5.getFriends().add(user4);
        user5.getFriends().add(user6);
        user6.getFriends().add(user5);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
    }

    @Test
    void testFriendship() {
        userService.createFriendship(1L, 3L);
        var user = userService.findById(1L);
        System.out.println(user);
    }

    @Test
    void testFriendshipSelf() {
        userService.createFriendship(1L, 1L);
        var user = userService.findById(1L);
        System.out.println(user);
    }

    @Test
    void testDeleteFriendship() {
        userService.deleteFriendship(1L, 2L);
        var user1 = userService.findById(1L);
        var user2 = userService.findById(2L);
        System.out.println(user1);
        System.out.println(user2);
    }

    @Test
    void testFindAll() {
        List<User> users = userService.findAll();
        users.forEach(System.out::println);
    }
}