/*
 *  
 * Created on Sep 21, 2016
 *
 */
package com.appdirect.services;

import org.springframework.stereotype.Component;

/**
 * @author SumeetS
 *
 */

@Component("stringEventResponse")
public class StringEventResponse implements EventResponse {

    /* (non-Javadoc)
     * @see com.appdirect.services.EventResponse#response(java.lang.String)
     */
    @Override
    public Object response(String response) {
	return response;
    }

}
