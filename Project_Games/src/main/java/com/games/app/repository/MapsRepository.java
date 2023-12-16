package com.games.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.games.app.document.Favorite;
import com.games.app.document.Game;
import com.games.app.document.Maps;

import java.util.List;

public interface MapsRepository extends MongoRepository<Maps, String> {

   
}
