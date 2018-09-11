package de.hindenbug.hackerrank.implementation;

import java.util.stream.IntStream;

public class Grading {

    static int[] solve(int[] grades){
        for (int i = 0; i < grades.length; i++) {
            int grade = grades[i];
            int rest = grade % 5;
            if (rest >= 3 && grade >= 38) {
                while (grade % 5 != 0) {
                    grade++;
                }
            }
            grades[i] = grade;
        }
        return grades;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] grades = new int[n];
//        for(int grades_i=0; grades_i < n; grades_i++){
//            grades[grades_i] = in.nextInt();
//        }
//        int[] result = solve(grades);
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
//        }
//        System.out.println("");
        print(solve(new int[]{73, 67, 38, 33}));
    }

    private static void print(final int[] ints) {
        IntStream.of(ints).forEach(i -> System.out.println(i));
    }
}