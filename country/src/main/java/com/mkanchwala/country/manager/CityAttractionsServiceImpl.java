package com.mkanchwala.country.manager;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkanchwala.country.beans.CityAttractionEntity;
import com.mkanchwala.country.beans.CityAttractionsDao;
import com.mkanchwala.country.dto.PlaceRequest;
import com.mkanchwala.country.manager.CityAttractionsService;

@Service
@Transactional
public class CityAttractionsServiceImpl implements CityAttractionsService{

	@Autowired
	CityAttractionsDao cityAttractionsDao;
	/* (non-Javadoc)
	 * @see com.travel.tp.service.CityAttractionsService#findAttractions(com.travel.tp.request.PlaceRequest)
	 */
	@Override
	public Map<String, ArrayList<CityAttractionEntity>> getItinerary(PlaceRequest placeRequest) {
		// TODO Auto-generated method stub
		ArrayList<CityAttractionEntity> list = new ArrayList<CityAttractionEntity>();
		ArrayList<String> categoryList = (ArrayList<String>) placeRequest.getCategoryList();
		int days=(int)placeRequest.getNumberOfDaysToVisit();
		int totalHrs=days*10;
		Map<String, ArrayList<CityAttractionEntity>> map = new HashMap<String, ArrayList<CityAttractionEntity>>();
		ArrayList<CityAttractionEntity> temp =(ArrayList<com.mkanchwala.country.beans.CityAttractionEntity>) cityAttractionsDao.findByCity(placeRequest.getCityName());
		int tempHrs=0;
		int dayhrs=0;
		int currentDay=1;		
		ArrayList<CityAttractionEntity> currentDayList = new ArrayList<CityAttractionEntity>();	
		for(CityAttractionEntity obj :temp)
		{
			System.out.println(obj.getPlaceId());
			if(tempHrs<=totalHrs){
				if(obj.getRating()==4 || obj.getRating()==5){
					list.add(obj);
					tempHrs+=obj.getExplore_hours();
					if(dayhrs+obj.getExplore_hours()<=10){
						System.out.println("high rating adding to day "+currentDay +"  "+obj.getPlaceId());
						currentDayList.add(obj);
						dayhrs+=obj.getExplore_hours();
					   
					}else{
						if(currentDay<=days){
						map.put("Day"+currentDay, currentDayList);
						currentDayList =new ArrayList<CityAttractionEntity>();
						dayhrs=0;
						currentDay+=1;
						currentDayList.add(obj);
						dayhrs+=obj.getExplore_hours();
						}
					}
				}
				if(obj.getRating()==2 || obj.getRating()==3){
					if(list.isEmpty()){
						list.add(obj);
						tempHrs+=obj.getExplore_hours();
						if(dayhrs+obj.getExplore_hours()<=10){
							System.out.println("adding to day "+currentDay +"  "+obj.getPlaceId());
							currentDayList.add(obj);
							dayhrs+=obj.getExplore_hours();
						   
						}else{
							if(currentDay<=days){
							map.put("Day"+currentDay, currentDayList);
							currentDayList =new ArrayList<CityAttractionEntity>();
							dayhrs=0;
							currentDay+=1;
							currentDayList.add(obj);
							dayhrs+=obj.getExplore_hours();
							}
						}
					}
					else{
						
						double srcLat=Double.parseDouble(list.get(list.size()-1).getLattitude());
						double srcLong=Double.parseDouble(list.get(list.size()-1).getLongitude());
						double destLat=Double.parseDouble(obj.getLattitude());
						double destLong=Double.parseDouble(obj.getLongitude());
						double distance=getDistance(srcLat,srcLong,destLat,destLong);
						if(distance<2){
							tempHrs+=obj.getExplore_hours();
							if(dayhrs+obj.getExplore_hours()<=10){
								System.out.println("adding to day "+currentDay +"  "+obj.getPlaceId());
								currentDayList.add(obj);
								dayhrs+=obj.getExplore_hours();
							   
							}else{
								if(currentDay<=days){
								map.put("Day"+currentDay, currentDayList);
								currentDayList =new ArrayList<CityAttractionEntity>();
								dayhrs=0;
								currentDay+=1;
								currentDayList.add(obj);
								dayhrs+=obj.getExplore_hours();
								}
							}
							
						}
						
						System.out.println("Dsitance" +distance);
						//CityAttractionEntity obj1=list.get(list.size()-1);

						       
					}
				}

				if( obj.getRating()==1){
					for(int i=0; i<categoryList.size(); i++){
						//if(obj.getCategory()==categoryList.get(i)){
							if(obj.getCategory().equals(categoryList.get(i))){
							list.add(obj);
							tempHrs+=obj.getExplore_hours();
							if(dayhrs+obj.getExplore_hours()<=10){
								System.out.println("adding to 4 day "+currentDay +"  "+obj.getPlaceId());
								currentDayList.add(obj);
								dayhrs+=obj.getExplore_hours();
							   
							}else{
								if(currentDay<=days){
								map.put("Day"+currentDay, currentDayList);
								currentDayList =new ArrayList<CityAttractionEntity>();
								dayhrs=0;
								currentDay+=1;
								currentDayList.add(obj);
								dayhrs+=obj.getExplore_hours();
								}
							}
						}
					}
				}
				
				

			}
			
			if(currentDay<=days){
			if(!currentDayList.isEmpty()){
				System.out.println("adding to extraaaa day "+currentDay +"  "+obj.getPlaceId());
				map.put("Day"+currentDay, currentDayList);
			}
			}
		}
		
		 return map;
	}

	
	private double getDistance(double srcLat, double srcLong, double destLat, double destLong) {
		// TODO Auto-generated method stub
		
				double theta = srcLong - destLong;
				double dist = Math.sin(deg2rad(srcLat)) * Math.sin(deg2rad(destLat)) + Math.cos(deg2rad(srcLat)) * Math.cos(deg2rad(destLat)) * Math.cos(deg2rad(theta));
				dist = Math.acos(dist);
				dist = rad2deg(dist);
				dist = dist * 60 * 1.1515;
				return (dist);

	}
	
	
	


	private double rad2deg(double dist) {
		return (dist * Math.PI / 180.0);
	}


	private double deg2rad(double srcLat) {
		return (srcLat * 180 / Math.PI);
	}


	@Override
	public ArrayList<CityAttractionEntity> findAttractions(PlaceRequest placeRequest) {
		// TODO Auto-generated method stub
		
		ArrayList<CityAttractionEntity> list = new ArrayList<CityAttractionEntity>();
		
		ArrayList<String> categoryList = (ArrayList<String>) placeRequest.getCategoryList();
		
		for(int i=0; i<categoryList.size(); i++){
		
			ArrayList<CityAttractionEntity> temp =(ArrayList<CityAttractionEntity>) cityAttractionsDao.findByCity(placeRequest.getCityName());
			
			list.addAll(temp);
		}
		return list;
	}

}