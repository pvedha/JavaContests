package com.pvedha.ms.main;

import java.io.*;
import java.util.*;

public class Euler191 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer l = in.nextInt();
        Integer n = in.nextInt(); //1 for m consecutive days
        Integer m = in.nextInt(); //0 on more than n occasions
        Integer c = in.nextInt(); //max+1 score
        Integer validItems = 0;
        for(int i=l;i>0;i--){ //start with max days
            //System.out.println("  --- ");
            System.out.println("validItems : " + validItems);
            //generate combinations 
            Double count = Math.pow(i, c);
            for(int j=0;j<count;j++){
                Integer x = j;
                System.out.println("");
                boolean valid = true;
                Integer nCount = 0, mCount=0;
                Integer maxDigits = l;// just use l
                Integer digitCount = 0;
                while(x > 0){
                    System.out.print(x%c);
                    Integer digit = x%c;
                    if(digit == 0){
                        nCount++;
                    }
                    if(digit == 1){
                        mCount++;
                    } else {
                        mCount = 0;
                    }
                    if(nCount > n || mCount == m){
                        System.out.println(nCount + " " + mCount);
                        valid = false;
                        break;
                    }
                    digitCount++;
                    x/=c;
                }
                if(valid && ((maxDigits - digitCount + nCount) <= n)){
                    validItems++;           
                    
                    
                } else {
                    System.out.println("Max " + maxDigits + " " + digitCount + " " + nCount + " n " + n);
                }
            }
        }
        System.out.println(validItems);
        
    }
}