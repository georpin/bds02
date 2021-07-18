package com.devsuperior.bds02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.service.CityService;

@Controller
@RequestMapping(value = "/cities")
public class CityController {
	
	@Autowired
	private CityService service;

	@GetMapping
	public ResponseEntity<List<CityDTO>> findAll(){
		
		List<CityDTO> list = service.findAll();
	
		return ResponseEntity.ok().body(list);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CityDTO> deleteById(@PathVariable long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	

	

	
}
