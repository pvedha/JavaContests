package com.pvedha.HackerRank.ProjectEuler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class E3OthersSolution {
/* Not my code/logic. Copied from a discussion */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long[] arr = new long[t];
		for (int a0 = 0; a0 < t; a0++) {
			arr[a0] = in.nextLong();
		}
		for (int i = 0; i < t; i++) {
			long number = arr[i];

	        long div = 2L;
	        
	        while(div<=Math.floor(Math.sqrt(number))){
	        	System.out.println("Number : " + number + " div " + div);
	            if(number%div==0){
	                number  /= div;
	            }else{
	                div++;
	            }
	        }
	        
	        System.out.println(number);
	        

		}
	}
}
