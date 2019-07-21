package com.markbrown.mst.impl;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {

    private List<Edge>[] list;
    private List<Edge> edges;

    public EdgeWeightedGraph(int vertices) {
        this.list = new List[vertices];
        this.edges = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            this.list[i] = new ArrayList<>();
        }
    }

    public void addEdge(Edge e) {
        this.list[e.either()].add(e);
        this.list[e.other(e.either())].add(e);
        this.edges.add(e);
    }

    public int V() {
        return this.list.length;
    }

    public int E() {
        return this.edges.size();
    }

    public Iterable<Edge> edges() {
        return this.edges;
    }

    public Iterable<Edge> adj(int v) {
        return this.list[v];
    }
}
