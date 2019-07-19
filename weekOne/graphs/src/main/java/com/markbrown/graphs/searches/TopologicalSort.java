package com.markbrown.graphs.searches;

import java.util.Stack;

import com.markbrown.graphs.impl.Digraph;

public class TopologicalSort {

    private Digraph digraph;
    private Stack<Integer> order;
    private boolean[] marked;

    public TopologicalSort(Digraph digraph) {
        this.digraph = digraph;
        this.order = new Stack<>();
        this.marked = new boolean[digraph.V()];
        for (int i = 0; i < digraph.V(); i++) {
            if (!this.marked[i]) {
                performSort(i);
            }
        }
    }

    public Iterable<Integer> getSort() {
        return this.order;
    }

    private void performSort(int v) {
        this.marked[v] = true;
        for (Integer w : this.digraph.adjacencyListAsIterable(v)) {
            if (!this.marked[w]) {
                performSort(w);
            }
        }
        this.order.push(v);
    }


}