package com.games.app.document;


import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Game   {
    @Id
  
    String id;
    @NonNull
    private String name;
    private String descpt;
    private String tutorial;
    private String imgurl;
    private String caractur;
    

 
    
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getDescpt() {
		return descpt;
	}




	public void setDescpt(String descpt) {
		this.descpt = descpt;
	}




	public String getTutorial() {
		return tutorial;
	}




	public Game(@NonNull String name, String descpt, String tutorial, String imgurl, String caractur) {
		super();
		this.name = name;
		this.descpt = descpt;
		this.tutorial = tutorial;
		this.imgurl = imgurl;
		this.caractur = caractur;
	}




	public void setTutorial(String tutorial) {
		this.tutorial = tutorial;
	}




	public String getImgurl() {
		return imgurl;
	}




	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}




	public String getCaractur() {
		return caractur;
	}




	public void setCaractur(String caractur) {
		this.caractur = caractur;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}
	

  
}
