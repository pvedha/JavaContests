package com.pvedha.HackerRank.ProjectEuler;

import java.util.ArrayList;
import java.util.Scanner;

public class E18MaximumPathSum {
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for (int c = 0; c < cases; c++) {
			length = in.nextInt();
			maxSum = 0;
			paths.clear();

			for (int i = 0; i < length; i++) {
				ArrayList<Integer> dList = new ArrayList<Integer>();
				for (int j = 0; j < i + 1; j++) {
					dList.add(in.nextInt());
				}
				paths.add(dList);
			}
			maxSum(0, 0, 0);
			System.out.println(maxSum);
		}
	}

	static ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
	static int length = 0;
	static Integer maxSum = 0;

	static void maxSum(int pos, int depth, int sum) {
		sum += paths.get(depth).get(pos);
		if (depth == length - 1) {
			if (sum > maxSum) {
				maxSum = sum;
			}
			return;
		}

		maxSum(pos, depth + 1, sum);
		maxSum(pos + 1, depth + 1, sum);
	}

}
