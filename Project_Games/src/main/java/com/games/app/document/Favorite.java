package com.games.app.document;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Favorite {
    @Id
    String id;

    @NonNull
    List<Game> games;

    public Favorite() {
        super();
    }

    public Favorite(String id) {
        super();
        this.id = id;
    }

    public Favorite(String id, @NonNull List<Game> games) {
        super();
        this.id = id;
        this.games = games;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
