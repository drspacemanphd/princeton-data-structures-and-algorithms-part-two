package com.markbrown.shortest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class DijkstrasAlgorithmTest {

    @Test
    public void testDijkstras() {

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

        DijkstrasAlgorithm alg = new DijkstrasAlgorithm(graph, 0);

        Stack<Integer> shortestPathToOne = alg.shortestPath(1);
        assertEquals(2, shortestPathToOne.size(), 0);
        assertEquals(0, shortestPathToOne.pop(), 0);
        assertEquals(1, shortestPathToOne.pop(), 0);

        Stack<Integer> shortestPathToSix = alg.shortestPath(6);
        assertEquals(5, shortestPathToSix.size(), 0);
        assertEquals(0, shortestPathToSix.pop(), 0);
        assertEquals(4, shortestPathToSix.pop(), 0);
        assertEquals(5, shortestPathToSix.pop(), 0);
        assertEquals(2, shortestPathToSix.pop(), 0);
        assertEquals(6, shortestPathToSix.pop(), 0);

    }
}