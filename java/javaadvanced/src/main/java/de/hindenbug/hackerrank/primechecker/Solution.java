package de.hindenbug.hackerrank.primechecker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.*;

class Prime {

    public void checkPrime(int... numbers) {
        StringBuilder builder = new StringBuilder();
        for (int number : numbers) {
            if (isPrime(number)) {
                builder.append(number);
                builder.append(' ');
            }
        }
        String output = builder.length() > 0
                        ? builder.substring(0, builder.length() - 1)
                        : "";
        System.out.println(output);
    }

    private boolean isPrime(final int number) {

        if (number <= 1) return false;

        int i = 2;
        boolean isPrime = true;

        while (i <= number / 2 && isPrime) {
            isPrime = number % i != 0;
            i++;
        }

        return isPrime;
    }
}

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
