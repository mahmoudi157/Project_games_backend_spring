package com.games.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.games.app.document.Game;

import java.util.List;

public interface GameRepository extends MongoRepository<Game, String> {
   
}
