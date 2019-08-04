package com.markbrown.shortest;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class TopologicalSortTest {

    @Test
    public void testSort() {

        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(8);
        graph.addEdge(new DirectedEdge(0, 1, 5));
        graph.addEdge(new DirectedEdge(0, 7, 8));
        graph.addEdge(new DirectedEdge(0, 4, 9));
        graph.addEdge(new DirectedEdge(1, 3, 15));
        graph.addEdge(new DirectedEdge(1, 7, 4));
        graph.addEdge(new DirectedEdge(1, 2, 12));
        graph.addEdge(new DirectedEdge(2, 3, 3));
        graph.addEdge(new DirectedEdge(2, 6, 11));
        graph.addEdge(new DirectedEdge(3, 6, 9));
        graph.addEdge(new DirectedEdge(4, 7, 5));
        graph.addEdge(new DirectedEdge(4, 5, 4));
        graph.addEdge(new DirectedEdge(4, 6, 20));
        graph.addEdge(new DirectedEdge(5, 2, 1));
        graph.addEdge(new DirectedEdge(5, 6, 13));
        graph.addEdge(new DirectedEdge(7, 2, 7));
        graph.addEdge(new DirectedEdge(7, 5, 6));

        TopologicalSort sortHelper = new TopologicalSort(graph);

        Stack<Integer> sortedPath = sortHelper.sort();
        
        assertEquals(0, sortedPath.pop(), 0);
        assertEquals(4, sortedPath.pop(), 0);
        assertEquals(1, sortedPath.pop(), 0);
        assertEquals(7, sortedPath.pop(), 0);
        assertEquals(5, sortedPath.pop(), 0);
        assertEquals(2, sortedPath.pop(), 0);
        assertEquals(3, sortedPath.pop(), 0);
        assertEquals(6, sortedPath.pop(), 0);

    }
}