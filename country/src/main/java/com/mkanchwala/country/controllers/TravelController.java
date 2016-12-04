package com.mkanchwala.country.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mkanchwala.country.beans.CityAttractionEntity;
import com.mkanchwala.country.beans.CityAttractionsDao;
import com.mkanchwala.country.dto.PlaceRequest;
import com.mkanchwala.country.manager.CityAttractionsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@CrossOrigin
@RestController
@Api("Handles Travel related operations")
public class TravelController{
	
	@Autowired
	CityAttractionsService cityAttractionService;
	
	
	@RequestMapping(value="/get-attractions/", method = RequestMethod.POST)
	@ApiOperation(value = "Operation that returns attractions in given place")
	public ResponseEntity<List<CityAttractionEntity>> register(@RequestBody PlaceRequest placeRequest){
		
		List<CityAttractionEntity> list = cityAttractionService.findAttractions(placeRequest);
		
		return new ResponseEntity( list,HttpStatus.OK);
	}
	
	@RequestMapping(value="/get-itinerary/", method = RequestMethod.POST)
	@ApiOperation(value = "Operation that returns itinerary daywise")
	
	public ResponseEntity<Map<String, ArrayList<CityAttractionEntity>>> getItineraryData(@RequestBody PlaceRequest placeRequest){
		Map<String, ArrayList<CityAttractionEntity>> map = cityAttractionService.getItinerary(placeRequest);		
		return new ResponseEntity<Map<String, ArrayList<CityAttractionEntity>>>(map,HttpStatus.OK);
	}
		
	
	
}