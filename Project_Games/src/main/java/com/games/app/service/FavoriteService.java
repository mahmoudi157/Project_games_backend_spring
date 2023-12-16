package com.games.app.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.games.app.document.Favorite;
import com.games.app.document.Game;
import com.games.app.dto.FavoriteDto;
import com.games.app.repository.FavoriteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {
    @Autowired
    FavoriteRepository favoriRepository;
    @Autowired
    GameService gameService;

    public Favorite addFavorite(@NonNull FavoriteDto favoriteDto) {
        String userId = favoriteDto.getIduser();
        Game game = gameService.findByid(favoriteDto.getIdgame());

        Optional<Favorite> existingFavoriteOptional = favoriRepository.findById(userId);

        if (existingFavoriteOptional.isPresent()) {
            Favorite existingFavorite = existingFavoriteOptional.get();
            List<Game> games = existingFavorite.getGames();
            games.add(game);

            existingFavorite.setGames(games);
            return favoriRepository.save(existingFavorite);
        } else {
            List<Game> gamesList = new ArrayList<>();
            gamesList.add(game);

            Favorite newFavorite = new Favorite(userId, gamesList);
            return favoriRepository.insert(newFavorite);
        }
    }

    public Favorite findByid(String id) {
        if (favoriRepository.existsById(id)) {
            return favoriRepository.findById(id).orElseThrow();
        } else {
            return null;
        }
    }

    public List<Game> findmyfavorite(String id) {
        return favoriRepository.findById(id).orElseThrow().getGames();
    }

    public boolean deleteGameFromFavorite(@NonNull FavoriteDto favoriteDto) {
        String userId = favoriteDto.getIduser();
        String gameId = favoriteDto.getIdgame();

        Optional<Favorite> existingFavoriteOptional = favoriRepository.findById(userId);

        if (existingFavoriteOptional.isPresent()) {
            Favorite existingFavorite = existingFavoriteOptional.get();
            List<Game> games = existingFavorite.getGames();

            Game gameToRemove = gameService.findByid(gameId);

            if (gameToRemove != null && games.remove(gameToRemove)) {
                existingFavorite.setGames(games);
                favoriRepository.save(existingFavorite);
                return true;
            }
        }
        return false;
    }
}
