/*
 *  
 * Created on Sep 20, 2016
 *
 */
package com.appdirect.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.appdirect.dto.User;
import com.appdirect.services.LoginService;


/**
 * @author SumeetS
 *
 */
@Controller
@RequestMapping("/user")
public class LoginController extends BaseController{
    
    @Autowired
    LoginService loginService;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@Valid @RequestBody User user) {
	if(loginService.login(user)){
	    return new ResponseEntity<String>("Logged In Successfully",HttpStatus.OK);
	}
	return new ResponseEntity<String>("Log In Failed",HttpStatus.UNAUTHORIZED);
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void logout(HttpServletRequest request, HttpServletResponse response) {
	loginService.logout(request, response);
    }

}
