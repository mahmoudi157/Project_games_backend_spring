package com.games.app.dto;


import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class FavoriteDto   {
   
  
    
    @NonNull
    private String iduser;
    private String idgame;
	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	public String getIdgame() {
		return idgame;
	}
	public void setIdgame(String idgame) {
		this.idgame = idgame;
	}
    
 
    
	


	

  
}
