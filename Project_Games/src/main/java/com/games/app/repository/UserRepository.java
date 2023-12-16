package com.games.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.games.app.document.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
