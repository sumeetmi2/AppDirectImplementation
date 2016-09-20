/*
 *  
 * Created on Sep 20, 2016
 *
 */
package com.appdirect.commons;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.appdirect.dto.User;

/**
 * @author SumeetS
 *
 */
public class SignInUtils {

    public static void signout(HttpServletRequest request, HttpServletResponse response) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth != null) {
	    new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	SecurityContextHolder.getContext().setAuthentication(null);
    }

    public static void signon(User user) {
	Set<GrantedAuthority> setAuthsPemisssions = new HashSet<>();

	SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, user.getPassword(),setAuthsPemisssions));
    }
}
