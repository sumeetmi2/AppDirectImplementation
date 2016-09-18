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
public class NoSuchServiceException extends Exception{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public NoSuchServiceException(String s){
	super(s);
    }
}
