package com.markbrown.graphs.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AdjacencyListGraph implements Graph {

    private Set<Integer>[] verticesList;
    private int edges;

    public AdjacencyListGraph(int vertices) {
        verticesList = (Set<Integer>[]) new Set[vertices];
        for (int i = 0; i < vertices; i++) {
            verticesList[i] = new HashSet<Integer>();
        }
    }

    public void addEdge(int vOne, int vTwo) {
        verticesList[vOne].add(vTwo);
        verticesList[vTwo].add(vOne);
        edges++;
    }

    public boolean edge(int vOne, int vTwo) {
        return verticesList[vOne].contains(vTwo);
    }

    public int V() {
        return verticesList.length;
    }

    public int E() {
        return edges;
    }

    public Iterator<Integer> adjacencyList(int v) {
        return verticesList[v].iterator();
    }

}