package com.markbrown.mst.impl;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class KruskalPQ {

    private EdgeWeightedGraph graph;
    private Queue<Edge> mst;
    private MinPQ<Edge> minPQ;
    

    public KruskalPQ(EdgeWeightedGraph graph) {
        this.graph = graph;
        this.mst = new ArrayDeque<>();
        this.minPQ = new MinPQ<>();
        for (Edge e : graph.edges()) {
            minPQ.insert(e);
        }
        mst();
    }

    private void mst() {
        WeightedQU qu = new WeightedQU(graph.V());
        while (!minPQ.isEmpty() && mst.size() < graph.V() - 1) {
            Edge e = minPQ.deleteMin();
            int i = e.either();
            int j = e.other(i);
            if (!qu.connected(i, j)) {
                mst.add(e);
                qu.union(i, j);
            }
        } 
    }

    public Queue<Edge> getMst() {
        return mst;
    }


}

class MinPQ<T extends Comparable<T>> {

    private T[] arr;
    private int currIndex;

    public MinPQ() {
        arr = (T[]) new Comparable[32];
    }

    private void resize(int s, int e, int L) {
        T[] temp = (T[]) new Comparable[L];
        for (int i = 0; i + s < e; i++) {
            temp[i] = arr[i + s];
        }
        arr = temp;
    }

    private void swim(int v) {
        while (((v - 1) / 2) >= 0 && arr[v].compareTo(arr[(v - 1) / 2]) < 0) {
            T temp = arr[(v - 1) / 2];
            arr[(v - 1) / 2] = arr[v];
            arr[v] = temp;
            v = (v - 1) / 2;
        }
    }

    private void sink(int v) {
        while ((v * 2) + 1 < currIndex) {
            int i = (v * 2) + 1;
            if (i + 1 < currIndex && arr[i + 1].compareTo(arr[i]) < 0) i++;
            if (arr[i].compareTo(arr[v]) < 0) {
                T temp = arr[v];
                arr[v] = arr[i];
                arr[i] = temp;
                v = i;
            } else return;
        } 
    }

    public void insert(T data) {
        if (currIndex == arr.length) resize(0, currIndex, currIndex * 2);
        arr[currIndex++] = data;
        swim(currIndex - 1);
    }

    public T deleteMin() {
        if (currIndex == 0) return null;
        T min = arr[0];
        arr[0] = arr[--currIndex];
        arr[currIndex] = null;
        sink(0);
        return min;
    }

    public int size() {
        return currIndex;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}

class WeightedQU {

    private int[] elements;
    private int[] treeSizes;

    public WeightedQU(int els) {
        elements = new int[els];
        for (int i = 0; i < els; i++) {
            elements[i] = i;
        }
        treeSizes = new int[els];
        for (int i = 0; i < els; i++) {
            treeSizes[i] = 1;
        }
    }

    private int root(int i) {
        while (i != elements[i]) i = elements[i];
        return i;
    }

    public boolean connected(int i, int j) {
        return root(i) == root(j);
    }

    public void union(int i, int j) {
        int rootI = root(i);
        int rootJ = root(j);

        if (treeSizes[rootI] >= treeSizes[rootJ]) {
            elements[rootJ] = rootI;
            treeSizes[rootI] += treeSizes[rootJ];
        } else {
            elements[rootI] = rootJ;
            treeSizes[rootJ] += treeSizes[rootI];
        }
    }
}