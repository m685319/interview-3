package org.landsreyk.interviewproblem3.service;

import lombok.RequiredArgsConstructor;
import org.landsreyk.interviewproblem3.dao.UserDao;
import org.landsreyk.interviewproblem3.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public void createFriendship(Long userId1, Long userId2) {
        User user1 = userDao.findById(userId1).orElseThrow(() -> new RuntimeException("User not found"));
        User user2 = userDao.findById(userId2).orElseThrow(() -> new RuntimeException("User not found"));
        if (!user1.equals(user2) && !user1.getFriends().contains(user2)) {
            user1.getFriends().add(user2);
            user2.getFriends().add(user1);
        }
    }

    public User findById(long l) {
        return userDao.findById(l).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
