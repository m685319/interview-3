package org.landsreyk.interviewproblem3.dao.impl;

import org.landsreyk.interviewproblem3.dao.UserRepository;
import org.landsreyk.interviewproblem3.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private Map<Long, User> map = new HashMap<>();

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }

    @Override
    public User save(User user) {
        map.put(user.getId(), user);
        return user;
    }
}
