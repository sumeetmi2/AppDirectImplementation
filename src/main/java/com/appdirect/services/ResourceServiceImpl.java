/*
 *  
 * Created on Sep 18, 2016
 *
 */
package com.appdirect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.appdirect.commons.Validator;
import com.appdirect.dto.ResourceObj;
import com.appdirect.exceptions.BadRequestException;
import com.appdirect.exceptions.NoSuchServiceException;

/**
 * @author SumeetS
 *
 */
@Service
public class ResourceServiceImpl implements ResourceService{
    
    @Autowired
    DBServiceContainer dBServiceContainer;
    
    @Autowired
    Environment environment;
    
    @Autowired
    Validator validator;
    
    /* (non-Javadoc)
     * @see com.appdirect.services.ResourceService#get(java.lang.String)
     * 
     * fetch from a particular predefined resource so if there are multiple type of dbs select the type of db from which to do fetch operation .... behaviour can be modified
     * to fetch from across different type of dbs by changing below 
     */
    @Override
    public List<ResourceObj> get(String ids) throws BadRequestException,NoSuchServiceException {
	DBService service = dBServiceContainer.getService(environment.getRequiredProperty("get.resources.from"));
	if(service == null){
	    throw new NoSuchServiceException("undefined service in the configuration for fetching resource:"+environment.getRequiredProperty("get.resources.from"));
	}
	if(!validator.validateIsNull(ids)){
	    return service.get(ids);
	}else{
	    throw new BadRequestException("Invalid request: ids cannot be null");
	}
    }

    /* (non-Javadoc)
     * @see com.appdirect.services.ResourceService#add(com.appdirect.dto.ResourceObj)
     * add new resourec to all databases
     */
    @Override
    public void add(List<ResourceObj> objs) throws Exception{
	if(!validator.validateList(objs)){
	    throw new BadRequestException("resource object is malformed: list cannot be null");
	}
	for(DBService dbservice: dBServiceContainer.getAllServices()){
	    dbservice.add(objs);
	}
    }

    /* (non-Javadoc)
     * @see com.appdirect.services.ResourceService#update(java.lang.String)
     */
    @Override
    public void update(List<ResourceObj> objs) throws Exception {
	if(!validator.validateList(objs)){
	    throw new BadRequestException("resource object is malformed: list cannot be null");
	}
	for(DBService dbservice: dBServiceContainer.getAllServices()){
	    dbservice.update((objs));
	}
    }

    /* (non-Javadoc)
     * @see com.appdirect.services.ResourceService#delete(java.lang.String)
     */
    @Override
    public void delete(String ids) throws BadRequestException{
	if(validator.validateIsNull(ids)){
	    throw new BadRequestException("Invalid request: ids cannot be null");
	}
	for(DBService dbservice: dBServiceContainer.getAllServices()){
	    dbservice.delete(ids);
	}
    }

}
