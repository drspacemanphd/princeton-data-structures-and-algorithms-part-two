package com.markbrown.graphs.searches;

public class PathsWithDFS {

    private boolean[] marked;
    private int[] edgeTo;

    public PathsWithDFS(Graph g, int startVertice) {


    }

    private void dfs(Graph g, int w) {
        marked[w] = true;
        for (int v : g.adjacencyList(startVertice)) {
            if (!marked[v]) {
                edgeTo[v] = w;
                dfs(g, v);
            }
        }
    }
}