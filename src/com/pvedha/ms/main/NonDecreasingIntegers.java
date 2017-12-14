package com.pvedha.ms.main;

public class NonDecreasingIntegers {

	public NonDecreasingIntegers() {
		// TODO Auto-generated constructor stub
	}
	
	static int find(int digit, int val){
		int count =0;
		for(int i=0;i<1000;i++){
			int d3 = i%10;
			int d2 = (i%100)/10;
			int d1 = (i%1000)/100;
			//System.out.println(d1 + " " + d2 + " " + d3);
			if(d1 <= d2 && d2 <=d3){
				System.out.println(i);
				count++;
			}
		}
		
		return count;
	}
	public static void main(String args[]){
		System.out.println("Result : " + find(3,0));
	}

}
