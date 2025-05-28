package ru.itis.inf403.test;

import java.lang.module.FindException;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class MathUtil {

    public static int sum(int a, int b){
        return a + b;
    }

    /**
     *
     * @param a
     * @param b
     * @return > 0 if a > b, < 0 if a < b, = 0 if a == b
     */

    public static boolean compare(int a, int b){
        if (a > b) return true;
        else if (a < b) return false;
        return false;
    }


    public static int divide(int a, int b){
        if (b == 0)
            throw new FindException("Знаменатель не 0!");
        return a / b;
    }

    public static int[] sort(int[] arr){
        // сортировка
        Arrays.sort(arr);
        return arr;
    }


}
