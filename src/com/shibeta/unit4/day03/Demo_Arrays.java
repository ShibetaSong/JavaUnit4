package com.shibeta.unit4.day03;

import java.util.Arrays;

public class Demo_Arrays {
    public static void main(String[] args) {
        int[] arr = {12, 51, 11, 17, 12};

        for (int a : arr) {
            System.out.println(a);
        }

        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.binarySearch(arr, 11));

        System.out.println(arr.length);
        arr = Arrays.copyOf(arr, 15);
        System.out.println(arr.length);
    }
}

