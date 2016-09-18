/*
 *  
 * Created on Sep 18, 2016
 *
 */
package com.appdirect.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.commons.HashMapHolder;
import com.appdirect.commons.Validator;
import com.appdirect.dto.ResourceObj;
import com.appdirect.exceptions.BadRequestException;

/**
 * @author SumeetS
 *
 */

@Service
public class HashMapDBServiceImpl implements DBService {

    @Autowired
    HashMapHolder hashMapHolder;
    
    @Autowired
    Validator validator;
    
    /* (non-Javadoc)
     * @see com.appdirect.services.DBService#get(java.lang.String)
     */
    @Override
    public List<ResourceObj> get(String ids) {
	List<ResourceObj> result = new ArrayList<>();
	for(String id: ids.split(",")){
	    result.add(hashMapHolder.get(id));
	}
	return new ArrayList<>(result);
    }

    /* (non-Javadoc)
     * @see com.appdirect.services.DBService#add(com.appdirect.dto.ResourceObj)
     */
    @Override
    public void add(List<ResourceObj> objs) throws BadRequestException{
	String id = null;
	for(ResourceObj obj :objs){
	    if(!validator.validateResourceObj(obj)){
		throw new BadRequestException("invalid obj.. add operation success till id : "+ id);
	    }
	    hashMapHolder.add(obj);
	    id = obj.getId();
	}
    }

    /* (non-Javadoc)
     * @see com.appdirect.services.DBService#update(java.lang.String)
     */
    @Override
    public void update(List<ResourceObj> objs) throws BadRequestException{
	String id = null;
	for(ResourceObj obj :objs){
	    if(!validator.validateResourceObj(obj)){
		throw new BadRequestException("invalid obj.. update operation success till id : "+ id);
	    }
	    hashMapHolder.update(obj);
	    id = obj.getId();
	}
    }

    /* (non-Javadoc)
     * @see com.appdirect.services.DBService#delete(java.lang.String)
     */
    @Override
    public void delete(String ids) {
	for(String id: ids.split(",")){
	    hashMapHolder.remove(id);
	}
    }

}
