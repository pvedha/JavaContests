package com.pvedha.HackerRank.ProjectEuler;

import java.util.Scanner;
/* Stupid logic, but just got through with it. Scope for optimizations */
public class E4PalindromeProduct {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] n = new int[t];
		for (int a0 = 0; a0 < t; a0++) {
			n[a0] = in.nextInt();
		}

		for (int i = 0; i < t; i++) {
			Integer number = n[i];
			while (number > 101101) {
				number = getNextPal(number);				
				if(is3digProduct(number)){
					System.out.println(number);
					break;
				}
			}
		}
	}

	private static boolean is3digProduct(Integer number){
		Integer div = 999;
		while(div > 100){
			if(number % div == 0){
				Integer q = number / div;
				if(q > 100 && q < 1000){					
					return true;
				}				
			}
			div--;			
		}		
		return false;
				// 997799 is the max 6 dig palindrome with 3 dig product
				// 999 * 999 = 998001 is the max possible 3 dig product
				// 101 * 999 = 100899 is the min possible. 
	}
	
	private static Integer getNextPal(Integer number) {
		Integer dig3 = Integer.parseInt(number.toString().substring(0, 3));
		while(true){						
			Integer palMax = dig3 * 1000 + (dig3 % 10)*100 + ((dig3 / 10) % 10)*10 + ((dig3 / 100) % 10) ;
			if(palMax < number){
				System.out.println(palMax);
				return palMax;
			}
			dig3--;
		}		
	}

}
