package com.markbrown.graphs.quiz;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import com.markbrown.graphs.impl.Graph;

public class Diameter {

    private Graph g;

    public Diameter(Graph g) {
        this.g = g;
    }

    public Iterable<Integer> getDiameter() {
        int pathLength = 0;
        List<Integer> diameter = new ArrayList<>();

        for (int i = 0; i < g.V(); i++) {
            List<Integer> path = getPath(i);
            if (path.size() > pathLength) {
                pathLength = path.size();
                diameter = path;
            }
        }

        return diameter;
    }

    private List<Integer> getPath(int v) {
        boolean[] marked = new boolean[g.V()];
        int[] distTo = new int[g.V()];
        int[] edgeTo = new int[g.V()];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        int dist = 1;
        int lastMarked = v;

        while (!queue.isEmpty()) {

            int w = queue.remove();
            
            Iterator<Integer> iter = g.adjacencyList(w);

            while (iter.hasNext()) {
                int x = iter.next();
                if (!marked[x]) {
                    marked[x] = true;
                    distTo[x] = dist;
                    edgeTo[x] = w;
                    lastMarked = x;
                    queue.add(x);
                }
            }

            dist++;

        }

        List<Integer> set = new ArrayList<>();

        for (int i = lastMarked; i != v; i = edgeTo[i]) {
            set.add(i);
        }

        set.add(v);

        return set;
        
    }


}