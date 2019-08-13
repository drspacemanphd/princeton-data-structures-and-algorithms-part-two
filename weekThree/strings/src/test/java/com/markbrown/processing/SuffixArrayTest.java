package com.markbrown.processing;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class SuffixArrayTest {

    @Test
    public void testSubStrings() {

        String text = "abcdhjsabshdabc";
        SuffixArray suffixArray = new SuffixArray(text);

        List<Integer> indices = suffixArray.findAllOccurrences("abc");

        assertEquals(2, indices.size(), 0);
        assertEquals(0, indices.get(1), 0);
        assertEquals(1, indices.get(0), 0);
        
    }
}