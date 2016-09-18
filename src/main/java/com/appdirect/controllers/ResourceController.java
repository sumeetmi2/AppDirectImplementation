/*
 * Created on Sep 18, 2016
 */
package com.appdirect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.appdirect.dto.ListWrapper;
import com.appdirect.dto.ResourceObj;
import com.appdirect.services.ResourceService;

/**
 * @author SumeetS
 *
 */

@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController {

    @Autowired
    ResourceService resourceService;

    /**
     * @param ids comma separated
     * @return
     */
    @RequestMapping(value = "/{ids}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable("ids") String ids){
	try{
	    ListWrapper<ResourceObj> listWrapper = new ListWrapper<>(resourceService.get(ids));
	    return new ResponseEntity<ListWrapper<ResourceObj>>(listWrapper,HttpStatus.OK);
	}catch(Exception e){
	    return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
    }

    /**
     * @param ids comma separated to be deleted
     * @return
     */
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("ids") String ids) {
	try{
	    resourceService.delete(ids);
	    return new ResponseEntity<String>("delete successful",HttpStatus.OK);
	}catch(Exception e){
	    return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody ListWrapper<ResourceObj> wrapper) {
	try{
	    resourceService.add(wrapper.getContent());
	    return new ResponseEntity<String>("add successful",HttpStatus.OK);
	}catch(Exception e){
	    return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody ListWrapper<ResourceObj> wrapper) {
	try{
	    resourceService.update(wrapper.getContent());
	    return new ResponseEntity<String>("update successful",HttpStatus.OK);
	}catch(Exception e){
	    return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
    }

}
