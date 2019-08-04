package com.markbrown.shortest;

public class DirectedEdge {

    private int from;
    private int to;
    private double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int from() { return this.from; }

    public int to() { return this.to; }

    public double weight() { return this.weight; }

}