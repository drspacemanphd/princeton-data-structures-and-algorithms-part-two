package com.markbrown.mst.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Queue;

import org.junit.Test;

public class KruskalPQTest {

    @Test
    public void testKruskal() {

        EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
        graph.addEdge(new Edge(6, 4, 0.93));
        graph.addEdge(new Edge(4, 7, 0.37));
        graph.addEdge(new Edge(0, 4, 0.38));
        graph.addEdge(new Edge(6, 2, 0.40));
        graph.addEdge(new Edge(3, 6, 0.52));
        graph.addEdge(new Edge(6, 0, 0.58));
        graph.addEdge(new Edge(0, 7, 0.16));
        graph.addEdge(new Edge(2, 3, 0.17));
        graph.addEdge(new Edge(1, 7, 0.19));
        graph.addEdge(new Edge(0, 2, 0.26));
        graph.addEdge(new Edge(5, 7, 0.28));
        graph.addEdge(new Edge(1, 3, 0.29));
        graph.addEdge(new Edge(1, 5, 0.32));
        graph.addEdge(new Edge(2, 7, 0.34));
        graph.addEdge(new Edge(4, 5, 0.35));
        graph.addEdge(new Edge(1, 2, 0.36));

        KruskalPQ kruskal = new KruskalPQ(graph);

        Queue<Edge> mst = kruskal.getMst();
        assertEquals(7, mst.size(), 0);

        Edge one = mst.remove();
        assertEquals(one.weight(), 0.16, 0);

        Edge two = mst.remove();
        assertEquals(two.weight(), 0.17, 0);

        Edge three = mst.remove();
        assertEquals(three.weight(), 0.19, 0);

        Edge four = mst.remove();
        assertEquals(four.weight(), 0.26, 0);

        Edge five = mst.remove();
        assertEquals(five.weight(), 0.28, 0);

        Edge six = mst.remove();
        assertEquals(six.weight(), 0.35, 0);

        Edge seven = mst.remove();
        assertEquals(seven.weight(), 0.40, 0);

        assertTrue(mst.isEmpty());

    }
}