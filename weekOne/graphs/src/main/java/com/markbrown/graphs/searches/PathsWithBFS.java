package com.markbrown.graphs.searches;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

import com.markbrown.graphs.impl.Graph;

public class PathsWithBFS implements Paths {

    private boolean[] marked;
    private int[] edgeTo;
    private int start;

    public PathsWithBFS(Graph g, int start) {
        this.start = start;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        bfs(g, start);
    }

    private void bfs(Graph g, int v) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        marked[v] = true;

        while (!queue.isEmpty()) {

            int w = queue.remove();
            Iterator<Integer> iter = g.adjacencyList(w);

            while (iter.hasNext()) {
                int x = iter.next();
                if (!marked[x]) {
                    marked[x] = true;
                    edgeTo[x] = w;
                    queue.add(x);
                }
            }

        }

    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> path(int v) {
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != this.start; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(this.start);
        return stack;
    }
    
}