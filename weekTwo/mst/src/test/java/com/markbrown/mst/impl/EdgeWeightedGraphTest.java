package com.markbrown.mst.impl;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EdgeWeightedGraphTest {

    @Test
    public void testEdgeDirectedGraph() {

        // Setup
        EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
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
        graph.addEdge(new Edge(4, 7, 0.37));
        graph.addEdge(new Edge(0, 4, 0.38));
        graph.addEdge(new Edge(6, 2, 0.40));
        graph.addEdge(new Edge(3, 6, 0.52));
        graph.addEdge(new Edge(6, 0, 0.58));
        graph.addEdge(new Edge(6, 4, 0.93));

        assertEquals(8, graph.V(), 0);
        assertEquals(16, graph.E(), 0);

        List<Edge> allEdges = (List<Edge>) graph.edges();

        assertEquals(16, allEdges.size(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.16).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.17).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.19).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.26).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.28).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.29).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.32).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.34).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.35).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.36).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.37).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.38).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.40).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.52).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.58).count(), 0);
        assertEquals(1, allEdges.stream().filter(e -> e.weight() == 0.93).count(), 0);
        assertEquals(0, allEdges.stream().filter(e -> e.weight() == 1.00).count(), 0);

        List<Edge> zeroEdges = (List<Edge>) graph.adj(0);

        assertEquals(4, zeroEdges.size(), 0);
        assertEquals(1, zeroEdges.stream().filter(e -> e.weight() == 0.16).count(), 0);
        assertEquals(1, zeroEdges.stream().filter(e -> e.weight() == 0.26).count(), 0);
        assertEquals(1, zeroEdges.stream().filter(e -> e.weight() == 0.38).count(), 0);
        assertEquals(1, zeroEdges.stream().filter(e -> e.weight() == 0.58).count(), 0);
    }

}
