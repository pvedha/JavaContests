package com.pvedha.HackerRank.ProjectEuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E7NthPrime {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		Integer[] numbers = new Integer[t];
		for (int a0 = 0; a0 < t; a0++) {
			numbers[a0] = in.nextInt();
		}	
		
		primeNumbers.add(2L);
		primeNumbers.add(3L);
		for(Integer number : Arrays.asList(numbers)){
			Long lastPrime = primeNumbers.get(primeNumbers.size() -1);
			while(primeNumbers.size() < number){				
				lastPrime+=2;
				if(isPrime(lastPrime)){
					primeNumbers.add(lastPrime);
				}
			}
			System.out.println(primeNumbers.get(number-1));
		}
	}
	
	static ArrayList<Long> primeNumbers = new ArrayList<Long>();
	
	public static boolean isPrime(long n) {		
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
