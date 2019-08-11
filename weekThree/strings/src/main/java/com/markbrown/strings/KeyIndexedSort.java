package com.markbrown.strings;

public class KeyIndexedSort {
    
    private KeyIndexedSort() {}

    // Cases are ignored
    public static String sort(String s, int r) {
        char[] sArr = s.toCharArray();
        char[] returnArr = new char[s.length()];
        int count[] = new int[r + 1];
        
        // Count frequency of characters
        for (int i = 0; i < sArr.length; i++) {
            count[radixConversion(sArr[i]) + 1]++;
        }

        // Apply addition function to counts to generate start indices for characters
        for (int i = 0; i < r; i++) {
            count[i + 1] += count[i]; 
        }

        // Sort chars into new char array
        for (int i = 0; i < sArr.length; i++) {
            returnArr[count[radixConversion(sArr[i])]++] = sArr[i];
        }

        return String.valueOf(returnArr);
    }

    private static int radixConversion(char c) {
        return c - 'a' < 0 ? c - 'A' : c - 'a';
    }
}

