package com.markbrown.graphs.searches;

import java.util.Iterator;

import com.markbrown.graphs.impl.Graph;

public class GraphConnectivity {

    private boolean[] marked;
    private int id[];
    private int count; 

    public GraphConnectivity(Graph g) {
        marked = new boolean[g.V()];
        id = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if (!marked[i]) {
                dfs(g, i);
                count++;
            }
        }
    }

    private void dfs(Graph g, int v) {

        marked[v] = true;
        id[v] = count;

        Iterator<Integer> iter = g.adjacencyList(v);

        while (iter.hasNext()) {
            int w = iter.next();
            if (!marked[w]) {
                dfs(g, w);
            }
        }

    }

    public int count() {
        return count;
    }

    public int index(int vertice) {
        return id[vertice];
    }

    public boolean connected(int i, int j) {
        return id[i] == id[j];
    }

}