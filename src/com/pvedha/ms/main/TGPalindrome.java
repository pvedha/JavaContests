package com.pvedha.ms.main;

public class TGPalindrome {

	public static void main(String args[]) {
		String ip = "123456453678900";
		ip = "1111111111";
		lengthofPalindrome(ip);
		sop("max value " + max);
	}

	public static int max = 0;

	public static int lengthofPalindrome(String str) {
		calculatePalindrome(str);
		return max;
	}

	public static void calculatePalindrome(String str) {

		int len = str.length();
		if (len < max) {
			return;
		}
		if (len == 2) { // not needed maybe
			if (max < 2) {
				if (str.charAt(0) == str.charAt(1)) {
					max = 2;
				}
			}
			return;
		}
		if (len % 2 == 1) { // not even length
			lengthofPalindrome(str.substring(0, len - 1));
			lengthofPalindrome(str.substring(1));
			return;
		}
		validate(str);
		if (len > 3) {
			lengthofPalindrome(str.substring(0, len - 2));
			lengthofPalindrome(str.substring(1, len - 1));
			lengthofPalindrome(str.substring(2, len));
		}

	}

	public static void validate(String str) {

		String leftMain = ""; // may use arraylist<chars>
		String rightMain = "";
		
		String source = new String(str);
		
		
		while(true){
			String left = "";
			String right = "";
			String tmp = "";
			for (int i = 0; i < source.length(); i++) {
				char c = source.charAt(i);
				if (left.indexOf(c) == -1) {
					left += c;
				} else if (right.indexOf(c) == -1) {
					right += c;
				} else {
					tmp += c;
				}
			}
			leftMain += left;
			rightMain += right;
			if(tmp.length() == 0) break;			
			source = tmp;
		}		
		if (leftMain.length() + rightMain.length() == str.length() && leftMain.length() == rightMain.length()) {
			if (max < str.length()) {
				max = str.length();
				//sop(str + " " + leftMain + " " + rightMain);
			}
		}

	}

	public static void sop(String msg) {
		System.out.println(msg);
	}

	public TGPalindrome() {
		// TODO Auto-generated constructor stub
	}

}
