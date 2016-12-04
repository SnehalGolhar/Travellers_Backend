package com.mkanchwala.country.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mkanchwala.country.dto.UserDTO;
import com.mkanchwala.country.manager.UserManager;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author vtupe
 * date 12:51:50 PM Dec 2, 2016
 */

@Api("Handles Travel related operations")
@RestController
public class UserController {
	
	@Autowired
	UserManager userManager;
	
	@ApiOperation(value = "Operation that returns itinerary daywise")
	 @RequestMapping(value="/user/register", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity userRegistration(@RequestBody UserDTO userDto){
		 
		    userManager.saveUser(userDto);
		 
	        return new ResponseEntity( HttpStatus.OK);
	    }
	 
	 @RequestMapping(value="/get/user", method= RequestMethod.GET)
			// consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity getUser(){
		 
		    //userManager.saveUser(userDto);
		 
	        return new ResponseEntity("hello vaibhav", HttpStatus.OK);
	    }
	

}
