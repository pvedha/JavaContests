package com.pvedha.HackerRank.ProjectEuler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class E3TimeOut {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long[] arr = new long[t];
		for (int a0 = 0; a0 < t; a0++) {
			arr[a0] = in.nextLong();
		}
		for (int i = 0; i < t; i++) {
			long number = arr[i];
			long max = (number / 2) % 2 == 1 ? number / 2 : 1 + number / 2;
			boolean done = false;
			if (number % 2 == 1 && isPrime(number)) {
				System.out.println(number);
				continue;
			}
			while (max > 1) {
				if (number % max == 0) {
					if (isPrime(max)) {
						System.out.println(max);
						done = true;
						break;
					}
				}
				max -= 2;
			}
			if (!done && number % 2 == 0)
				System.out.println(2);

		}
	}

	public static boolean isPrime(long n) {
		System.out.println(n);
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
