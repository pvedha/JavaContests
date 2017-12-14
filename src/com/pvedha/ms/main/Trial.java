package com.pvedha.ms.main;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;

public class Trial {

	public Trial() {
		
	}

	public static void main(String args[]) 
    {        
		long ways = getWays(4, new long[]{1,2,3});
        System.out.println(ways);
        HashMap<Integer, Integer> valCounts = new LinkedHashMap<Integer,Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();        
        

    }
	
	static long ways = 0;
    
    
    private static void sop(long message){
	   System.out.println(message + "");
   }
   
   private static void sop(int message){
	   System.out.println(message + "");
   }

   private static void sop(String message){
	   System.out.println(message);
   }
	
	static long getWays(long n, long[] c){
        // Complete this function
        //sop(n + " " + Arrays.toString(c) + " " + ways );
        if(n < 0){
            sop("y");
                return ways;
        }
        
        //while(true){ 
            
            if(n == 0){                
                return ++ways;
            }
            if(c.length == 1){                
                if(n%c[0] == 0){
                    sop("z");
                    ++ways;
                } 
                //return ways;
            } else {   
                //sop("x" + n + " " + c[0]);                
                for(int i=0;i<n/c[0]+1;i++){
                    if(c[0] == 1){
                    	sop("i" + i + " n is " + n);
                    }
                    getWays(n- i * c[0], Arrays.copyOfRange(c, 1, c.length ));
                }
            }
            
        //}        
        return ways;
        
    }
	
}
