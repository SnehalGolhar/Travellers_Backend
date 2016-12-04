package com.mkanchwala.country.dto;

import java.util.List;

public class PlaceRequest {
	
	private String cityName;
	private int numberOfDaysToVisit;
	private List<String> categoryList;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getNumberOfDaysToVisit() {
		return numberOfDaysToVisit;
	}
	public void setNumberOfDaysToVisit(int numberOfDaysToVisit) {
		this.numberOfDaysToVisit = numberOfDaysToVisit;
	}
	public List<String> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}
	
	
	

}
