package com.markbrown.graphs.quiz;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.markbrown.graphs.impl.AdjacencyListGraph;
import com.markbrown.graphs.impl.Graph;

import org.junit.Before;
import org.junit.Test;

public class DiameterTest {

    private Diameter diameter;

    @Before
    public void setup() {
        Graph g = new AdjacencyListGraph(10);
        g.addEdge(0, 1);
        g.addEdge(1, 6);
        g.addEdge(6, 7);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(4, 3);
        g.addEdge(3, 8);
        g.addEdge(3, 5);
        g.addEdge(5, 9);
        diameter = new Diameter(g);
    }

    @Test
    public void testThatLongestPathCanBeObtained() {
        
        Iterable<Integer> longestPath = diameter.getDiameter();
        List<Integer> list = (List<Integer>) longestPath;

        assertEquals(8, list.size(), 0);

        assertEquals(9, list.get(0), 0);
        assertEquals(5, list.get(1), 0);
        assertEquals(3, list.get(2), 0);
        assertEquals(4, list.get(3), 0);
        assertEquals(2, list.get(4), 0);        
        assertEquals(1, list.get(5), 0);
        assertEquals(6, list.get(6), 0);
        assertEquals(7, list.get(7), 0);
        
    }

}