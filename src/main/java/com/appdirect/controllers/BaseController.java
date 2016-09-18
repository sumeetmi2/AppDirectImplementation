/*
 *  
 * Created on Sep 5, 2016
 *
 */
package com.appdirect.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.appdirect.commons.CustomMessageSource;
import com.appdirect.dto.ResponseWrapperObject;

/**
 * @author SumeetS
 *
 */
public class BaseController {


    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    protected CustomMessageSource customMessageSource;

    protected ResponseEntity<ResponseWrapperObject> sendSuccessResponse(ResponseWrapperObject responseObj, HttpStatus httpStatus) {
	return new ResponseEntity<ResponseWrapperObject>(responseObj, httpStatus);
    }

    protected ResponseEntity<ResponseWrapperObject> sendErrorResponse(ResponseWrapperObject responseObj, HttpStatus httpStatus) {
	return new ResponseEntity<ResponseWrapperObject>(responseObj, httpStatus);
    }
    
}
