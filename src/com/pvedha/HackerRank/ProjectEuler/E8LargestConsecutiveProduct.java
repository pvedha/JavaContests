package com.pvedha.HackerRank.ProjectEuler;

import java.util.Arrays;
import java.util.Scanner;

public class E8LargestConsecutiveProduct {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();
			String num = in.next();			
			Long maxProduct = 0L;
			for (int i = 0; i < n - k + 1; i++) {
				String currentDigits = num.substring(i,i+k);				
				if(currentDigits.contains("0")){
					continue;
				}
				Long product = 1L;
				for(char digit : currentDigits.toCharArray()){
					product *= digit - 48;
				}
				if(maxProduct < product){
					maxProduct = product;
				}
			}
			System.out.println(maxProduct);
		}
	}

}
