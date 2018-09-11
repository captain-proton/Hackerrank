package de.hindenbug.hackerrank.warmup;

import java.util.*;

public class MinMaxSum {

    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        long min = 0;
        long max = 0;
        for (int i = 0; i < 4 && i < arr.length; i++) {
            min += arr[i];
            max += arr[arr.length - 1 - i];
        }
        System.out.println(min + " " + max);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i = 0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        miniMaxSum(arr);
        in.close();
    }
}