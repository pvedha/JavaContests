package com.pvedha.ms.techgig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GenPact {

	public GenPact() {
		// TODO Auto-generated constructor stub
	}
	
	public static void score(ArrayList<Integer> credits, int index, Integer currentScore){
		if(credits.size() == index){
			scores.add(currentScore);			
			return;
		}
		Integer currentCredit = credits.get(index);		
		for(Integer grade : grades){			
			score(credits, index+1, currentScore + (currentCredit * grade));
		}
	}
	
	
	public static ArrayList<Integer> grades = new ArrayList<Integer>(Arrays.asList(10,9,8,7,6,5));
	public static Set<Integer> scores = new TreeSet<Integer>();
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int subjects = in.nextInt();
		ArrayList<Integer> creditList = new ArrayList<Integer>();		
		for(int i=0;i<subjects;i++){
			creditList.add(in.nextInt());
		}		
		sop(creditList.toString());
		score(creditList,0,0);
		sop(scores.toString());
		sop(scores.size() + "");
	}

	
	public static void sop(String message){
		System.out.println(message);
	}
}
