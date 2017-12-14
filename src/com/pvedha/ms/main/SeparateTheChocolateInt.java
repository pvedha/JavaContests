package com.pvedha.ms.main;

import java.io.*;
import java.util.*;

public class SeparateTheChocolateInt {

    static int T=0;
    static int D=1;
    static int C=2;
    //static int VISITED=8;
    static char VISITED='V';
    static int ROWS;
    static int COLS;
    static int WIDTH;
    static void sop(String message){
        System.out.println(message);                                        
    }
	static void printArr(Integer arr[][]){
        for(int i=0;i<arr.length;i++){
            System.out.println("");
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        ROWS = in.nextInt();
        COLS = in.nextInt();
        int diff = in.nextInt();
        
        Integer bar[][] = new Integer[ROWS][COLS];
        copyBar = new Integer[ROWS][COLS];
        in.nextLine(); //just move to next line. horrible way.
        for(int i=0;i<ROWS;i++){
            String line = in.nextLine();            
            for(int j=0;j<COLS;j++){                
                char c = line.charAt(j);
                if(c == 'T'){
                    bar[i][j]= T;
                } else if(c == 'D'){
                    bar[i][j]= D;
                } else {
                    bar[i][j]= C;
                }                
            }            
        }
        in.close();
        WIDTH = ROWS*COLS;
        Double possibilities = Math.pow(2, WIDTH);    
        initVisitMap();
        for(int i=0;i<possibilities;i++){
            //String binaryString = Integer.toBinaryString(i);
            
            int count1s = Integer.bitCount(i);       
              
            if(Math.abs(WIDTH - 2*count1s) > diff ){
                continue; //more than the allowed diff
            }                        
            countDs = count1s;
            countTs = WIDTH - count1s;                     
            validateSplit(bar, i);          
            
        }        
        
        System.out.println(validSplits+"");        
    }
    
    static  boolean trial = false;
    
    static int validSplits = 0;
    static int countTs, countDs;
    static Integer[][] copyBar;
    static void validateSplit(Integer arr[][],Integer val){          
        //is it possible to convert arr[][] into bits and a number and XOR with val?  
         String bs = Integer.toBinaryString(val);
        sb = new StringBuffer(String.format("%0" + (WIDTH - bs.length() + 1) + "d%s", 0, bs).substring(1));
        for(int i=0;i<ROWS;i++){     
            for(int j=0;j<COLS;j++){
                int bit = val%2;
                val/=2;                
                if(arr[i][j] == bit || arr[i][j] == C){  //still scope to reduce? can do XOR as T and D are 1 0
                    copyBar[i][j] = bit;
                    continue;
                }                
                return;                         
            }            
        }
        
        validateConnectivity();                    
    }
    
    static HashMap<Integer,ArrayList<Integer>> visitMap = new LinkedHashMap<>();
	static StringBuffer sb = new StringBuffer();
	static void initVisitMap(){
		for(int i=0;i<WIDTH;i++){
			ArrayList<Integer> nodes = new ArrayList<>();
			if(i+COLS < WIDTH){
				nodes.add(i+COLS);
			}
			if(i-COLS >= 0){
				nodes.add(i-COLS);
			}
			if(i%COLS !=0 && i-1 >= 0){
				nodes.add(i-1);
			}
			if(i%COLS != COLS-1 && i+1 < WIDTH){
				nodes.add(i+1);
			}
			visitMap.put(i, nodes);			
		}
	}
	
     
    
    static int visits = 0;
    static void validateConnectivity(){
        
        if(!validate4Square()){             
            return;
        }        
        
        //find first occurance 1 and then 0. //can do it at creation of copyBar, check if overloaded if conditions. 
        Integer currentRow = 0;
        Integer currentCol = 0;
        
        //shall find currentRow1 and currentRow0 at one stretch? or better whatever at 0,0 first and other later :D
        
        int bit = copyBar[currentRow][currentCol];
        visits = 0;       
        char bitChar = bit == 1 ? '1' : '0';
        visit(currentRow * ROWS + currentCol, bitChar);
        int count = bit == T ? countTs : countDs;
        sop("Visits = " + visits + " Count " +  count);
        if(visits < count){
            return;
        }
        if(bit == T){
            count = countDs;
            bit = D;
        } else {
            count = countTs;
            bit = T;
        }          
        
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(copyBar[i][j] == bit){
                    currentRow = i;
                    currentCol = j;
                    break;
                }
            }
            if(currentRow != 0){ //see just currentRow itself sufficient
                break;   //go for next step here and return at first failure???   //not a big deal, looks pathetic.  
            }
        }
        if(currentRow != 0){
            visits = 0;       
            bitChar = bit ==  1 ? '1' : '0';
            visit(currentRow * ROWS + currentCol, bitChar);
            sop("Visits = " + visits + " Count " +  count);
            if(visits < count){
                return;
            }
        }      
        //return true;
        validSplits++;
    }   
    
    static boolean validate4Square(){
        for(int i=0;i<ROWS-1;i++){ //needs optimization
            for(int j=0;j<COLS-1;j++){
                int bit = copyBar[i][j];
                int sum = copyBar[i+1][j] + copyBar[i][j+1] + copyBar[i+1][j+1]; //logic machi logic!!!!
                if(bit * 3  == sum){
                    return false;
                }
            }
        }
        return true;
    }  
        
    static void visit(int pos, char bit){
       sop("Visiting : " + pos + " for char " + bit + " sb " + sb);
		//if (sb.charAt(pos) == bit) {
			sb.setCharAt(pos, VISITED);
			visits++;
			for(Integer position : visitMap.get(pos)){
				if(sb.charAt(position) == bit) visit(position, bit);
			}
		//}
	}  
    /*
    Tried passing as parameter arr[][] instead of having in static memory. No difference found. 
    
    */
}
