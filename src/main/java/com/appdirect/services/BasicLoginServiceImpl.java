/*
 *  
 * Created on Sep 20, 2016
 *
 */
package com.appdirect.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.appdirect.commons.SignInUtils;
import com.appdirect.dto.User;

/**
 * @author SumeetS
 *
 */
@Service
public class BasicLoginServiceImpl implements LoginService{

    /* (non-Javadoc)
     * @see com.appdirect.services.LoginService#login(com.appdirect.dto.User)
     */
    @Override
    public boolean login(User user) {
	if(user.getUserName().equals("admin") && user.getPassWord().equals("123123")){
	    SignInUtils.signon(user);
	    return true;
	}
	return false;
    }

    /* (non-Javadoc)
     * @see com.appdirect.services.LoginService#logout()
     */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
	SignInUtils.signout(request, response);
    }

}
