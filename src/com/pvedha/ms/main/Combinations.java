package com.pvedha.ms.main;

public class Combinations {

	public Combinations() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static void main(String args[]){
		System.out.println(findCombinations(99996L));
	}
	
	 static Long findCombinations(Long count){
	        //long numerator = factorial(count);
	        //long denominator = factorial(count - 2);
	    	System.out.println(count);
	        Long result = ((count * (count -1))/2);
	        System.out.println("result " + result);
	        return result;
	    }

}
