package com.pvedha.ms.techgig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GenPactV2 {

	public GenPactV2() {
		// TODO Auto-generated constructor stub
	}
	
	public static void score(Integer loop, Integer currentScore){
		//sop(loop + " " + currentScore);
		if(loop == creditList.size()){
			scores.add(currentScore);	
			//sop(scores.toString());
			return;
		}
	
		for(Integer score : possibleScores.get(creditList.get(loop))){			
			score(loop+1, currentScore + score);
		}
	}
	
	
	public static ArrayList<Integer> grades = new ArrayList<Integer>(Arrays.asList(10,9,8,7,6,5));
	public static ArrayList<Integer> creditList = new ArrayList<Integer>();
	public static HashMap<Integer, Set<Integer>> possibleScores = new LinkedHashMap<Integer, Set<Integer>>();
	public static Set<Integer> scores = new TreeSet<Integer>();
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int subjects = in.nextInt();	
		Integer[] creditTimes = {0,0,0,0,0};
		for(int i=0;i<subjects;i++){
			Integer credit = in.nextInt();
			creditList.add(credit);
			//creditTimes[credit-1]+=1;
		}		
		for(Integer credit : creditList){
			if(possibleScores.containsKey(credit)){
				continue;
			}
			Set<Integer> ps = new TreeSet<Integer>();
			for(Integer grade : grades){
				ps.add(credit * grade);
			}
			possibleScores.put(credit, ps);
		}
		sop(possibleScores.toString());
		score(0,0);
		sop(scores.toString());
		sop(scores.size() + "");
		
	}

	
	public static void sop(String message){
		System.out.println(message);
	}
}
