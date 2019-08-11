package com.markbrown.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KeyIndexedSortTest {
    
    @Test
    public void testStringSort() {
        String test = "gDjWaBalPf";

        String sorted = KeyIndexedSort.sort(test, 26);
        assertEquals("aaBDfgjlPW", sorted);        
    }
    
}