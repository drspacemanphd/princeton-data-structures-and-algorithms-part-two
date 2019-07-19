package com.markbrown.graphs.searches;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.markbrown.graphs.impl.Digraph;

import org.junit.Before;
import org.junit.Test;

public class StrongComponentsTest {

    private Digraph digraph;
    private StrongComponents strongComponents;

    @Before
    public void setup() {
        digraph = new Digraph(13);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 5);
        digraph.addEdge(2, 0);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 2);
        digraph.addEdge(3, 5);
        digraph.addEdge(4, 2);
        digraph.addEdge(4, 3);
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
        strongComponents = new StrongComponents(digraph);
    }

    @Test
    public void testThatStrongComponentsCanBeIdentified() {
        
        assertEquals(5, strongComponents.strongComponents(), 0);

        assertTrue(strongComponents.stronglyConnected(0, 2));
        assertTrue(strongComponents.stronglyConnected(0, 3));
        assertTrue(strongComponents.stronglyConnected(0, 4));
        assertTrue(strongComponents.stronglyConnected(0, 5));
        assertTrue(strongComponents.stronglyConnected(2, 3));
        assertTrue(strongComponents.stronglyConnected(2, 4));
        assertTrue(strongComponents.stronglyConnected(2, 5));
        assertTrue(strongComponents.stronglyConnected(3, 4));
        assertTrue(strongComponents.stronglyConnected(3, 5));
        assertTrue(strongComponents.stronglyConnected(4, 5));

        assertTrue(strongComponents.stronglyConnected(6, 8));

        assertTrue(strongComponents.stronglyConnected(9, 10));
        assertTrue(strongComponents.stronglyConnected(9, 11));
        assertTrue(strongComponents.stronglyConnected(9, 12));
        assertTrue(strongComponents.stronglyConnected(10, 11));
        assertTrue(strongComponents.stronglyConnected(10, 12));
        assertTrue(strongComponents.stronglyConnected(11, 12));

    }
}