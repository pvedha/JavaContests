package com.pvedha.ms.main;
import java.io.*;
import java.util.*;

public class HammingDistance {
	    static void sop(String message){
	        //System.out.println(message);
	    }
	    static StringBuffer str;
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner in = new Scanner(System.in);
	        int len = in.nextInt();
	        in.nextLine();
	        long startTime = System.currentTimeMillis();
	        
	        str = new StringBuffer(in.nextLine());
	        int cases = in.nextInt();
	        in.nextLine();
	        long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("End of Input: " + totalTime);
	        for(int i=0;i<cases;i++){
	            String line = in.nextLine();
	            System.out.println(i + " " + line);
	            switch(line.charAt(0)){
	                case 'R':                    
	                    opR(line);
	                    break;
	                case 'H':
	                    opH(line);
	                    break;
	                case 'C':
	                    opC(line);
	                    break;
	                case 'S':
	                    opS(line);
	                    break;
	                case 'W':
	                    opW(line);
	                    break;
	            }
	        }      
	        
	        startTime = endTime;
			endTime   = System.currentTimeMillis();
			totalTime = endTime - startTime;
			System.out.println("End of Program: " + totalTime);
	       
	    }
	    
	    static void opR(String line){
	        Scanner in = new Scanner(line.substring(1));
	        int l1 = in.nextInt();
	        int l2 = in.nextInt();         
	        str = new StringBuffer(str.substring(0,l1-1) + new StringBuffer(str.substring(l1-1,l2)).reverse() + str.substring(l2));
	    }
	    
	    static void opW(String line){
	        Scanner in = new Scanner(line.substring(1));
	        int l1 = in.nextInt();
	        int l2 = in.nextInt();
	        System.out.println(str.substring(l1-1,l2)); // 1,4 substring starts at index 1 till index 3.
	    }
	    
	    static void opC(String line){
	        Scanner in = new Scanner(line.substring(1));
	        int l1 = in.nextInt();
	        int l2 = in.nextInt();
	        char ch = in.next().charAt(0);
	        char oldChar = ch == 'a' ? 'b' : 'a';
	        
	        str = new StringBuffer(str.substring(0,l1-1) + str.substring(l1-1,l2).replace(oldChar,ch) 
	                               + str.substring(l2));        
	    }
	    
	     static void opS(String line){
	        Scanner in = new Scanner(line.substring(1));
	        int l1 = in.nextInt();
	        int r1 = in.nextInt();
	        int l2 = in.nextInt();
	        int r2 = in.nextInt();
	        
	        str = new StringBuffer(str.substring(0,l1-1) + str.substring(l2-1,r2) + str.substring(r1,l2-1) + str.substring(l1-1,r1) + str.substring(r2));        
	     }
	    
	     static void opH(String line){
	    	Scanner in = new Scanner(line.substring(1));
	        int l1 = in.nextInt();        
	        int l2 = in.nextInt();
	        int len = in.nextInt();
	        int count = 0;
	        String s1 = str.substring(l1-1, l1+len-1).replace('a', '0').replace('b', '1'); //instead of replace count/3
	        String s2 = str.substring(l1-1, l1+len-1).replace('a', '0').replace('b', '1'); //instead of replace count/3
	        for(int i=0;i<len;i++){
	            if(s1.charAt(i) != s2.charAt(i))
	        	count++;
	        }
	        StringBuffer sb = new StringBuffer();
	        
//	         byte[] s1 = str.substring(l1-1, l1+len-1).getBytes();//.replace('a', '0').replace('b', '1'); //instead of replace count/3
//	         byte[] s2 = str.substring(l2-1, l2+len-1).getBytes();//.replace('a', '0').replace('b', '1');
//	        for(int i=0;i<len;i++){
//	            //if(s1.charAt(i) != s2.charAt(i))
//	                count += s1[i] ^ s2[i];//s1.charAt(i) ^ s2.charAt(i);
//	        }
	        System.out.println(count);
	         
	     }
	    
	    
	}
