package org.landsreyk.interviewproblem3.dao.impl;

import org.landsreyk.interviewproblem3.dao.UserRepository;
import org.landsreyk.interviewproblem3.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Primary
public interface DatabaseUserRepository extends UserRepository, JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    List<User> findAll();

    void deleteById(Long id);

    User save(User user);
}
