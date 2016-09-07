/*
 *  
 * Created on Sep 7, 2016
 *
 */
package com.appdirect.services;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 * @author SumeetS
 *
 */
@Component
public class JsonEventResponse implements EventResponse{

    /* (non-Javadoc)
     * @see com.appdirect.services.EventResponse#response(java.lang.String)
     */
    @Override
    public JSONObject response(String response) {
	return new JSONObject(response);
    }
    
}
