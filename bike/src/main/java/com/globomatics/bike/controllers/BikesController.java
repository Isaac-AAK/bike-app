 package com.globomatics.bike.controllers;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globomatics.bike.models.Bike;
import com.globomatics.bike.repositories.BikeRepository;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {
	@Autowired
	private BikeRepository bikeRepository;
	
	
	@GetMapping // When the /api/v1/bikes receive a request it will forward it to the list HTTP
	public List<Bike> list(){//list of bikes in the models class
		return bikeRepository.findAll();
		
	}
	@PostMapping // Respond to the base url
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Bike bike) {// from create when user submits registration info
		bikeRepository.save(bike);
	}
	
	@GetMapping("/{id}")// add on to the base 
	public Bike get(@PathVariable("id") long id) {// get a specific bike
		return bikeRepository.getOne(id);
	}

}
