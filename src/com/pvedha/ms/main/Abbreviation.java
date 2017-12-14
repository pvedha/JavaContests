package com.pvedha.ms.main;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Abbreviation {

	static String abbreviation(String a, String b) {

		if (a.toUpperCase().contains(b.toUpperCase())) {
			int index = a.toUpperCase().indexOf(b.toUpperCase(), 0);
			//System.out.println(index);
			//System.out.println(" Start " + a.substring(0, index) + "End" + a.substring(index+1, a.length()));
			a = a.substring(0, index) + a.substring(index+b.length(), a.length());
			for(int i=0;i<a.length();i++){
				int x = a.charAt(i);
				if(x>64 && x<91){
					return "NO";
				}
			}
			//System.out.println(a);
			
			return "YES";
		} else {
			
			String B= b.toUpperCase();
			int aIndex = -1;
			int bIndex = 0;
			String remString = "";
			while(true){
				String A=a.toUpperCase();
				aIndex = A.indexOf(B.charAt(bIndex));
				if(aIndex != -1){
					remString += a.substring(0,aIndex);
					a = a.substring(aIndex+1, a.length());	
					
				}else{
					return "NO";
				}
				bIndex++;
				if(bIndex == b.length()){
					break;
				}
				//System.out.println(a + " " + bIndex);
			}
			
			a = remString + a;
			System.out.println(a);
			for(int i=0;i<a.length();i++){
				int x = a.charAt(i);
				if(x>64 && x<91){
					return "NO";
				}
			}
			
			return "YES";
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String a = in.next();
			String b = in.next();
			String result = abbreviation(a, b);
			System.out.println(result);
		}
		in.close();
	}
}
