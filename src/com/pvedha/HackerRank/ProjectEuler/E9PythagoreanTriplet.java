package com.pvedha.HackerRank.ProjectEuler;

import java.util.Scanner;

public class E9PythagoreanTriplet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			if (n < 12 || n%2==1) {
				System.out.println(-1);
				continue;
			}			
			Long maxProduct = -1L;
			int c;
			for (int a = (int) Math.sqrt(n); a < n; a++) {
				for (int b = a + 1; b < n; b++) {
					c = n - a - b;		
                    if(c < b){                    	
                        break;
                    }                    
					if (a * a + b * b == c * c) {
						if (maxProduct < a * b * c) {
							maxProduct = (long) (a * b * c);	
							
						}
					}
				}
			}
			System.out.println(maxProduct);
		}
	}

}
