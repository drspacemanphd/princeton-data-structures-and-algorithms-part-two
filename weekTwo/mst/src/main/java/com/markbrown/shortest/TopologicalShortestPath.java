package com.markbrown.shortest;

import java.util.Stack;

public class TopologicalShortestPath {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private int start;

    public TopologicalShortestPath(EdgeWeightedDigraph graph, int start) {
        this.distTo = new double[graph.V()];
        this.edgeTo = new DirectedEdge[graph.V()];
        this.start = start;

        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        distTo[start] = 0;

        TopologicalSort sortHelper = new TopologicalSort(graph);
        Stack<Integer> paths = sortHelper.sort();

        while (!paths.isEmpty()) {
            Integer i = paths.pop();
            for (DirectedEdge e : graph.adj(i)) {
                relax(e);
            }
        }

    }

    private void relax(DirectedEdge edge) {
        int v = edge.from(), w = edge.to();
        if (edge.weight() + distTo[v] < distTo[w]) {
            distTo[w] = distTo[v] + edge.weight();
            edgeTo[w] = edge;
        }
    }

    public boolean hasPath(int end) {
        return edgeTo[end] != null;
    }

    public Stack<Integer> path(int end) {
        if (!hasPath(end)) return null;
        Stack<Integer> path = new Stack<>();
        for (int i = end; edgeTo[i] != null; i = edgeTo[i].from()) {
            path.add(i);
        }
        path.add(start);
        return path;
    }
}