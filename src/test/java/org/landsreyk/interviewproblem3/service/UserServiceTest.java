package org.landsreyk.interviewproblem3.service;

import org.junit.jupiter.api.Test;
import org.landsreyk.interviewproblem3.dao.UserRepository;
import org.landsreyk.interviewproblem3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Sql(scripts = {"classpath:user-data.sql", "classpath:friendship-data.sql"})
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFriendship() {
        userService.createFriendship(1L, 3L);
        var user = userService.findById(1L);
        System.out.println(user);
        assertTrue(user.hasFriend(3L));
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
        assertEquals(30, users.size());
    }
}