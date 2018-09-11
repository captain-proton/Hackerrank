package de.hindenbug.hackerrank.warmup;

import java.util.*;

public class DiagonalDifference {

    static int diagonalDifference(int[][] a) {
        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < a.length; i++) {
            d1 += a[i][i];
            d2 += a[a.length - 1 - i][i];
        }

        return Math.abs(d1 - d2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for(int a_i = 0; a_i < n; a_i++){
            for(int a_j = 0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }
}
