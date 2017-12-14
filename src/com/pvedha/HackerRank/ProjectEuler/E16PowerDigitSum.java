package com.pvedha.HackerRank.ProjectEuler;

import java.math.BigInteger;
import java.util.Scanner;

public class E16PowerDigitSum {
	
	static BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
	public static void main(String args[]){		
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int i=0;i<cases;i++){
			String result = two.pow(in.nextInt()).toString();
			Integer sum = 0;
			for(int c=0;c<result.length();c++){
				sum += result.charAt(c) - 48;
			}
			System.out.println(sum);			
		}
	}
}
