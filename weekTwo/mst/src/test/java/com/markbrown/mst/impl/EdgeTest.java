package com.markbrown.mst.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EdgeTest {

    private Edge edge;

    @Test
    public void testEdge() {

        // Test
        edge = new Edge(0, 3, 0.55);

        // Assert
        assertEquals(0, edge.either(), 0);
        assertEquals(0, edge.other(3),0);
        assertEquals(3, edge.other(0),0);
        assertEquals(0.55, edge.weight(), 0);

        Edge two = new Edge(1, 2, 0.44);
        assertEquals(1, edge.compareTo(two));

        Edge three = new Edge(1, 2, 66);
        assertEquals(-1, edge.compareTo(three));

        Edge four = new Edge(1, 4, 0.55);
        assertEquals(0, edge.compareTo(four));

    }

    @Test(expected = RuntimeException.class)
    public void testThatExceptionIsThrownIfVerticeThatIsNotInEdge() {

        // Test
        edge = new Edge(0, 3, 0.55);

        edge.other(5);
    }

}
