package com.markbrown.mst.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Kruskal {

    private EdgeWeightedGraph graph;
    private List<Edge> edges; 
    private Queue<Edge> mst;

    public Kruskal(EdgeWeightedGraph graph) {
        this.graph = graph;
        this.edges = new ArrayList<>();
        this.mst = new ArrayDeque<>();
        for (Edge e : graph.edges()) {
            edges.add(e);
        }
        edges = MergeSort.sort(edges.toArray(new Edge[]{}));
        mst();
    }

    private void mst() {
        WeightedQuickUnion qu = new WeightedQuickUnion(graph.V());
        int currIndex = 0;
        while (currIndex < edges.size() && mst.size() < graph.V() - 1) {
            int v = edges.get(currIndex).either();
            int w = edges.get(currIndex).other(v);
            if (!qu.connected(v, w)) {
                mst.add(edges.get(currIndex));
                qu.union(v, w);
            }
            currIndex++;
        }
    }

    public Queue<Edge> getMst() {
        return this.mst;
    }


}

class MergeSort {

    public static <T extends Comparable<T>> List<T> sort(T[] arr) {
        T[] temp = (T[]) new Comparable[arr.length];
        _sort(arr, temp, 0, arr.length - 1);
        return Arrays.asList(arr);
    }
    
    private static <T extends Comparable<T>> void _sort(T[] list, T[] temp, int start, int end) {
        if (start >= end) return;

        int i = start;
        int j = start + ((end - start) / 2);
        int k = end;
        
        _sort(list, temp, i, j);
        _sort(list, temp, j + 1, k);
        merge(list, temp, i, j, k);
    }

    private static <T extends Comparable<T>> void merge(T[] list, T[] temp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = list[i];
        }

        int i = start;
        int j = mid + 1;

        for (int k = start; k <= end; k++) {
            if (i > mid) {
                list[k] = temp[j++];
            } else if (j > end) {
                list[k] = temp[i++];
            } else if (temp[i].compareTo(temp[j]) >= 0) {
                list[k] = temp[j++];
            } else {
                list[k] = temp[i++];
            }
        }

    }
}

class WeightedQuickUnion {

    private int[] elements;
    private int[] treeSize;

    public WeightedQuickUnion(int els) {
        elements = new int[els];
        for (int i = 0; i < els; i++) {
            elements[i] = i;
        }
        treeSize = new int[els];
        for (int i = 0; i < els; i++) {
            treeSize[i] = 1;
        }
    }

    private int root(int i) {
        while (i != elements[i]) i = elements[i];
        return i;
    }

    public void union(int i, int j) {
        int rootI = root(i);
        int rootJ = root(j);

        if (treeSize[rootI] >= treeSize[rootJ]) {
            elements[rootJ] = rootI;
            treeSize[rootI] += treeSize[rootJ];
        } else {
            elements[rootI] = rootJ;
            treeSize[rootJ] += treeSize[rootI];
        }
    }

    public boolean connected(int i, int j) {
        return root(i) == root(j);
    }
}

