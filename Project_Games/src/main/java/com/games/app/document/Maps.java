package com.games.app.document;


import lombok.NonNull;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Maps   {
    @Id
    String id;
    String title;
    
    public Maps(String title, double lng, double lat) {
		super();
		this.title = title;
		this.lng = lng;
		this.lat = lat;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	double lng;
    double lat;
  
    
    
    
    

 
    
  
}
