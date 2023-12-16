package com.games.app.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.games.app.document.Game;
import com.games.app.dto.FavoriteDto;
import com.games.app.dto.GameDto;
import com.games.app.service.FavoriteService;
import com.games.app.service.GameService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/game")
@Validated
public class GameControler {

    @Autowired
    private GameService gameService;

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/add")
    public ResponseEntity<?> addGame(@Valid @RequestBody GameDto gameDto) {
        try {
            Game createdGame = gameService.addGame(gameDto);
            return ResponseEntity.ok(createdGame);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add the game. Error: " + e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        try {
            List<Game> games = gameService.findAll();
            return ResponseEntity.ok(games);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve games. Error: " + e.getMessage());
        }
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<?> findByid(@PathVariable String id) {
        try {
            Game game = gameService.findByid(id);
            if (game != null) {
                return ResponseEntity.ok(game);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve the game. Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeletByid(@PathVariable String id) {
        try {
            boolean isDeleted = gameService.deletGame(id);
            if (isDeleted) {
                return ResponseEntity.ok("Game deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete the game. Error: " + e.getMessage());
        }
    }

    @PostMapping("/favorite/add")
    public ResponseEntity<?> addtofavorite(@Valid @RequestBody FavoriteDto favoriteDto) {
        try {
            return ResponseEntity.ok(favoriteService.addFavorite(favoriteDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add to favorites. Error: " + e.getMessage());
        }
    }

    @GetMapping("/favorite/myfavorite/{id}")
    public ResponseEntity<?> getmyfavorite(@PathVariable String id) {
        try {
            return ResponseEntity.ok(favoriteService.findmyfavorite(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve favorites. Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/favorite/delet")
    public ResponseEntity<?> DeletfavoriteByid(@Valid @RequestBody FavoriteDto favoriteDto) {
        try {
            boolean isDeleted = favoriteService.deleteGameFromFavorite(favoriteDto);
            if (isDeleted) {
                return ResponseEntity.ok("Game deleted from favorites successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found in favorites");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete from favorites. Error: " + e.getMessage());
        }
    }
}
