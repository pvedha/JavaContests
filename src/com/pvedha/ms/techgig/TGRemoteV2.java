package com.pvedha.ms.techgig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.pvedha.ms.environment.Timer;
import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class TGRemoteV2 {

	public static Integer TOTAL = 99; // nonsense

	public static void checkPossibilities(Integer level, Integer position) {
		if (level == 1) {
			possibilities += 1;// possibleMoves.get(position).size();
			return;
		}
		for (Integer p : possibleMoves.get(position)) {
			checkPossibilities(level - 1, p);
		}
	}

	public static Integer multiPossibilities(Integer level, Integer position, Integer count) {
		if (level < 3) {
			Integer sum = 0;
			for (Integer p : possibleMoves.get(position)) {
				possibilities = 0;
				checkPossibilities(level-1, p);
				sum += possibilities;
			}
			return count * sum;
		}
		if (level == 3) {			
			return count * levelTotalMap.get(position);
		}
		Integer tmp = 0;
		for (Map.Entry<Integer, Integer> p : levelMap.get(position).entrySet()) {
			tmp += multiPossibilities(level - 2, p.getKey(), count * p.getValue());
		}
		return tmp;
	}

	public static void initPossibilities(Integer level, Integer start, Integer position) {
		if (level == 1) {
			if (levelMap.get(start).containsKey(position)) {
				Integer count = levelMap.get(start).get(position) + 1;
				levelMap.get(start).put(position, count);
				Integer total = levelTotalMap.get(start) + 1;
				levelTotalMap.put(start, total);

			} else {

			}
			return;
		}
		for (Integer p : possibleMoves.get(position)) {
			initPossibilities(level - 1, start, p);
		}
	}

	public static HashMap<Integer, HashMap<Integer, Integer>> levelMap = new LinkedHashMap<Integer, HashMap<Integer, Integer>>();
	public static HashMap<Integer, Integer> levelTotalMap = new LinkedHashMap<>();
	public static Integer possibilities = 0;
	public static HashMap<Integer, ArrayList<Integer>> possibleMoves = new LinkedHashMap<Integer, ArrayList<Integer>>();

	public static void main(String args[]) {
		// stupid way of initializing, but assured :D 0-9 == A-J
		/*
		 * 0 1 2 3 4 5 6 7 8 - 9 -
		 */
		possibleMoves.put(0, new ArrayList<Integer>(Arrays.asList(0, 1, 3)));
		possibleMoves.put(1, new ArrayList<Integer>(Arrays.asList(0, 1, 2, 4)));
		possibleMoves.put(2, new ArrayList<Integer>(Arrays.asList(1, 2, 5)));
		possibleMoves.put(3, new ArrayList<Integer>(Arrays.asList(0, 3, 4, 6)));
		possibleMoves.put(4, new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5, 7)));
		possibleMoves.put(5, new ArrayList<Integer>(Arrays.asList(2, 4, 5, 8)));
		possibleMoves.put(6, new ArrayList<Integer>(Arrays.asList(3, 6, 7)));
		possibleMoves.put(7, new ArrayList<Integer>(Arrays.asList(4, 6, 7, 8, 9)));
		possibleMoves.put(8, new ArrayList<Integer>(Arrays.asList(5, 7, 8)));
		possibleMoves.put(9, new ArrayList<Integer>(Arrays.asList(7, 9)));

		Timer t = new Timer();

		Scanner in = new Scanner(System.in);
		int level = in.nextInt();
		if (level == 1) {
			System.out.println(10);
			return;
		} else if (level < 1) {
			System.out.println(0);
			return;
		}

		for (int i = 0; i < 10; i++) {
			HashMap<Integer, Integer> endsCountMap = new LinkedHashMap<Integer, Integer>();
			for (int j = 0; j < 10; j++) {
				endsCountMap.put(j, 0);
			}
			levelTotalMap.put(i, 0);
			levelMap.put(i, endsCountMap);
		}

		for (int i = 0; i < 10; i++) {
			initPossibilities(3, i, i);
		}

		possibilities = 0;
		for (int j = 2; j < 16; j++) {
			level = j;
			Integer sum = 0;
			for (int i = 0; i < 10; i++) {
				Integer tmp = multiPossibilities(level, i, 1);
				sum += tmp;
			}
			System.out.println(j + " - " + sum);
		}
		t.elapsedTime();
		// System.out.println(possibilities);
	}

	public static void sop(String msg) {
		System.out.println(msg);
	}

	public TGRemoteV2() {
		// TODO Auto-generated constructor stub
	}

}
