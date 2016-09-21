/*
 *  
 * Created on Sep 7, 2016
 *
 */
package com.appdirect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.appdirect.dto.ResponseWrapperObject;
import com.appdirect.services.FetchEventService;

/**
 * @author SumeetS
 *
 */

@Controller
@RequestMapping("/subscribe")
public class SubscriptionController extends BaseController{
    
    
    @Autowired
    FetchEventService fetchEventService;
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ResponseEntity<?> create(@RequestParam(value="url",required=false) String eventUrl) {
	System.out.println(eventUrl);
	ResponseWrapperObject response = new ResponseWrapperObject();
	response.setSuccess("true");
	response.setAccountIdentifier("sumeet");
	try {
	    System.out.println(fetchEventService.getEvent(eventUrl).toString());
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return sendSuccessResponse(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    public ResponseEntity<?> cancel(@RequestParam(value="url",required=false) String eventUrl) {
	System.out.println(eventUrl);
	ResponseWrapperObject response = new ResponseWrapperObject();
	response.setSuccess("true");
	response.setAccountIdentifier("sumeet");
	try {
	    System.out.println(fetchEventService.getEvent(eventUrl).toString());
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return sendSuccessResponse(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public ResponseEntity<?> change(@RequestParam(value="url",required=false) String eventUrl) {
	System.out.println(eventUrl);
	ResponseWrapperObject response = new ResponseWrapperObject();
	response.setSuccess("true");
	response.setAccountIdentifier("sumeet");
	try {
	    System.out.println(fetchEventService.getEvent(eventUrl).toString());
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return sendSuccessResponse(response, HttpStatus.OK);
    }

}
