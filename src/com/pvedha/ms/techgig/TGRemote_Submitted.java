package com.pvedha.ms.techgig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import sun.security.provider.MD5;

public class TGRemote_Submitted {

    /* Techgig interface is very bad. 
    * From problem statement explanation, examples, interface, compilation, everything BAD!
    *
    * Should be using Long or BigInteger, as N > 40 etc needs a huge value. 
    * But wait, return value itself is int, isnt that a clue??
    * - PVedha
    */
    
	
	public static int combinationCounts(int input1)
    {
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

		int level = input1;
		if (level == 1) {
			return 10;
		} else if (level < 1) {
			return 0;
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
			initPossibilities(INIT_LEVEL, i, i);
		}

		Integer sum = 0;
		for (int i = 0; i < 10; i++) {
			Integer tmp = multiPossibilities(level, i, 1);
			sum += tmp;
		}
    
        return sum;
        
    }
    
    
    
    
    public static void checkPossibilities(Integer level, Integer position) {
		if (level == 1) {
			possibilities += 1;
			return;
		}
		for (Integer p : possibleMoves.get(position)) {
			checkPossibilities(level - 1, p);
		}
	}

	public static Integer multiPossibilities(Integer level, Integer position, Integer count) {
		if (level < INIT_LEVEL) {
			Integer sum = 0;
			for (Integer p : possibleMoves.get(position)) {
				possibilities = 0;
				checkPossibilities(level - 1, p);
				sum += possibilities;
			}
			return count * sum;
		}
		if (level == INIT_LEVEL) {
			return count * levelTotalMap.get(position);
		}
		Integer tmp = 0;
		for (Map.Entry<Integer, Integer> p : levelMap.get(position).entrySet()) {
			tmp += multiPossibilities(level - INIT_LEVEL + 1, p.getKey(), count * p.getValue());
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
	public static Integer INIT_LEVEL = 6;

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int output = 0;
        int ip1 = Integer.parseInt(in.nextLine().trim());
        output = combinationCounts(ip1);
        System.out.println(String.valueOf(output));
    }


}
