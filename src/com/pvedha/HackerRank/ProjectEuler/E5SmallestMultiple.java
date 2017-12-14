package com.pvedha.HackerRank.ProjectEuler;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class E5SmallestMultiple {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] numbers = new int[t];
		for (int a0 = 0; a0 < t; a0++) {
			numbers[a0] = in.nextInt();
		}		
		for(int item=0;item<t;item++){
			Integer number = numbers[item];			
			Integer sum = 1;
			ArrayList<Integer> products = new ArrayList<Integer>();
			for(int i=2;i<=number;i++){
				Integer entry = i;
				for(Integer product : products){					
					if(entry % product == 0){
						entry /= product;						
					}						
				}
				products.add(entry);
				sum*=entry;	
			}
			System.out.println(sum);
		}		
	}
}
