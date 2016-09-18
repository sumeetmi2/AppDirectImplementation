/*
 *  
 * Created on Sep 18, 2016
 *
 */
package com.appdirect.commons;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.appdirect.dto.ResourceObj;

/**
 * @author SumeetS
 *
 */
@Component
public class HashMapHolder {
    private ConcurrentHashMap<String, ResourceObj> MAP = new ConcurrentHashMap<>();
    
    public void add(ResourceObj obj){
	MAP.putIfAbsent(obj.getId(), obj);
    }
    
    public ResourceObj get(String id){
	return MAP.get(id);
    }
    
    public void remove(String id){
	MAP.remove(id);
    }
    
    public void update(ResourceObj obj){
	MAP.replace(obj.getId(), obj);
    }
}
