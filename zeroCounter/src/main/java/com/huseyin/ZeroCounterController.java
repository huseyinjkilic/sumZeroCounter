package com.huseyin;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class ZeroCounterController {

    @RequestMapping("/")
    public String index() {
    	
		int [] arrayNumbers = {3, -2, 0, 1 , 0,  4, 7, 0, -3, -2, -8};
		return Integer.toString(calculateCountOfPair(arrayNumbers));
    }
    
    @RequestMapping(value="/data/{arrayValues}", method = RequestMethod.GET)
    public @ResponseBody String getParameter(@PathVariable("arrayValues") String arrayValues) {
    	String[] arayValuesFromRest = arrayValues.split(",");
    	int[] integerValueOfArray = new int[arayValuesFromRest.length]; 
    	
    	for(int i = 0; i <arayValuesFromRest.length; i++ ) {
    		integerValueOfArray[i] = Integer.parseInt(arayValuesFromRest[i]);
    	}
    	
    	return Integer.toString(calculateCountOfPair(integerValueOfArray));
    	
    }
    
    public int calculateCountOfPair(int[] numbers) {
		Arrays.sort(numbers);
		
		int countOfEqualNumber = 0;
		int currentNegativeNumber = 0;
		int currentPositiveNumber = numbers.length - 1;
		
		while(currentNegativeNumber != currentPositiveNumber) {
			
			if(numbers[currentNegativeNumber] + numbers[currentPositiveNumber] != 0 ) {
				if((numbers[currentNegativeNumber] <= 0)  && (numbers[currentPositiveNumber] >= 0) )  {
					if(Math.abs(numbers[currentNegativeNumber]) > numbers[currentPositiveNumber]) {
						currentNegativeNumber++;
					} else if(Math.abs(numbers[currentNegativeNumber]) < numbers[currentPositiveNumber]) {
						currentPositiveNumber--;
					}
				} else {
					break;
				}
			} else {
				countOfEqualNumber++;
				
				// This is for middle values. If we don't check this value for middle. 
				// It might be swap for equal number and double count.
				if(Math.abs(currentNegativeNumber - currentPositiveNumber) == 1) {
					break;
				}
				currentNegativeNumber++;
				currentPositiveNumber--;
			}
		}
        return countOfEqualNumber;
    }
}
