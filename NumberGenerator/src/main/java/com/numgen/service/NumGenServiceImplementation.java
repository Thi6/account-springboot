package com.numgen.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class NumGenServiceImplementation implements NumGenService{
	
	public NumGenServiceImplementation() {
		
	}
	
	
	public String generateAccountNum() {
		Random random = new Random();
		String accNum = "";
		
		
		
		String possibleLetters = "abc";
		char letter = possibleLetters.charAt(random.nextInt(possibleLetters.length()));
		accNum += letter;
		
		int randomNum = random.nextInt(900000) + 100000;
		accNum += randomNum;
		
		System.out.println(accNum);
		
		return accNum;
 		
	}

}
