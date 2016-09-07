/*
 *  
 * Created on Sep 7, 2016
 *
 */
package com.appdirect.services;

/**
 * @author SumeetS
 *
 */
public interface FetchEventService {
    
    public EventResponse getEvent(String url) throws Exception;
    
}
