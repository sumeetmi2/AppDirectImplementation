/*
 * Created on Sep 7, 2016
 */
package com.appdirect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.signature.QueryStringSigningStrategy;

/**
 * @author SumeetS
 *
 */
@Service
public class FetchEventServiceImpl implements FetchEventService {
    
    @Autowired
    EventResponse eventResponse;

    /*
     * (non-Javadoc)
     * @see com.appdirect.services.FetchEventService#getEvent(java.lang.String)
     */
    @Override
    public EventResponse getEvent(String urlString) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException{
	OAuthConsumer consumer = new DefaultOAuthConsumer("testapp-135859", "hUI0jzPmhMjT1q2r");
	consumer.setSigningStrategy(new QueryStringSigningStrategy());
	String signedUrl = consumer.sign(urlString);
	RestTemplate restTemplate = new RestTemplate();
	return (EventResponse) eventResponse.response((String)(restTemplate.getForEntity(signedUrl, String.class).getBody()));
    }

}
