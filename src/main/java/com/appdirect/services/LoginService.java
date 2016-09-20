/*
 *  
 * Created on Sep 20, 2016
 *
 */
package com.appdirect.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appdirect.dto.User;

/**
 * @author SumeetS
 *
 */
public interface LoginService {
    public boolean login(User user);
    public void logout(HttpServletRequest request, HttpServletResponse response);
}
