package com.markbrown.graphs.searches;

import java.util.Stack;

import com.markbrown.graphs.impl.Digraph;

public class StrongComponents {

    private Digraph g;
    private Digraph reverseG;
    private boolean[] marked;
    private int[] components;
    private Stack<Integer> stack;
    private int count;

    public StrongComponents(Digraph g) {
        this.g = g;
        this.reverseG = (Digraph) g.reverse();
        this.marked = new boolean[g.V()];
        this.components = new int[g.V()];
        this.stack = new Stack<>();
        this.getStrongComponents();
    }

    public boolean stronglyConnected(int v, int w) {
        return this.components[v] == this.components[w];
    }

    public int strongComponents() {
        return count;
    }

    private void getStrongComponents() {
        this.topologicalSort(this.reverseG);
        this.marked = new boolean[g.V()];

        while (!this.stack.isEmpty()) {
            int i = stack.pop();
            if (!this.marked[i]) {
                dfs(i, this.count++);
            }
        }
    }

    private void topologicalSort(Digraph g) {
        for (int i = 0; i < g.V(); i++) {
            if (!this.marked[i]) {
                dfs(i);
            }
        }
    }

    private void dfs(int v) {
        this.marked[v] = true;
        for (Integer w : this.reverseG.adjacencyListAsIterable(v)) {
            if (!this.marked[w]) {
                dfs(w);
            }
        }
        stack.push(v);
    }

    private void dfs(int v, int count) {
        this.marked[v] = true;
        for (Integer w: this.g.adjacencyListAsIterable(v)) {
            if (!this.marked[w]) {
                dfs(w, count);
            }
        }
        this.components[v] = count;
    }

}