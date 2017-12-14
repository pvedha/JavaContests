package com.pvedha.HackerRank.ProjectEuler;

import java.util.Scanner;

public class E11LargestProductInGrid {

	//lot of duplications, just to see if solution is correct
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] grid = new int[20][20];
		for (int grid_i = 0; grid_i < 20; grid_i++) {
			for (int grid_j = 0; grid_j < 20; grid_j++) {
				grid[grid_i][grid_j] = in.nextInt();
			}
		}

		Long largestProduct = 0L;

		// only horizontals
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 17; j++) {
				Long product = (long) (grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3]);
				if (largestProduct < product) {
					largestProduct = product;
				}
			}
		}

		// only verticals
		for (int i = 0; i < 17; i ++) {
			for (int j = 0; j < 20; j++) {
				Long product = (long) (grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j]);				
				if (largestProduct < product) {
					largestProduct = product;
				}
			}
		}

		// only \ diagonals
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 17; j++) {
				Long product = (long) (grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3]);							
				if (largestProduct < product) {
					largestProduct = product;
				}
			}
		}

		// only / diagonals
		for (int i = 0; i < 17; i++) {
			for (int j = 3; j < 20; j++) {
				Long product = (long) (grid[i][j] * grid[i + 1][j - 1] * grid[i + 2][j - 2] * grid[i + 3][j - 3]);
				if (largestProduct < product) {
					largestProduct = product;
				}
			}
		}
		System.out.println(largestProduct);
	}


}
