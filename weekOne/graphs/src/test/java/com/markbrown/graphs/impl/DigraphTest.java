package com.markbrown.graphs.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DigraphTest {

    private Digraph digraph;

    @Before
    public void setup() {
        digraph = new Digraph(13);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 5);
        digraph.addEdge(2, 0);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 2);
        digraph.addEdge(3, 5);
        digraph.addEdge(4, 3);
        digraph.addEdge(4, 2);
        digraph.addEdge(5, 4);
        digraph.addEdge(6, 0);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 8);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);
        digraph.addEdge(7, 9);
        digraph.addEdge(8, 6);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(10, 12);
        digraph.addEdge(11, 4);
        digraph.addEdge(11, 12);
        digraph.addEdge(12, 9);
    }

    @Test
    public void testDigraph() {

        assertEquals(13, digraph.V());
        assertEquals(22, digraph.E());

        List<Integer> listOne = (List<Integer>) digraph.adjacencyListAsIterable(1);
        assertEquals(0, listOne.size());

        List<Integer> listTwo = (List<Integer>) digraph.adjacencyListAsIterable(2);
        assertEquals(2, listTwo.size());
        assertTrue(listTwo.contains(3));
        assertTrue(listTwo.contains(0));

        digraph.reverse();

        List<Integer> listThree = (List<Integer>) digraph.adjacencyListAsIterable(1);
        assertEquals(1, listThree.size());
        assertTrue(listThree.contains(0));

        List<Integer> listFour = (List<Integer>) digraph.adjacencyListAsIterable(2);
        assertEquals(2, listFour.size());
        assertTrue(listFour.contains(3));
        assertTrue(listFour.contains(4));

    }
}