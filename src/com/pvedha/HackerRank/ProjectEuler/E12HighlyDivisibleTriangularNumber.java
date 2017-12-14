package com.pvedha.HackerRank.ProjectEuler;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class E12HighlyDivisibleTriangularNumber {
	
	static HashMap<Integer, Integer> numberToFactorsMap = new LinkedHashMap<Integer,Integer>();
	static HashMap<Integer, Integer> factorsMap = new LinkedHashMap<Integer, Integer>();
	static Integer lastFactors = 1;
	static Integer lastNumber = 1;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		int inputs[] = new int[cases];
		for(int i=0;i<cases;i++){
			inputs[i]=in.nextInt();			
		}
		numberToFactorsMap.put(1, 1);
		factorsMap.put(1, 1);
		lastFactors = 1;
		for(int i=0;i<cases;i++){
			int number = inputs[i];			
			
			while(lastFactors<=number){
				lastNumber++;
				addFactors(lastNumber);				
			}						
			while(!factorsMap.containsKey(number+1)){
				number++;
			}
			Integer result = factorsMap.get(number+1);			
			System.out.println(result);			
		}		
		
		System.out.println(numberToFactorsMap.toString());
		System.out.println(factorsMap.toString());	
		
	}
	
	private static void addFactors(Integer number){
		Integer sum = number * (number + 1) / 2;
		Integer count = 2;
		for(int i=2;i<sum;i++){
			if(sum%i==0){
				count++;
			}
		}
		numberToFactorsMap.put(sum, count);		
		if(count>lastFactors){
			factorsMap.put(count, sum);
			lastFactors = count;
		}
	}
}


/*
 8
1
2
3
4
40
70
90
300
3
6
6
28
5460
25200
73920
2162160
*/
