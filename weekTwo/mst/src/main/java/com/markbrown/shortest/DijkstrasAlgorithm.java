package com.markbrown.shortest;

import java.util.Stack;

public class DijkstrasAlgorithm {

    private EdgeWeightedDigraph graph;
    private DirectedEdge[] edgeTo;
    private double[] dist;
    private IndexedMinPQ<Double> pq;
    private int start;

    public DijkstrasAlgorithm(EdgeWeightedDigraph graph, int start) {
        this.graph = graph;
        this.edgeTo = new DirectedEdge[graph.V()];
        this.dist = new double[graph.V()];
        this.pq = new IndexedMinPQ<>(graph.V());
        this.start = start;

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Double.POSITIVE_INFINITY;
        }

        dist[start] = 0;
        pq.insert(start, 0.0);

        while (!pq.isEmpty()) {
            int v = pq.deleteMin();
            for (DirectedEdge e : this.graph.adj(v)) {
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (dist[w] > e.weight() + dist[v]) {
            dist[w] = e.weight() + dist[v];
            edgeTo[w] = e;
            if (pq.contains(w)) pq.decreaseKey(w, dist[w]);
            else pq.insert(w, dist[w]);
        }
    }

    public Stack<Integer> shortestPath(int v) {
        Stack<Integer> path = new Stack<>();
        while (edgeTo[v] != null) {
            path.add(edgeTo[v].to());
            v = edgeTo[v].from();
        }
        path.add(start);
        return path;
    }

}