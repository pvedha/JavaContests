package com.pvedha.ms.main;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Euler2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long t = in.nextLong();
        for(int a0 = 0; a0 < t; a0++){
            BigInteger n = in.nextBigInteger();
            BigInteger previous = BigInteger.ZERO;
            BigInteger next = BigInteger.ONE;
            BigInteger result = BigInteger.ZERO;
            
            while(true){
            	BigInteger tmp = BigInteger.ZERO;
            	tmp = previous.add(next);
            	tmp = tmp.add(next);
                result = result.add(tmp);               
                next = next.add(previous).add(tmp);                
                previous = tmp;       
                
                if(result.add(next).add(previous).compareTo(n) == 1){
                    break;
                }
                //next = tmp + ;
            }
            System.out.println(result);
        }
        
    }
}


/* working code/logic

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long t = in.nextLong();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            Long previous = 0L;
            Long next = 1L;
            Long result = 0L;            
            while(true){
                Long tmp = previous + 2 * next;       
                if(tmp > n){
                    break;
                }
                result += tmp;               
                next = tmp + previous + next;//2 * previous + 3 * next;
                previous = tmp;     
               
            }
            System.out.println(result);
        }
        
    }
}

*/