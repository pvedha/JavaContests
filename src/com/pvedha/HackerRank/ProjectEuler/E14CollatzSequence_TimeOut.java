package com.pvedha.HackerRank.ProjectEuler;

import java.io.*;
import java.util.*;

public class E14CollatzSequence_TimeOut {

	static HashMap<Integer, Integer> numberStepsMap = new LinkedHashMap<Integer, Integer>();
	static HashMap<Integer, Integer> largestSequenceMap = new LinkedHashMap<Integer, Integer>();
	static HashMap<Integer, Integer> largestSequenceNumberMap = new LinkedHashMap<Integer, Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();

		numberStepsMap.put(1, 0);
		largestSequenceMap.put(1, 0);
		largestSequenceNumberMap.put(1, 1);
		for (int i = 0; i < cases; i++) {
			Integer number = in.nextInt();
			System.out.println(processCollatzSequence(number));
		}

		System.out.println(numberStepsMap.toString());
		System.out.println(largestSequenceMap.toString());
		System.out.println(largestSequenceNumberMap.toString());
		System.out.println("Processed " + collatzSeq);

	}

	private static Integer processCollatzSequence(Integer number) {
		Integer largestSeqNumber = 0;
		Integer largestSequence = 0;
		Integer input = number;
		while (!largestSequenceMap.containsKey(number)) {
			Integer steps = numberStepsMap.containsKey(number) ? numberStepsMap.get(number)
					: collatzSequenceCount(number);
			if (steps > largestSequence) {
				largestSequence = steps;
				largestSeqNumber = number;
			}
			number--;
		}
		if (largestSequenceMap.get(number) > largestSequence) {
			largestSequence = largestSequenceMap.get(number);
			largestSeqNumber = largestSequenceNumberMap.get(number);
		}
		largestSequenceMap.put(input, largestSequence);
		largestSequenceNumberMap.put(input, largestSeqNumber);
		return largestSeqNumber;
	}

	static Integer collatzSeq = 0;

	private static int collatzSequenceCount(Integer number) {
		ArrayList<Integer> stepsList = new ArrayList<Integer>();
		while (!numberStepsMap.containsKey(number)) {
			stepsList.add(number);
			number = number % 2 == 0 ? number / 2 : 3 * number + 1;
		}
		Integer tmpCount = stepsList.size() + numberStepsMap.get(number);
		for (Integer n : stepsList) {
			numberStepsMap.put(n, tmpCount--);
		}
		return stepsList.size() + numberStepsMap.get(number);
	}
}

// 4484223 largest one under 5000000
