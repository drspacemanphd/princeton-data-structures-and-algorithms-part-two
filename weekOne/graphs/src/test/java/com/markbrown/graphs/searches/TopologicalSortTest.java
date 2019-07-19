package com.markbrown.graphs.searches;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import com.markbrown.graphs.impl.Digraph;

import org.junit.Before;
import org.junit.Test;

public class TopologicalSortTest {

    private Digraph digraph;
    private TopologicalSort sort;

    @Before
    public void setup() {
        digraph = new Digraph(7);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 2);
        digraph.addEdge(0, 5);
        digraph.addEdge(1, 4);
        digraph.addEdge(3, 2);
        digraph.addEdge(3, 4);
        digraph.addEdge(3, 5);
        digraph.addEdge(3, 6);
        digraph.addEdge(5, 2);        
        digraph.addEdge(6, 4);
        sort = new TopologicalSort(digraph);
    }

    @Test
    public void testTopologicalSortCanBePerformed() {
        
        Stack<Integer> stack = (Stack<Integer>) sort.getSort();

        assertEquals(7, stack.size());

        assertEquals(3, stack.pop(), 0);
        assertEquals(6, stack.pop(), 0);
        assertEquals(0, stack.pop(), 0);
        assertEquals(5, stack.pop(), 0);
        assertEquals(2, stack.pop(), 0);
        assertEquals(1, stack.pop(), 0);
        assertEquals(4, stack.pop(), 0);
        
    }
}