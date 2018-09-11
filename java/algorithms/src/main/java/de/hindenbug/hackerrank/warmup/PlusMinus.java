package de.hindenbug.hackerrank.warmup;

import java.util.*;

public class PlusMinus {

    static void plusMinus(int[] arr) {
        float positives = 0;
        float negatives = 0;
        float zeros = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                positives++;
            else if (arr[i] == 0)
                zeros++;
            else if (arr[i] < 0)
                negatives++;
        }
        System.out.println(positives / arr.length);
        System.out.println(negatives / arr.length);
        System.out.println(zeros / arr.length);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }
}