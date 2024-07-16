package org.landsreyk.interviewproblem3.dao;

import org.landsreyk.interviewproblem3.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserDao {

    Optional<User> findById(Long id);

    Collection<User> findAll();

    void deleteById(Long id);

    void save(User user);
}
