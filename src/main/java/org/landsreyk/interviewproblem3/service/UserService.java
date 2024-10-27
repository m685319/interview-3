package org.landsreyk.interviewproblem3.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.landsreyk.interviewproblem3.dao.UserRepository;
import org.landsreyk.interviewproblem3.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public void createFriendship(long userId1, long userId2) {
        User user1 = userRepository.findById(userId1).orElseThrow(() -> new RuntimeException("User not found"));
        User user2 = userRepository.findById(userId2).orElseThrow(() -> new RuntimeException("User not found"));
        if (userId1 == userId2) {
            log.error("A user cannot be added as a friend to himself.");
            return;
        }
        if (!user1.getFriends().contains(user2) && !user2.getFriends().contains(user1)) {
            user1.getFriends().add(user2);
            user2.getFriends().add(user1);
        }
        userRepository.save(user1);
        userRepository.save(user2);
    }

    public User findById(long l) {
        return userRepository.findById(l).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteFriendship(long userId1, long userId2) {
        User user1 = userRepository.findById(userId1).orElseThrow(() -> new RuntimeException("User not found"));
        User user2 = userRepository.findById(userId2).orElseThrow(() -> new RuntimeException("User not found"));
        if (userId1 != userId2) {
            user1.getFriends().remove(user2);
            user2.getFriends().remove(user1);
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
