package com.pvedha.ms.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Data {

	public static ArrayList<Integer> data = new ArrayList<>();
	private static Integer[] dataCollection = {34,6,23,67,45,45};
	
	
	static {
		//data.addAll(Arrays.asList(dataCollection));
		for(int i=0;i<10000;i++){
			data.add((int) Math.round(Math.random()*100));
		}
	}

}
