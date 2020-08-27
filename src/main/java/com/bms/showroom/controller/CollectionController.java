package com.bms.showroom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bms.showroom.ShowroomBackendApplication;
import com.bms.showroom.model.data.CollectionRepository;
import com.bms.showroom.model.data.CustomRepository;
import com.bms.showroom.model.entity.Collection;
import com.bms.showroom.model.service.CollectionService;

@RestController
public class CollectionController {

	@Autowired
	private CollectionService service;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(  value="api/collection/{name}", method=RequestMethod.GET)
	public Collection getCollection(@RequestParam(value="name", defaultValue = "")String name){
		
			Collection collection  = service.findByName(name);
		
			if (collection == null) return  new Collection("foo", "bar", false);
			
			return  collection;
					
					
					
		
	}
	
	@GetMapping(value="api/collection")
	public List<Collection> getCollectionList(){
		
		List<Collection> collections = new ArrayList<Collection>(); 
				
		collections =	service.findAll();
		
		if(!collections.isEmpty()) {
			return collections;
		
		}else {
			collections.add(new Collection("one", "desc one ", true));
			
			return collections;
		}
		
	}
}
