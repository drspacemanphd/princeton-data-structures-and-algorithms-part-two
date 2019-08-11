package com.markbrown.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LSDTest {

    @Test
    public void testLsd() {

        String[] stringsInput = new String[] {
            "ZfAkssOJD",
            "bbermCalL",
            "BljfHaDBA",
            "hqtHqDFZA"
        };

        String[] sorted = LSD.sort(stringsInput, 26);

        assertEquals("bbermCalL", sorted[0]);
        assertEquals("BljfHaDBA", sorted[1]);
        assertEquals("hqtHqDFZA", sorted[2]);
        assertEquals("ZfAkssOJD", sorted[3]);

    }
}