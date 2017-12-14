package com.pvedha.ms.main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Executors;

public class Learn {

	public Learn() {
		// TODO Auto-generated constructor stub
		
		 
	}

	public static void main(String args[]){
		String ms = "1001012010001100";
		ms="UUUUTUUUU";
		//ms = ms.replaceAll("U", "2").replaceAll("T", "0").replaceAll("D", "1");
		//System.out.println(ms.length());
//		System.out.println(Arrays.toString(ms.getBytes() ));
		BigInteger bi = BigInteger.TEN;
		BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
		bi = bi.multiply(bi);
		System.out.println(bi);
		
		int[] someInt = {1,6,3,6,3,7,4,3,8};
		ArrayList<Integer> something = new ArrayList<>(Arrays.asList(5,3,6,87,3,4,7));

		System.out.println(new int[]{1,5,4});
		System.out.println(ms.contains("UT"));
		System.out.println(ms.indexOf("UT",4));
		Set<Integer> scores = new TreeSet<>();
		for(Integer val : scores){
			
		}
		scores.size();
		Integer x = 10;
		
		for(int i=0;i<someInt.length; i++){
			something.add(someInt[i]);
		}
		
		Collections.sort(something);
		System.out.println(something.toString());

		
		
		System.out.println("End");
		
		
		
	}
	
	static int ROWS = 2, COLS=6, WIDTH=12;
	static char VISITED='V';
	static int visits = 0;
	static StringBuilder sb = new StringBuilder("");
    static void visit(int pos, char c){
        //if(copyBar[row][col] == VISITED){
          //  return;
        //}
    	System.out.println("-- " + sb);
        if(sb.charAt(pos) == c){
            sb.setCharAt(pos, VISITED);
            visits++;    
            if(pos + COLS < WIDTH && sb.charAt(pos + COLS) == c){ //visit down
            	System.out.println("down");
                visit(pos+COLS, c);
            }
            if(pos - COLS >= 0 && sb.charAt(pos - COLS) == c){ //visit down
            	System.out.println("up");
                visit(pos-COLS, c);
            }
            if(pos % COLS != 0){
            	
            	if(pos -1 >= 0 && sb.charAt(pos -1) == c){ //visit down
            		System.out.println("left");
                    visit(pos-1, c);
                }   
            }            
            if(pos % COLS != COLS -1){
            	if(pos + 1 < WIDTH && sb.charAt(pos + 1) == c){ //visit down
            		System.out.println("right");
            		visit(pos+1, c);
            	}
            }
                     
        }    
        return;
    }
}
