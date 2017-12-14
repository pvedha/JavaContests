package com.pvedha.ms.main;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GreedyFlorist {

    static HashMap<Integer, Integer> purchaseCount = new HashMap<Integer,Integer>();
    static ArrayList<Integer> flowers = new ArrayList<Integer>();
    static int flowersCount = 0;
    static int peopleCount = 0;
    static int getMinimumCost(int n, int k, int[] c){     
    	flowersCount = n;
    	peopleCount = k;
		for(int i=0;i<n; i++){
			flowers.add(c[i]);
		}	
		Collections.sort(flowers);
		Collections.reverse(flowers);
		System.out.println(flowers.toString());
        for(int i=0;i<k;i++){
        	purchaseCount.put(i, 0);
        }
        return makePurchase();
    }

    static int makePurchase(){
    	
    	int cost = 0;
    	Integer personToPurchase = 0;
    	Integer minimumPurchase = flowersCount;
    	for(Map.Entry<Integer,Integer> item : purchaseCount.entrySet()){
    		if(minimumPurchase > item.getValue()){
    			minimumPurchase = item.getValue();
    			personToPurchase = item.getKey();
    		}
    	}    	
    	//which one to purchase
    	
    	Integer currentCount = purchaseCount.get(personToPurchase) + 1;
    	cost = (currentCount) * flowers.remove(0);
    	purchaseCount.replace(personToPurchase, currentCount);
    	if(flowers.isEmpty()){
    		return cost;
    	}
    	return cost + makePurchase();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int minimumCost = getMinimumCost(n, k, c);
        System.out.println(minimumCost);
    }
}
