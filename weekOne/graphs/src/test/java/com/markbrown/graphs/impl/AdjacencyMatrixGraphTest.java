package com.markbrown.graphs.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AdjacencyMatrixGraphTest {

    private AdjacencyMatrixGraph graph;

    @Before
    public void setup() {
        graph = new AdjacencyMatrixGraph(4);
    }

    @Test
    public void testGraph() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        assertEquals(graph.V(), 4, 0);
        assertEquals(graph.E(), 4, 0);
        assertTrue(graph.edge(0, 1));
        assertTrue(graph.edge(1, 0));
        assertTrue(graph.edge(0, 3));
        assertTrue(graph.edge(3, 0));
        assertTrue(graph.edge(1, 2));
        assertTrue(graph.edge(2, 1));
        assertTrue(graph.edge(1, 3));
        assertTrue(graph.edge(3, 1));

        assertFalse(graph.edge(0, 2));
        assertFalse(graph.edge(2, 0));

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