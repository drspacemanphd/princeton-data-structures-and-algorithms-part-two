package com.markbrown.graphs.impl;

import java.util.Iterator;

public interface Graph {

    void addEdge(int vOne, int vTwo);

    boolean edge(int vOne, int vTwo);

    int V();

    int E();

    Iterator<Integer> adjacencyList(int v);

}