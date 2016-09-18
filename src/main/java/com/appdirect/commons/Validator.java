/*
 *  
 * Created on Sep 18, 2016
 *
 */
package com.appdirect.commons;

import java.util.List;

import org.springframework.stereotype.Component;

import com.appdirect.dto.ResourceObj;

/**
 * @author SumeetS
 *
 */

@Component
public class Validator {
    
    public boolean validateIsNull(String s){
	return !(s!=null && s.length()>0);
    }
    
    public boolean validateResourceObj(ResourceObj obj){
	return (obj!=null && !validateIsNull(obj.getId()));
    }
    
    public boolean validateList(List<ResourceObj> objs){
	return objs!=null && !objs.isEmpty();
    }
}
