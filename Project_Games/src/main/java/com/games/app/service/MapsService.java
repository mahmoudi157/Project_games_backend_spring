package com.games.app.service;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.games.app.document.Favorite;
import com.games.app.document.Game;
import com.games.app.document.Maps;
import com.games.app.dto.FavoriteDto;
import com.games.app.repository.FavoriteRepository;
import com.games.app.repository.MapsRepository;

@Service
public class MapsService  {
    @Autowired
    MapsRepository repository;
    
   
    
    
    public Maps addmaps(Maps maps) {
         
         return repository.save(new Maps(maps.getTitle(), maps.getLng(), maps.getLat()));}
		 
               
    

    public  Maps  findByid(String id) {
    	
        	
			return repository.findById(id).orElseThrow();
        	
                
    }
    
    public boolean deletmaps(String id) {
    	 
        repository.deleteById(id);
		return true;     
          
    		   
}
    
    public  List<Maps>  getallmaps() {
    	
    	
		return repository.findAll();
    	
            
} 
    
    
    
    
    
    }
