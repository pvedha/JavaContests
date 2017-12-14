package com.pvedha.ms.main;
import java.io.*;
import java.util.*;


public class IterateIt {
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner in = new Scanner(System.in);
	        int count = in.nextInt();
	        Set<Integer> arr = new TreeSet<Integer>();
	        for(int i=0;i<count;i++){
	            arr.add(in.nextInt());
	        }        
	        operate(arr);
	        System.out.println(ops);
	    }
	    
	    static int ops = 0;
	    
	    static void operate(Set<Integer> arr){
	        ops++;
	        
	        System.out.println(arr.toString());
	        Set<Integer> tmp = new TreeSet<Integer>();
	        
	        while(arr.size() > 2){
	            Integer i1 = (Integer) arr.toArray()[0];
	            arr.remove(i1);
	            System.out.println(i1);
	            for(Integer i2 : arr){
	                //if(i1 != i2){
	                    tmp.add(Math.abs(i1-i2));
	                //}
	            }
	        }
	        System.out.println("Loop  : " + ops + " Array Size : " + tmp.size());
	        if(tmp.size() == (Integer)tmp.toArray()[tmp.size()-1]){
	        	ops+=tmp.size();
	        	return;
	        }
	        if(tmp.isEmpty()) return;
	        operate(tmp);
	        
	        
	    }
	    
	    
	}