package com.mkanchwala.country.beans;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mkanchwala.country.beans.CityAttractionEntity;
import com.mkanchwala.country.beans.CityAttractionsDao;


public interface CityAttractionsDao extends CrudRepository<CityAttractionEntity, Long>{
	
	//public List<CityAttractionEntity> findBy
	
	public List<CityAttractionEntity> findByCity(String city);
	
}