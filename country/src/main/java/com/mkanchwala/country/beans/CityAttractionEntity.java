package com.mkanchwala.country.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//import io.swagger.annotations.ApiModel;

//@ApiModel
@Entity
@Table(name="city_attraction")
public class CityAttractionEntity {
	
	@Id
	@GeneratedValue
	@Column(name="place_id")
	private int placeId;
	
	@Column(name="placeName")
	private String placeName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="lattitude")
	private String lattitude;
	
	@Column(name="longitude")
	private String longitude;
	
	@Column(name="rating")
	private int rating;

	@Column(name="category")
	private String category;
	
	@Column(name="description")
	private String description;
	
	@Column(name="explore_hours")
	private int explore_hours;
	
	@Column(name="attractionimage_url")
	private String attractionImageUrl;
	
	
	public int getPlaceId() {
		return placeId;
	}
	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLattitude() {
		return lattitude;
	}
	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longittude) {
		this.longitude = longittude;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getExplore_hours() {
		return explore_hours;
	}
	public void setExplore_hours(int explore_hours) {
		this.explore_hours = explore_hours;
	}
	public String getAttractionImageUrl() {
		return attractionImageUrl;
	}
	public void setAttractionImageUrl(String attractionImageUrl) {
		this.attractionImageUrl = attractionImageUrl;
	}
	

}
