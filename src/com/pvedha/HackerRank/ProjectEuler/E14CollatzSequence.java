package com.pvedha.HackerRank.ProjectEuler;

import java.io.*;
import java.util.*;

public class E14CollatzSequence {

	static HashMap<Integer, Integer> numberStepsMap = new LinkedHashMap<Integer, Integer>();
	static HashMap<Integer, Integer> largestSequenceNumberMap = new LinkedHashMap<Integer, Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();		
		
		numberStepsMap.put(1, 0);
		largestSequenceNumberMap.put(1, 1);
		for(int i=10000; i<100000; i++){
			collatzSequenceCount(i);
		}
		
		for (int i = 0; i < cases; i++) {
			Integer number = in.nextInt();
			System.out.println(processCollatzSequence(number));
		}

		// System.out.println(numberStepsMap.toString());
		// System.out.println(largestSequenceMap.toString());
		// System.out.println(largestSequenceNumberMap.toString());

	}

	static Integer lastProcessedNumber = 1;
	static Integer lastMaxSteps = 0;
	static Integer lastMaxSequenceNumber = 1;

	private static Integer processCollatzSequence(Integer number) {
		if (number <= lastProcessedNumber) {
			for (Map.Entry<Integer, Integer> item : largestSequenceNumberMap.entrySet()) {
				if (item.getKey() >= number && number >= item.getValue()) {
					return item.getValue();
				}
			}
		}
		for (int i = lastProcessedNumber + 1; i <= number; i++) {
			Integer steps = numberStepsMap.containsKey(i) ? numberStepsMap.get(i) : collatzSequenceCount(i);
			if (lastMaxSteps <= steps) {
				largestSequenceNumberMap.put(i - 1, lastMaxSequenceNumber);
				lastMaxSequenceNumber = i;
				lastMaxSteps = steps;
			}
		}
		lastProcessedNumber = number;
		return lastMaxSequenceNumber;

	}

	private static int collatzSequenceCount(Integer number) {
		//System.out.println(number);
		if (numberStepsMap.containsKey(number)) {
			return numberStepsMap.get(number);
		}
		Integer steps = 1 + collatzSequenceCount(number % 2 == 0 ? number / 2 : 3 * number + 1);
		numberStepsMap.put(number, steps);
		return steps;
	}
}

// 4484223 largest one under 5000000

// 113380 + fails with exception
