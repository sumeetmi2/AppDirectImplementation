/*
 *  
 * Created on Sep 18, 2016
 *
 */
package com.appdirect.dto;

import java.io.Serializable;

/**
 * @author SumeetS
 *
 */
public class ResourceObj implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public ResourceObj(){
	
    }
    
    private String id;
    private String value;
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }
    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    
    
    
}
