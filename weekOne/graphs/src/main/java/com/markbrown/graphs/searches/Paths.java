package com.markbrown.graphs.searches;

public interface Paths {

    boolean hasPathTo(int v);

    Iterable<Integer> path(int v);
    
}