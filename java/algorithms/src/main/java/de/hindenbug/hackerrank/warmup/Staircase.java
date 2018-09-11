package de.hindenbug.hackerrank.warmup;

import java.util.*;

public class Staircase {

    static void staircase(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char c = col >= n - 1 - row ? '#' : ' ';
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        staircase(n);
        in.close();
    }
}
