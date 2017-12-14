package com.pvedha.ms.main;


import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class SeparateTheChocolate {

	static char T = 'T';
	static char D = 'D';
	static char U = 'U';
	static char VISITED = 'V';
	static int ROWS;
	static int COLS;
	static int WIDTH;

	static void sop(String message) {
		System.out.println(message);
	}

	static void printArr(Integer arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		
		long startTime = System.currentTimeMillis();
		ROWS = in.nextInt();
		COLS = in.nextInt();
		int diff = in.nextInt();

		in.nextLine(); //just move to next line. horrible way.
		String bar = "";
//		while (in.hasNextLine()) {
//			bar += in.nextLine();
//			System.out.println(bar);
//		}
		for(int i=0;i<ROWS;i++){
			bar+=in.nextLine();
		}
		in.close();

		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("End of Input: " + totalTime);
		
		
		WIDTH = ROWS * COLS;
		
		Double possibilities = Math.pow(2, WIDTH);
		for (int i = 0; i < possibilities; i++) {
			count1s = Integer.bitCount(i);

			if (Math.abs(WIDTH - 2 * count1s) > diff) {
				continue; // more than the allowed diff
			}
			validateSplit(bar, i);

		}

		System.out.println(validSplits + "");
		
		startTime = endTime;
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("End of Program: " + totalTime);
	}

	static boolean trial = false;

	static int validSplits = 0;
	static int count1s = 0;

	static void validateSplit(String arr, Integer val) {

		bs = Integer.toBinaryString(val);
		bs = String.format("%0" + (WIDTH - bs.length() + 1) + "d%s", 0, bs).substring(1).replace('0', 'D').replace('1',
				'T');
		if (!validate4Square(bs)) { // can use static val;
			return;
		}
		
		int pos = 0;
		StringBuilder s = new StringBuilder(arr);
		while (true) {
			pos = s.indexOf("U", pos);
			if (pos == -1) {
				break;
			}
			s.setCharAt(pos, bs.charAt(pos));
		}

		if (!s.toString().contentEquals(bs)) {
			return;
		}
		validateConnectivity();
	}

	static String bs = "";
	static int visits = 0;
	static HashMap<Integer,ArrayList<Integer>> visitMap = new LinkedHashMap<>();
	
	static void initVisitMap(){
		for(int i=0;i<WIDTH;i++){
			ArrayList<Integer> nodes = new ArrayList<>();
			if(i+COLS < WIDTH){
				nodes.add(i+COLS);
			}
			if(i-COLS >= 0){
				nodes.add(i-COLS);
			}
			if(i%COLS !=0 && i-1 >= 0){
				nodes.add(i-1);
			}
			if(i%COLS != COLS-1 && i+1 < WIDTH){
				nodes.add(i+1);
			}
			visitMap.put(i, nodes);			
		}
	}
	
	
	
	static void validateConnectivity() {
		// find first occurance 1 and then 0. //can do it at creation of
		// copyBar, check if overloaded if conditions.
		Integer currentRow = 0;
		Integer currentCol = 0;
		initVisitMap();
		int pos = bs.indexOf(T);

		if (pos != -1) {
			visits = 0;
			sb = new StringBuilder(bs);
			visit(pos, T);

			if (visits < count1s) {
				return;
			}
		}

		pos = bs.indexOf(D);
		if (pos != -1) {
			visits = 0;
			sb = new StringBuilder(bs);

			visit(pos, D);

			if (visits < WIDTH - count1s) {
				return;
			}
		}
		// sop(sb + " visited for D" + visits + " " + countDs + " " + copyBar);
		// sop(copyBar);
		validSplits++;
	}

	static StringBuilder sb = new StringBuilder("");	
	
	static void visit(int pos, char c){		
		if (sb.charAt(pos) == c) {
			sb.setCharAt(pos, VISITED);
			visits++;
			for(Integer position : visitMap.get(pos)){
				if(sb.charAt(position) == c) visit(position, c);
			}
		}
	}

	// this needs optimization case 10 fails
	
	
	
	static boolean validate4Square(String bs) {// Integer x){
		int length = bs.length() - COLS - 1;
		int WIDTH = COLS;
		for (int i = 0; i < length; i++) {
			if (i % WIDTH == WIDTH - 1) {
				continue; // rather shall do i++?? no damn, last of the last
							// fails??
			}
			String square = bs.substring(i, i + 2) + bs.substring(WIDTH + i, WIDTH + i + 2);
			if (square.contentEquals("DDDD") || square.contentEquals("TTTT")) {
				return false;
			}
		}
		return true;

	}

}
