/*
 *  
 * Created on Sep 18, 2016
 *
 */
package com.appdirect.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appdirect.dto.ResourceObj;

/**
 * @author SumeetS
 *
 */
@Service
public class MySQLDBServiceImpl implements DBService{

    /* (non-Javadoc)
     * @see com.appdirect.services.DBService#get(java.lang.String)
     */
    @Override
    public List<ResourceObj> get(String ids) {
	// TODO Auto-generated method stub
	return null;
    }

    /* (non-Javadoc)
     * @see com.appdirect.services.DBService#add(java.util.List)
     */
    @Override
    public void add(List<ResourceObj> objs) {
	// TODO Auto-generated method stub
	
    }

    /* (non-Javadoc)
     * @see com.appdirect.services.DBService#update(java.util.List)
     */
    @Override
    public void update(List<ResourceObj> objs) {
	// TODO Auto-generated method stub
	
    }

    /* (non-Javadoc)
     * @see com.appdirect.services.DBService#delete(java.lang.String)
     */
    @Override
    public void delete(String ids) {
	// TODO Auto-generated method stub
	
    }
    
    
}
