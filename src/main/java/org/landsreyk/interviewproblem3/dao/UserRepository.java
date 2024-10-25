package org.landsreyk.interviewproblem3.dao;

import org.landsreyk.interviewproblem3.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);

    List<User> findAll();

    void deleteById(Long id);

    User save(User user);
}
