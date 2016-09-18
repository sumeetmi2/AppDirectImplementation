/*
 * Created on Sep 18, 2016
 */
package com.appdirect.services;

import java.util.List;

import com.appdirect.dto.ResourceObj;

/**
 * @author SumeetS
 *
 */
public interface ResourceService {
    public List<ResourceObj> get(String ids) throws Exception;

    public void add(List<ResourceObj> objs) throws Exception;

    public void update(List<ResourceObj> objs) throws Exception;

    public void delete(String ids) throws Exception;
}
