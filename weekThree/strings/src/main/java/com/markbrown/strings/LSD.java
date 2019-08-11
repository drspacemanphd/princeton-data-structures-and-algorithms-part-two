package com.markbrown.strings;

import java.util.Arrays;

public class LSD {

    public static String[] sort(String[] arr, int r) {
        if (arr.length == 0) return new String[0];
        if (Arrays.stream(arr).map(s -> s.length()).distinct().count() > 1) throw new RuntimeException("Cannot perform least significant digits sorting on strings with different lengths!");

        String[] aux = new String[arr.length];

        // Perform Key-Indexed Sorting for each character in strings, starting with least significant digit 
        for (int d = arr[0].length() - 1; d >= 0; d--) {

            int[] count = new int[r + 1];

            for (int i = 0; i < arr.length; i++) {
                count[radixConversion(arr[i].charAt(d)) + 1]++;
            }

            for (int i = 0; i < r; i++) {
                count[i + 1] += count[i];
            }

            for (int i = 0; i < arr.length; i++) {
                aux[count[radixConversion(arr[i].charAt(d))]++] = arr[i];
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = aux[i];
            }

        }

        return arr;
    }

    private static int radixConversion(char c) {
        return c - 'a' < 0 ? c - 'A' : c - 'a';
    }
}