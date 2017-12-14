package com.pvedha.ms.main;

import java.io.*;
import java.util.*;

public class CuttingCosts {

	static void sop(String m) {
		System.out.println(m);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for (int i = 0; i < cases; i++) {
			Integer height = in.nextInt();
			Integer width = in.nextInt();

			for (int j = 0; j < height - 1; j++) {
				wCosts.add(in.nextInt());
			}
			for (int j = 0; j < width - 1; j++) {
				hCosts.add(in.nextInt());
			}

			Collections.sort(hCosts);
			Collections.sort(wCosts);
			Collections.reverse(hCosts);
			Collections.reverse(wCosts);
			Integer[] piece = { height, width };
			pieces.add(piece);

			Integer cost = findCuttingCost();
			System.out.println(cost);

		}

	}

	static String toString(ArrayList<Integer[]> list) {
		String result = "";
		for (Integer[] item : list) {
			result += Arrays.toString(item) + " ";
		}
		return result;
	}

	static int H = 0, W = 1; // Index for Height/horizontal or Width or Vertical
	static ArrayList<Integer[]> pieces = new ArrayList<Integer[]>();
	static ArrayList<Integer> hCosts = new ArrayList<Integer>();
	static ArrayList<Integer> wCosts = new ArrayList<Integer>();

	static Integer findCuttingCost() {
		if (hCosts.isEmpty() && wCosts.isEmpty())
			return 0;
		Integer hCutsPossible = 0;
		Integer wCutsPossible = 0;
		Integer hSplits = 0;
		Integer wSplits = 0;
		for (Integer[] piece : pieces) {
			if (piece[H] > 1) {
				hCutsPossible++;
				hSplits += piece[W];
			}
			if (piece[W] > 1) {
				wCutsPossible++;
				wSplits += piece[H];
			}
		}
		Integer cuttingCost = 0;
		//System.out.println("Possible hSplits " + hSplits + " w " + wSplits);
		Integer hCutCost = hCosts.isEmpty() ? 0 : hCosts.get(0);
		Integer wCutCost = wCosts.isEmpty() ? 0 : wCosts.get(0);
		System.out.println("HcutCost " + hCutCost + "  " + wCutCost);
		
		if(hCutCost == wCutCost){
			if(wCutCost != 0){
				cuttingCost = wCosts.remove(0);
				cuttingCost *= wCutsPossible;
				// hCutCost = hCosts.get(0) * hCutsPossible;
				pieces = makeCuts(W);
				System.out.println("Wcut " + cuttingCost + " new pieces " + toString(pieces));
				
			} else {
			
				cuttingCost = hCosts.remove(0);
				cuttingCost *= hCutsPossible;
				// hCutCost = hCosts.get(0) * hCutsPossible;
				pieces = makeCuts(H);
				System.out.println("Hcut " + cuttingCost + " new pieces " + toString(pieces));

			}
		} else if(hCutCost > wCutCost) {
			cuttingCost = hCosts.remove(0);
			cuttingCost *= hCutsPossible;
			// hCutCost = hCosts.get(0) * hCutsPossible;
			pieces = makeCuts(H);
			System.out.println("Hcut " + cuttingCost + " new pieces " + toString(pieces));

		} else {
			cuttingCost = wCosts.remove(0);
			cuttingCost *= wCutsPossible;
			// hCutCost = hCosts.get(0) * hCutsPossible;
			pieces = makeCuts(W);
			System.out.println("Wcut " + cuttingCost + " new pieces " + toString(pieces));
		}

		System.out.println("The cutting cost is " + cuttingCost);
		return cuttingCost + findCuttingCost();

	}

	static ArrayList<Integer[]> makeCuts(int direction) {
		ArrayList<Integer[]> newPieces = new ArrayList<Integer[]>();
		for (Integer[] piece : pieces) {
			if (piece[direction] > 1) {
				if (piece[direction] % 2 == 0) {
					if (direction == H) {
						newPieces.add(new Integer[] { piece[H] / 2, piece[W] });
						newPieces.add(new Integer[] { piece[H] / 2, piece[W] });
					} else {
						newPieces.add(new Integer[] { piece[H], piece[W] / 2 });
						newPieces.add(new Integer[] { piece[H], piece[W] / 2 });
					}
				} else {
					if (direction == H) {
						Integer position = (piece[H] / 2) + 1;
						newPieces.add(new Integer[] { position, piece[W] });
						newPieces.add(new Integer[] { piece[H] - position, piece[W] });
					} else {
						Integer position = (piece[W] / 2) + 1;
						newPieces.add(new Integer[] { piece[H], position });
						newPieces.add(new Integer[] { piece[H], piece[W] - position });
					}

				}
			} else {
				newPieces.add(piece);
			}
		}
		return newPieces;
	}
}