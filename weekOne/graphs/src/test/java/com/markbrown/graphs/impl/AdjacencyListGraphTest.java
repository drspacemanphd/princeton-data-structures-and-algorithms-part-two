package com.markbrown.graphs.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AdjacencyListGraphTest {

    private AdjacencyListGraph graph;

    @Before
    public void setup() {
        graph = new AdjacencyListGraph(4);
    }

    @Test
    public void testGraph() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        assertEquals(graph.V(), 4, 0);
        assertEquals(graph.E(), 4, 0);
        assertTrue(graph.connected(0, 1));
        assertTrue(graph.connected(1, 0));
        assertTrue(graph.connected(0, 3));
        assertTrue(graph.connected(3, 0));
        assertTrue(graph.connected(1, 2));
        assertTrue(graph.connected(2, 1));
        assertTrue(graph.connected(1, 3));
        assertTrue(graph.connected(3, 1));

        assertFalse(graph.connected(0, 2));
        assertFalse(graph.connected(2, 0));

        Iterator<Integer> iter = graph.adjacencyList(0);
        List<Integer> list = new ArrayList<>();

        while (iter.hasNext()) {
            list.add(iter.next());
        }

        assertTrue(list.contains(1));
        assertTrue(list.contains(3));
        assertFalse(list.contains(2));

    }

}