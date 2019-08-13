package com.markbrown.processing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuffixArray {

    private String[] suffixArr;

    public SuffixArray(String text) {
        suffixArr = new String[text.length()];
        for (int i = 0; i < suffixArr.length; i++) {
            suffixArr[i] = text.substring(i);
        }
        Arrays.sort(suffixArr);
    }

    public List<Integer> findAllOccurrences(String input) {
        List<Integer> indices = new ArrayList<>();
        findOccurrence(indices, input, 0, suffixArr.length - 1);
        return indices;
    }

    private void findOccurrence(List<Integer> occurrences, String input, int start, int end) {
        if (start > end) return;
        
        int mid = start + ((end - start) / 2);
        if (isSubstring(input, mid)) {
            occurrences.add(mid);
            findOccurrence(occurrences, input, start, mid - 1);
            findOccurrence(occurrences, input, mid + 1, end);
        } else {
            if (suffixArr[mid].compareTo(input) > 0) findOccurrence(occurrences, input, start, mid -1);
            else findOccurrence(occurrences, input, mid + 1, end);
        }
        
    }

    private boolean isSubstring(String input, int index) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != (suffixArr[index].charAt(i))) return false;
        } return true;
    }


}