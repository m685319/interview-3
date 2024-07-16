package org.landsreyk.interviewproblem3.dao.impl;

import org.landsreyk.interviewproblem3.dao.UserDao;
import org.landsreyk.interviewproblem3.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private Map<Long, User> repo;

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(repo.get(id));
    }

    @Override
    public Collection<User> findAll() {
        return repo.values();
    }

    @Override
    public void deleteById(Long id) {
        repo.remove(id);
    }

    @Override
    public void save(User user) {
        repo.put(user.getId(), user);
    }
}
