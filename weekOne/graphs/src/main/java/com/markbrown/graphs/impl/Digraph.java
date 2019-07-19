package com.markbrown.graphs.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Digraph implements Graph {

    private List<Integer>[] graph;
    private int edges;
    
    public Digraph(int vertices) {
        this.graph = new List[vertices];
        for (int i = 0; i < vertices; i++) {
            this.graph[i] = new ArrayList<>();
        }
    }

    private Digraph(List<Integer>[] graph, int edges) {
        this.graph = graph;
        this.edges = edges;
    }

    @Override
    public void addEdge(int vOne, int vTwo) {
        this.graph[vOne].add(vTwo);
        this.edges++;
    }

    @Override
    public boolean edge(int vOne, int vTwo) {
        return this.graph[vOne].contains(vTwo);
    }

    @Override
    public int V() {
        return this.graph.length;
    }

    @Override
    public int E() {
        return this.edges;
    }

    @Override
    public Iterator<Integer> adjacencyList(int v) {
        return this.graph[v].iterator();
    }

    public Iterable<Integer> adjacencyListAsIterable(int v) {
        return this.graph[v];
    }

    public Graph reverse() {
        List<Integer>[] newGraph = new List[this.graph.length];
        for (int i = 0; i < this.graph.length; i++) {
            newGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < this.graph.length; i++) {
            for (Integer v : this.graph[i]) {
                newGraph[v].add(i);
            }
        }

        return new Digraph(newGraph, this.edges);
    }


}