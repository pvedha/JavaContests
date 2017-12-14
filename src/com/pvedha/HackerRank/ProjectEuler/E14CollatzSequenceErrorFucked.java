package com.pvedha.HackerRank.ProjectEuler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E14CollatzSequenceErrorFucked {

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
		//System.out.println("Collatz called " + collatzCount);
		
	}

	static HashMap<Integer, Integer> tmplargestSequenceMap = new LinkedHashMap<Integer, Integer>();
	private static Integer processCollatzSequence(Integer number){
		Integer largestSeqNumber = 0;
		Integer largestSequence = 0;
		for(Map.Entry<Integer, Integer> item : tmplargestSequenceMap.entrySet()){
			if(item.getKey() >= number && item.getValue() <=number){
				return item.getValue();
			}
		}
		Integer input = number;		
		//Integer breakingSeq = 0, breakingNum = 0;
		Integer start = number;
		Integer currentLargestSequence = 0;
		HashMap<Integer, Integer> collatzMap = new LinkedHashMap<Integer, Integer>();
		ArrayList<Integer> tmpList = new ArrayList<Integer>();
		while (!largestSequenceMap.containsKey(number)) {				
			Integer steps = collatzSequenceCount(number);
			collatzMap.put(number, steps);
			tmpList.add(0,steps);
			if (steps > largestSequence) {
				largestSequence = steps;
				//System.out.println("Breaking values : " + number + " " + steps);
				largestSeqNumber = number;
				tmplargestSequenceMap.put(input, number);
				start = number -1;
				collatzMap.clear();
				tmpList.clear();
				
			}		
			//if(steps > currentLargestSequence){
				//tmplargestSequenceMap.put(start, number);
				//currentLargestSequence = 0;
			//}
			
			number--;
		}
		
		if (largestSequenceMap.get(number) > largestSequence) {
			largestSequence  = largestSequenceMap.get(number);
			largestSeqNumber = largestSequenceNumberMap.get(number);						
		}
		
		//System.err.println(collatzMap.toString());
		//for(int i=input; i>largestSeqNumber;i--){
			largestSequenceMap.put(input, largestSequence);
			largestSequenceNumberMap.put(input, largestSeqNumber);
		//}
		
			//System.out.println("Final Number = " + number);
		//Integer tmp =largestSeqNumber-1;
			Integer lastItem = Integer.MIN_VALUE;
			Integer lastNumber = 1;
			Integer lastBig = Integer.MAX_VALUE;
			//System.out.println("TmpList " + tmpList.toString());
			ArrayList<Integer> order = new ArrayList<Integer>();
			for(int i=0;i<tmpList.size();i++){
				if(tmpList.get(i) < lastItem){
					//tmplargestSequenceMap.put(i+1, lastNumber+1);
					
					//lastNumber = i+1;					
				}else{
					order.add(i+1+number);
					lastItem = tmpList.get(i);
				}
				//lastItem = tmpList.get(i);
			}
			for(int i=1;i<order.size();i++){
				tmplargestSequenceMap.put(order.get(i)-1,order.get(i-1));
			}
			tmplargestSequenceMap.put(largestSeqNumber-1, order.get(order.size()-1));
			//System.out.println("Order" + order.toString());
			//System.out.println(tmplargestSequenceMap.toString());
			//System.out.println(largestSequenceMap.toString());
		//System.out.println(largestSequenceNumberMap.toString());
		//tmplargestSequenceMap.put(input, largestSeqNumber);	
		return largestSeqNumber;
	}
	static Integer collatzCount = 0;
	private static int collatzSequenceCount(Integer number) {
		Integer in = number;
		int count = 0;
		collatzCount++;
		//ArrayList<Integer> stepsList = new ArrayList<Integer>();
		while (!numberStepsMap.containsKey(number)) {			
			//stepsList.add(number);
			count++;
			number = number % 2 == 0 ? number / 2 : 3 * number + 1;
		}
		count += numberStepsMap.get(number);
		//Integer tmpCount = stepsList.size() + numberStepsMap.get(number);
		//for(Integer n : stepsList){
			numberStepsMap.put(in, count);
		//}		
		return count;
	}

}

//4484223 largest one under 5000000
