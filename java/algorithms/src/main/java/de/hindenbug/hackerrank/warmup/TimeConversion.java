package de.hindenbug.hackerrank.warmup;

import java.util.*;
import java.text.*;

public class TimeConversion {

    static String timeConversion(String s) {
        SimpleDateFormat src = new SimpleDateFormat("hh:mm:ssa");
        SimpleDateFormat dst = new SimpleDateFormat("HH:mm:ss");
        try {
            Date date = src.parse(s);
            return dst.format(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        String result = timeConversion(s);
        System.out.println(result);
    }
}