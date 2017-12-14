package com.pvedha.ms.main;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class ArithmaticExpressions {

	static Integer[] items;
	static int count = 0;

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		count = in.nextInt();
		items = new Integer[count];
		for (int i = 0; i < count; i++) {
			items[i] = in.nextInt();
		}
		String result = "" + items[0];
		findExp(result, items[0], 1);
	}

	static boolean findExp(String result, Integer val, int pos) {
		// System.out.println("Result " + result + " Value " + val + " pos " +
		// pos);
		if (pos == count) {
			if (val % 101 == 0) {
				System.out.println(result);
				return true;
			}
			return false;

		}
		boolean valid = false;
		if (findExp(result + "*" + items[pos], (val * items[pos]) % 101, pos + 1))
			return true;
		if (findExp(result + "+" + items[pos], (val + items[pos]) % 101, pos + 1))
			return true;
		if (findExp(result + "-" + items[pos], (val - items[pos]) % 101, pos + 1))
			return true;
		return false;
	}
}