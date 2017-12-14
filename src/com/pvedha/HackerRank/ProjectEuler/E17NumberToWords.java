package com.pvedha.HackerRank.ProjectEuler;

import java.util.Scanner;

public class E17NumberToWords {
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		in.nextLine();
		for(int i=0;i<cases;i++){
			String number = in.nextLine();
			
			if(Long.valueOf(number) == 0){
				System.out.println("Zero");
				continue;
			}
			index = -1;
			String result = "";
			while(true){
				int length = number.length();	
								if(number.length() < 4){				
					//dig3 = number;
					result = get3DigString(number) + result;
					break;
				}
				String dig3 = length > 3 ? number.substring(length-3) : number;
				result = get3DigString(dig3) + result;
				number = length > 3 ? number.substring(0,length-3) : number;
			
			}		
			
			System.out.println(result.trim());	
		}
		
		
	}
	
	static int index = -1;
	static String[] thousands = {"","Thousand","Million","Billion"};
	static String[] words20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
			"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	static String[] words10s = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	
	
	static String get3DigString(String valueStr){
		Integer value = Integer.valueOf(valueStr);
		index++;
		String result = "";
		if(value==0) return result;
		if(value<20){
			result = words20[value] + result;
		} else if (value<100){
			result = words10s[value/10];
			if(value%10 != 0){//tens		
				result = result + " " + words20[value%10];
			}
		} else {
			result = words20[value/100] + " " + "Hundred";
			value = value % 100;
			if(value < 20){
				result = result + " " + words20[value];
			} else {
				result = result + " " + words10s[value/10];
				if(value%10 != 0){//tens		
					result = result + " " + words20[value%10];
				}	
			}
		}		
		return result + " " + thousands[index] + " ";
		
	}
}
