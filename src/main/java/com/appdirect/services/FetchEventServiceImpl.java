/*
 * Created on Sep 7, 2016
 */
package com.appdirect.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

/**
 * @author SumeetS
 *
 */
@Service
public class FetchEventServiceImpl implements FetchEventService {
    
    @Autowired
    EventResponse stringEventResponse;

    /*
     * (non-Javadoc)
     * @see com.appdirect.services.FetchEventService#getEvent(java.lang.String)
     */
    @Override
    public Object getEvent(String urlString) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, IOException{
	OAuthConsumer consumer = new DefaultOAuthConsumer("testapp-135859", "VwcW4XHTyJ69");
	URL url = new URL(urlString);
	HttpURLConnection request = (HttpURLConnection) url.openConnection();
	consumer.sign(request);
	request.connect();
	InputStream respone = request.getInputStream();
	String response = IOUtils.toString(respone,"UTF-8");
	respone.close();
	return stringEventResponse.response(response);
    }

}
