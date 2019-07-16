package com.markbrown.graphs.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AdjacencyMatrixGraph {

    private int[][] matrix;
    private int edges;

    public AdjacencyMatrixGraph(int dimension) {
        matrix = new int[dimension][dimension];
    }

    public void addEdge(int vOne, int vTwo) {
        if (vOne > matrix[0].length || vTwo > matrix[0].length) throw new RuntimeException("Specified vertex does not exist in graph");
        matrix[vOne][vTwo] = 1;
        matrix[vTwo][vOne] = 1;
        edges++;
    }
    
    public boolean edge(int vOne, int vTwo) {
        return matrix[vOne][vTwo] == 1 && matrix[vTwo][vOne] == 1;
    }

    public int V() {
        return matrix[0].length;
    }

    public int E() {
        return edges;
    }

    public Iterator<Integer> adjacencyList(int v) {
        
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix[v].length; i++) {
            if (matrix[v][i] == 1) {
                list.add(i);
            }
        }

        return new Iterator<Integer>() {

            private List<Integer> itList = list;
            private int index = 0;

            public boolean hasNext() {
                return index < itList.size();
            }

            public Integer next() {
                return itList.get(index++);
            }

        };
    }

 }