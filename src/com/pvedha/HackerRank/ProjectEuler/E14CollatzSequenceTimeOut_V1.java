package com.pvedha.HackerRank.ProjectEuler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E14CollatzSequenceTimeOut_V1 {

	static HashMap<Integer, Integer> numberStepsMap = new LinkedHashMap<Integer, Integer>();
	static HashMap<Integer, Integer> largestSequenceMap = new LinkedHashMap<Integer, Integer>();
	static HashMap<Integer, Integer> largestSequenceNumberMap = new LinkedHashMap<Integer, Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();

		numberStepsMap.put(1, 0);
//		numberStepsMap.put(2, 1);
//		numberStepsMap.put(4, 2);
//		numberStepsMap.put(8, 3);
//		numberStepsMap.put(16, 4);
//
		largestSequenceMap.put(1, 0);
		largestSequenceNumberMap.put(1, 1);
//		
//		largestSequenceMap.put(2, 1);
//		largestSequenceNumberMap.put(2, 2);
//		
//		largestSequenceMap.put(4, 2);
//		largestSequenceNumberMap.put(4, 4);
//		
//		largestSequenceMap.put(8, 3);
//		largestSequenceNumberMap.put(8, 8);
//		
//		largestSequenceMap.put(16, 4);
//		largestSequenceNumberMap.put(16, 16);
		
//		for(int i=1;i<10;i++){
//			processCollatzSequence(i);
//		}
//		
		for (int i = 0; i < cases; i++) {
			Integer number = in.nextInt();
			System.out.println(processCollatzSequence(number));
		}
		
		//System.out.println(numberStepsMap.toString());
		//System.out.println(largestSequenceMap.toString());
	    //System.out.println(largestSequenceNumberMap.toString());
		
	}

	
	private static Integer processCollatzSequence(Integer number){
		Integer largestSeqNumber = 0;
		Integer largestSequence = 0;

		Integer input = number;
		
		//HashMap<Integer, Integer> tmplargestSequenceMap = new LinkedHashMap<Integer, Integer>();
		//Integer breakingSeq = 0, breakingNum = 0;
		while (!largestSequenceMap.containsKey(number)) {				
			Integer steps = collatzSequenceCount(number);
			if (steps > largestSequence) {
				largestSequence = steps;
				largestSeqNumber = number;
			//	tmplargestSequenceMap.put(number, steps);				
				//System.out.println("Breaking values : " + number + " " + steps);
			}			
			number--;
		}
		if (largestSequenceMap.get(number) > largestSequence) {
			largestSequence  = largestSequenceMap.get(number);
			largestSeqNumber = largestSequenceNumberMap.get(number);						
		}
		//System.out.println(tmplargestSequenceMap.toString());
		for(int i=input; i>largestSeqNumber;i--){
			largestSequenceMap.put(i, largestSequence);
			largestSequenceNumberMap.put(i, largestSeqNumber);
		}
		//System.out.println(largestSequenceMap.toString());
		//System.out.println(largestSequenceNumberMap.toString());
		return largestSeqNumber;
	}
	
	private static int collatzSequenceCount(Integer number) {
		//Integer in = number;
		//int count = 0;
		ArrayList<Integer> stepsList = new ArrayList<Integer>();
		while (!numberStepsMap.containsKey(number)) {			
			stepsList.add(number);
			//count++;
			number = number % 2 == 0 ? number / 2 : 3 * number + 1;
		}
		//count += numberStepsMap.get(number);
		Integer tmpCount = stepsList.size() + numberStepsMap.get(number);
		for(Integer n : stepsList){
			numberStepsMap.put(n, tmpCount--);
		}		
		return stepsList.size() + numberStepsMap.get(number);
	}

}

//4484223 largest one under 5000000
