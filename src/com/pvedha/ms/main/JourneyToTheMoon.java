package com.pvedha.ms.main;

import java.io.*;
import java.util.*;

public class JourneyToTheMoon {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int noOfAstros = in.nextInt();
        int countOfPairs = in.nextInt();
        //int[][] pairs = new int[countOfPairs][2];
        HashMap<Integer, Integer[]> pairs = new LinkedHashMap();
        for(int i=0;i<countOfPairs;i++){
            Integer left = in.nextInt();
            Integer right = in.nextInt();
            Integer[] pair = {left, right};
            pairs.put(i, pair);            
        }
        
        ArrayList<ArrayList<Integer>> countries = new ArrayList<ArrayList<Integer>>();
      
            
        while(countOfPairs > 0){
            ArrayList<Integer> astros = new ArrayList<Integer>();
           // System.out.println("Pairs at present " + pairs);            
            Iterator<Map.Entry<Integer,Integer[]>> iter = pairs.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Integer,Integer[]> item = iter.next(); 
            
                if(item.getValue() == null ) {
                    continue;
                }
                Integer[] pair = item.getValue();
                if(astros.size() == 0){
                    astros.add(pair[0]);
                    astros.add(pair[1]);
                }                  
                
               // System.out.println("Current Pair" + pair[0] + " " + pair[1]);
                if(astros.contains(pair[0]) && astros.contains(pair[1])){
                    iter.remove();
                    countOfPairs--;
                    continue;
                }
                if(astros.contains(pair[0])){
                    astros.add(pair[1]);
                    //pairs.setValue.remove(item.getKey());
                    //item.setValue(null);
                    iter.remove();
                    countOfPairs --;
                } else if(astros.contains(pair[1])){
                    astros.add(pair[0]);
                    //pairs.remove(item.getKey());
                    iter.remove();//item.setValue(null);
                    countOfPairs --;
                }
            }
            
            countries.add(astros);
        }
        
        Long combinations = 0L;
        Iterator<ArrayList<Integer>> cIter = countries.iterator();
        Integer countrySize = 0;
        Integer cumulativeSize = 0;
        if(cIter.hasNext()){
            countrySize = cIter.next().size();
            cumulativeSize = countrySize;
            //combinations = (long) countrySize;
            //System.out.println("CountrySize " + countrySize);
        }
        while(cIter.hasNext()){
            Integer currentSize = cIter.next().size();
            //System.out.println("current combinations  " + combinations + " countrySize " +  countrySize + " currentSize " + currentSize);
            combinations += cumulativeSize * currentSize;
            System.out.println("Combinations : " + combinations);
            //countrySize = currentSize;
            cumulativeSize += currentSize;
            //System.out.println("CountrySize " + countrySize + " combinations " + combinations);
        }
        Long leftOvers = (long) (noOfAstros - cumulativeSize);
        Long combinationsOfLeftOvers = leftOvers > 1 ? findCombinations((long)leftOvers) : 0L;
        System.out.println("cumulativeSize " + cumulativeSize + " " + leftOvers + " multiplied " + cumulativeSize * leftOvers);
        //System.out.println("findCombinations " + findCombinations(3));
        System.out.println("Combinations : " + combinations + " comb of leftovers " + combinationsOfLeftOvers);
        Long result = combinations + leftOvers * cumulativeSize + combinationsOfLeftOvers;
        System.out.println(result);
        
                
        
       //System.out.println("The countries " + countries);
        
        
        //Note: jumbled up astro numbers wont work. should be in series.
    }
    
    static Long findCombinations(Long count){
        Long result = (count * (count -1)/2);
        return result;
    }    
}
