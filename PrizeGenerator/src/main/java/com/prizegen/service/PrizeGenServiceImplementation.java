package com.prizegen.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class PrizeGenServiceImplementation implements PrizeGenService{

	
	public String generatePrize() {
		   Random rand5 = new Random();
           int value = rand5.nextInt(10);
           if (value < 5 ) {
               return "You have won £50";
           }
           if (value == 5 ) {
               return "You have won £100";
           } else {
               return "Sorry you have not won";
       }
		
	}

    
//    public String generatePrize(String accountNum) {
//        char firstLetter = accountNum.charAt(0);
//        int length = accountNum.length() - 1;
//        String prize="";
//        
//        switch(length) {
//        case 6:
//            
//            if (firstLetter == 'a') {
//                prize = "Nothing";
//            } else if (firstLetter == 'b') {
//                prize = "£50";
//            } else {
//                prize = "£100";
//            }
//            break;
//            
//        case 8:
//            
//            if (firstLetter == 'a') {
//                prize = "Nothing";
//            } else if (firstLetter == 'b') {
//                prize = "£500";
//            } else {
//                prize = "£750";
//            }
//            break;
//            
//        case 10:
//        	
//            if (firstLetter == 'a') {
//                prize = "Nothing";
//            } else if (firstLetter == 'b') {
//                prize = "£5,000";
//            } else {
//                prize = "£10,000";
//            }
//            break;      
//            
//        }
//        
//        return prize;
//        
//    }

    
}
