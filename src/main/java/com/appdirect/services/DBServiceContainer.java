/*
 *  
 * Created on Sep 18, 2016
 *
 */
package com.appdirect.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SumeetS
 *
 */
public class DBServiceContainer {
    private Map<String,DBService> services = new HashMap<>();
    
    public void addService(String id,DBService dbService){
	services.put(id,dbService);
    }
    
    public List<DBService> getAllServices(){
	return new ArrayList<>(services.values());
    }
    
    public DBService getService(String id){
	return services.get(id);
    }
}
	