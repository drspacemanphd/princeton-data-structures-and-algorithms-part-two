package com.markbrown.shortest;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {

    private List<DirectedEdge>[] list;
    private List<DirectedEdge> edges;
    private int vertices;

    public EdgeWeightedDigraph(int vertices) {
        this.list = new List[vertices];
        for (int i = 0; i < vertices; i++) {
            this.list[i] = new ArrayList<>();
        }
        this.edges = new ArrayList<>();
        this.vertices = vertices;
    }

    public void addEdge(DirectedEdge e) {
        this.list[e.from()].add(e);
        this.edges.add(e);
    }

    public int E() {
        return this.edges.size();
    }

    public int V() {
        return this.vertices;
    }

    public Iterable<DirectedEdge> edges() {
        return this.edges;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return this.list[v];
    }

}