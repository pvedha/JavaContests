package com.pvedha.ms.techgig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class TGRemote {

	public static void checkPossibilities(Integer level, Integer position){
		if(level <0){
			return;
		}
		if(level == 0){
			possibilities += 1;
			return;
		}		
		for(Integer p : possibleMoves.get(position)){
			checkPossibilities(level-1, p);
		}
	}
	
	public static Integer possibilities =0;
	public static HashMap<Integer,ArrayList<Integer>> possibleMoves = new LinkedHashMap<Integer,ArrayList<Integer>>();
	public static void main(String args[]){
		//stupid way of initializing, but assured :D 0-9 == A-J
		/*
		 *  0 1 2
		 *  3 4 5
		 *  6 7 8
		 *  - 9 -
		 */
		possibleMoves.put(0, new ArrayList<Integer>(Arrays.asList(0,1,3)));
		possibleMoves.put(1, new ArrayList<Integer>(Arrays.asList(0,1,2,4)));
		possibleMoves.put(2, new ArrayList<Integer>(Arrays.asList(1,2,5)));
		possibleMoves.put(3, new ArrayList<Integer>(Arrays.asList(0,3,4,6)));
		possibleMoves.put(4, new ArrayList<Integer>(Arrays.asList(1,3,4,5,7)));
		possibleMoves.put(5, new ArrayList<Integer>(Arrays.asList(2,4,5,8)));
		possibleMoves.put(6, new ArrayList<Integer>(Arrays.asList(3,6,7)));
		possibleMoves.put(7, new ArrayList<Integer>(Arrays.asList(4,6,7,8,9)));
		possibleMoves.put(8, new ArrayList<Integer>(Arrays.asList(5,7,8)));
		possibleMoves.put(9, new ArrayList<Integer>(Arrays.asList(7,9)));
		
		long startTime   = System.currentTimeMillis();
		
		Scanner in = new Scanner(System.in);
		int level = in.nextInt();
		for (int j = 2; j < 16; j++) {
			level = j;
			possibilities = 0;
			for(int i =0;i<10;i++){
			checkPossibilities(level-1,i);
			}
			System.out.println( j + " - " + possibilities);
		}
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("End of Processing: " + totalTime);
		
		System.out.println(possibilities);
	}
	
	public static void sop(String msg){
		System.out.println(msg);
	}
	public TGRemote() {
		// TODO Auto-generated constructor stub
	}

}
