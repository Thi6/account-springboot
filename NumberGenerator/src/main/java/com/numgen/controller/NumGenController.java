package com.numgen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numgen.service.NumGenService;

@RestController
public class NumGenController {
	
	private NumGenService service;
	
	@Autowired
	public NumGenController(NumGenService service) {
		this.service = service;
	}
	
	public NumGenController() {
		
	}
		
 	
//	@GetMapping("/getAccountNum")
//	public String getAccountNum() {
//		
//		return service.generateAccountNum();
//	}
	
	@RequestMapping("/genAccountNum")
	public ResponseEntity<String> genAccountNum() {
		ResponseEntity<String> retVal = new ResponseEntity<String>(service.generateAccountNum(), HttpStatus.OK);
		return retVal;
	}
	
}
