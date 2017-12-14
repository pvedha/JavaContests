package com.pvedha.HackerRank.ProjectEuler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class E3LargestPrimeFactor {

	/*
	 4
17
10
235436456457
	 5755868469869
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long[] arr = new long[t];
		for (int a0 = 0; a0 < t; a0++) {
			arr[a0] = in.nextLong();
		}
		for (int i = 0; i < t; i++) {
			long number = arr[i];
			// long max = (number/2) % 2 == 1 ? number/2 : 1+number/2;
			boolean done = false;
			// System.out.println("trial " + number/2);
			if (number % 2 == 1 && isPrime(number)) {
				System.out.println(number);
				continue;
			} else {
				if (isPrime(number / 2)) {
					System.out.println(number / 2);
					continue;
				}
			}
			long index = 3;
			while (true) {
				if (number % index == 0) {
					if (isPrime(number / index)) {
						System.out.println(number / index);
						done = true;
						break;
					}
				}
				index++;
				if (index * index > number) {
					break;
				}
			}
			if (!done) {
				index = index % 2 == 0 ? index - 1 : index;
				while (index > 1) {
					if (number % index == 0) {
						if (isPrime(index)) {
							System.out.println(index);
							done = true;
							break;
						}
					}
					index -= 2;
				}
			}
			if (!done && number % 2 == 0)
				System.out.println(2);
		}
	}

	public static boolean isPrime(long n) {
		System.out.println("Checking " + n);
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
