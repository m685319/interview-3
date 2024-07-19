package org.landsreyk.interviewproblem3.service;

import lombok.RequiredArgsConstructor;
import org.landsreyk.interviewproblem3.dao.UserRepository;
import org.landsreyk.interviewproblem3.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository inMemoryUserRepository;

    public void save(User user) {
        inMemoryUserRepository.save(user);
    }

    public void createFriendship(Long userId1, Long userId2) {
        User user1 = inMemoryUserRepository.findById(userId1).orElseThrow(() -> new RuntimeException("User not found"));
        User user2 = inMemoryUserRepository.findById(userId2).orElseThrow(() -> new RuntimeException("User not found"));
        if (userId1 != userId2 && !user1.getFriends().contains(user2)) {
            user1.getFriends().add(user2);
            user2.getFriends().add(user1);
        }
    }

    public User findById(long l) {
        return inMemoryUserRepository.findById(l).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteFriendship(Long userId1, Long userId2) {
        // TODO: implement
    }
}
