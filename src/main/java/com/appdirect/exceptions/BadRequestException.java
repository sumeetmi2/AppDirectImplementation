/*
 *  
 * Created on Sep 18, 2016
 *
 */
package com.appdirect.exceptions;

/**
 * @author SumeetS
 *
 */
public class BadRequestException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 
     */
    public BadRequestException(String message) {
	super(message);
    }

}
