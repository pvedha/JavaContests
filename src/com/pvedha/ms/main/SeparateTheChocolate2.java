package com.pvedha.ms.main;

import java.io.*;
import java.util.*;

public class SeparateTheChocolate2 {

    static int T=0;
    static int D=1;
    static int C=2;
    static int VISITED=8;
    static int ROWS;
    static int COLS;
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
        Integer width = ROWS*COLS;
        Double possibilities = Math.pow(2, width);        
        for(int i=0;i<possibilities;i++){
            //String binaryString = Integer.toBinaryString(i);
            
            int count1s = Integer.bitCount(i);       
              
            if(Math.abs(width - 2*count1s) > diff ){
                continue; //more than the allowed diff
            }                        
            countDs = count1s;
            countTs = width - count1s;
            //if(!validate4Square(Integer.toBinaryString(i))){
              //  continue;
            //}            
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
    
    
    
    static void visit(int row, int col, int bit){
        //if(copyBar[row][col] == VISITED){
          //  return;
        //}
        if(copyBar[row][col] == bit){
            copyBar[row][col] = VISITED;
            visits++;    
            if(row + 1 < ROWS && copyBar[row + 1][col] != VISITED){ //visit down
                visit(row + 1, col, bit);
            }
            if(row - 1 >= 0 && copyBar[row-1][col] != VISITED){ //visit up
                visit(row - 1, col, bit);
            }
            if(col -1 >= 0  && copyBar[row][col -1] != VISITED){ //visit left
                visit(row, col -1, bit);
            }
            if(col + 1 < COLS && copyBar[row][col + 1] != VISITED){ //visit right
                visit(row, col + 1, bit);
            }
        }    
        return;
    }
    
    static int visits = 0;
    static void validateConnectivity(){
        
        if(!validate4Square()){             
            return;
        }        
        
        //find first occurance 1 and then 0. //can do it at creation of copyBar, check if overloaded if conditions. 
        Integer currentRow = 0;
        Integer currentCol = 0;
        
        int bit = copyBar[currentRow][currentCol];
        visits = 0;       
        visit(currentRow, currentCol, bit);
        int count = bit == T ? countTs : countDs;        
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
            visit(currentRow, currentCol, bit);  
            if(visits < count){
                return;
            }
        }      
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
    
    
    //this needs optimization case 10 fails
    static boolean validate4Square(String bs){//Integer x){
            //String bs = Integer.toBinaryString(x);
            bs = String.format("%0"+ (ROWS*COLS - bs.length() + 1)+"d%s",0 ,bs).substring(1);             
            
        int length = bs.length() - COLS -1;
		int WIDTH = COLS;
		for(int i=0;i<length;i++){
			if(i%WIDTH == WIDTH -1){
                continue; //rather shall do i++?? no damn, last of the last fails??
            }
            
            String square = bs.substring(i, i+2) + bs.substring(WIDTH+i, WIDTH+i+2);
            if(square.contentEquals("0000") || square.contentEquals("1111")){
                return false;
            }
		}
        return true;
        
    }
    
    /*
    Tried passing as parameter arr[][] instead of having in static memory. No difference found. 
    
    */
}
