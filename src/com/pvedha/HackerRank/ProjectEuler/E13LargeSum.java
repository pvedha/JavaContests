package com.pvedha.HackerRank.ProjectEuler;

import java.math.BigInteger;
import java.util.Scanner;

public class E13LargeSum {
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		BigInteger inputs[] = new BigInteger[cases];
		BigInteger sum = BigInteger.ZERO;
		for(int i=0;i<cases;i++){
			sum = sum.add(in.nextBigInteger());			
		}
		System.out.println(sum.toString().substring(0, 10));
	}
}
