package com.pvedha.HackerRank.ProjectEuler;

import java.util.Scanner;

public class E6SumSquareDifference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            Long sum =0L;
            Long sumOfSquares = 0L;
            for(int i =1; i<=n; i++){
                sumOfSquares += i*i;
                sum += i;
            }
            System.out.println((sum*sum) - sumOfSquares);
        }
    }

}
