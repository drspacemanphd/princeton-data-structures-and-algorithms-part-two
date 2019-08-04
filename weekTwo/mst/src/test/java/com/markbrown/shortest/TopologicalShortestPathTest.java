package com.markbrown.shortest;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class TopologicalShortestPathTest {

    @Test
    public void testShortestPath() {

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

        TopologicalShortestPath pathHelper = new TopologicalShortestPath(graph, 0);

        Stack<Integer> path = pathHelper.path(6);
        assertEquals(5, path.size());
        assertEquals(0, path.pop(), 0);
        assertEquals(4, path.pop(), 0);
        assertEquals(5, path.pop(), 0);
        assertEquals(2, path.pop(), 0);
        assertEquals(6, path.pop(), 0);
    }
}