package com.pvedha.ms.trial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class Trial {

	public Trial() {
		// TODO Auto-generated constructor stub
	}
	
	Runnable r1 = () -> System.out.println(this);
	Runnable r2 = () -> System.out.println(toString());
	
		public String toString() { return "Hello, world!"; }
	
	 	public static void main(String... args) {
			new Trial().r1.run(); //Hello, world!
			new Trial().r2.run(); //Hello, world!
			
			
			ArrayList<Integer> arr = new ArrayList<Integer>();
			arr.addAll(Arrays.asList(5,3,6,87,3,4,7));
			arr.forEach(System.out::println);
	
			int [] arrx = {1,4,6,3,3,7,4,3,2};
			
			Set<Integer> tmp = new TreeSet<Integer>();
			//tmp
			//Arrays.asList(arrx).forEach(System.out::println);
			
		}

}
