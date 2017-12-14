package com.pvedha.ms.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ValidateSquareInMatrix {

	public ValidateSquareInMatrix() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		
		initVisitMap();
		
		String bs = "DDDDTTTDTDTDTDTDTDTDDDDD";
		int loop = 500000;
		for(int i=0;i<loop;i++){
			validate4Square_old(bs);			
		}
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("For old 4 squares " + totalTime);
		
		init4SquareNodes();
		for(int i=0;i<loop;i++){
			validate4Square(bs);			
		}
		
		startTime = endTime;
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("for new 4 squares: " + totalTime);
		
		
		for(int i=0;i<loop;i++){			
			sb = new StringBuilder(bs);
			visit(0,'D');
		}
		
				
		startTime = endTime;
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("End of Program: " + totalTime);

	}
	
	static int COLS = 4, ROWS = 6, WIDTH = 24;
	static StringBuilder sb = new StringBuilder("");	
	static int visits=0;
	static char VISITED='V';
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
	static void visit(int pos, char c){
		if (sb.charAt(pos) == c) {
			sb.setCharAt(pos, VISITED);
			visits++;
			for(Integer position : visitMap.get(pos)){
				if(sb.charAt(position) == c) visit(position, c);
			}
		}
	}
	
	
	static void init4SquareNodes(){
		int length = WIDTH - COLS - 1;		
		for (int i = 0; i < length; i++) {
			if (i % COLS == COLS - 1) {
				continue; // rather shall do i++?? no damn, last of the last
							// fails??
			}
			Integer[] pos = {i, i+2, COLS + i, COLS + i + 2};
			squareNodes.add(pos);			
		}			
	}
	
	static ArrayList<Integer[]> squareNodes = new ArrayList<>();	
	static boolean validate4Square(String bs) {
		for (Integer[] pos : squareNodes){
			String square = bs.substring(pos[0], pos[1]) + bs.substring(pos[2], pos[3]);
			if (square.contentEquals("DDDD") || square.contentEquals("TTTT")) {
				return false;
			}
		}
		return true;
	}
	
	
	static boolean validate4Square_old(String bs) {// Integer x){
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
