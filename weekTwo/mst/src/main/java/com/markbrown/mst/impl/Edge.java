package com.markbrown.mst.impl;

public class Edge implements Comparable<Edge> {

    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
         return v;
    }

    public int other(int i) {
        if (i == v) return w;
        else if (i == w) return v;
        else throw new RuntimeException("Provided index not part of edge");
    }

    @Override
    public int compareTo(Edge o) {
        if (o.weight > this.weight) return -1;
        else if (o.weight < this.weight) return 1;
        return 0;
    }

    public double weight() { return this.weight; }

}
