/*
 *  
 * Created on Sep 18, 2016
 *
 */
package com.appdirect.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author SumeetS
 *
 */
public class ListWrapper<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public ListWrapper(){
	
    }

    private List<T> content;

    public ListWrapper(List<T> content) {
	this.content = content;
    }

    public List<T> getContent() {
	return content;
    }
}
