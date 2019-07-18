package com.markbrown.graphs.searches;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import com.markbrown.graphs.impl.Graph;

public class PathsWithDFS implements Paths {

    private boolean[] marked;
    private int[] edgeTo;
    private int start;

    public PathsWithDFS(Graph g, int v) {
        if (v >= g.V()) throw new RuntimeException("Invalid starting vertex");
        start = v;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        dfs(g, start);
    }

    private void dfs(Graph g, int w) {
        marked[w] = true;
        Iterator<Integer> iter = g.adjacencyList(w);
        while (iter.hasNext()) {
            int v = iter.next();
            if (!marked[v]) {
                edgeTo[v] = w;
                dfs(g, v);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> path(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int i = v; i != start; i = edgeTo[i]) {
            path.push(i);
        }
        path.push(start);
        return path;
    }

}