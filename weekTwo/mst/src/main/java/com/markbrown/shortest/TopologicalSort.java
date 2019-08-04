package com.markbrown.shortest;

import java.util.Stack;

public class TopologicalSort {

    private EdgeWeightedDigraph graph;
    private boolean[] marked;
    private Stack<Integer> topOrder;

    public TopologicalSort(EdgeWeightedDigraph graph) {
        this.graph = graph;
        this.marked = new boolean[graph.V()];
        this.topOrder = new Stack<>();
        for (DirectedEdge v : graph.adj(0)) {
            if (!marked[v.from()]) sort(v.from());
        }
    }

    private void sort(int v) {
        marked[v] = true;
        for (DirectedEdge w : this.graph.adj(v)) {
            if (!marked[w.to()]) {
                sort(w.to());
            }
        }
        topOrder.push(v);
    }

    public Stack<Integer> sort() {
        return topOrder;
    }
}