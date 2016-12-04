package com.mkanchwala.country.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mkanchwala.country.beans.CityAttractionEntity;
import com.mkanchwala.country.beans.CityAttractionsDao;
import com.mkanchwala.country.dto.PlaceRequest;
import com.mkanchwala.country.manager.CityAttractionsService;

public interface CityAttractionsService{
	
	public Map<String, ArrayList<CityAttractionEntity>> getItinerary(PlaceRequest placeRequest);

	public ArrayList<CityAttractionEntity> findAttractions(PlaceRequest placeRequest);
	
	
}