package com.games.app.service;

import lombok.NonNull;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.games.app.document.Game;
import com.games.app.dto.GameDto;
import com.games.app.repository.GameRepository;

@Service
public class GameService  {
    @Autowired
    GameRepository gameRepository;
   
    
    
    public Game addGame(@NonNull GameDto dto) {
         Game game=new Game(dto.getName(), dto.getDescpt(), dto.getTutorial(), dto.getImgurl(), dto.getCaractur());
         return gameRepository.insert(game);
               
    }

    public Game findByid(String id) {
    	if(gameRepository.existsById(id)) {
        return gameRepository.findById(id).orElseThrow();
    	}else {
		return null;}
    }
    public List<Game> findAll() {
    	if(gameRepository.count()>0) {
        return gameRepository.findAll();}else {
		return null;}
                
    }
    
    public boolean deletGame(String id) {
    	if(gameRepository.existsById(id)) {
        gameRepository.deleteById(id);
        return true;
    	}else {
		return false;}
    }
}
