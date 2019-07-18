package com.markbrown.graphs.searches;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.markbrown.graphs.impl.AdjacencyListGraph;
import com.markbrown.graphs.impl.Graph;

import org.junit.Before;
import org.junit.Test;

public class PathsWithBFSTest {

    private Graph graph;
    private PathsWithBFS paths;

    @Before
    public void setup() {
        graph = new AdjacencyListGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(5, 4);
    }

    @Test
    public void testPathFromZero() {

        paths = new PathsWithBFS(graph, 0);

        assertTrue(paths.hasPathTo(1));
        assertTrue(paths.hasPathTo(3));
        assertTrue(paths.hasPathTo(2));
        assertFalse(paths.hasPathTo(4));
        assertFalse(paths.hasPathTo(5));

        Iterator<Integer> pathFromZeroToThree = paths.path(3).iterator();
        List<Integer> list = new ArrayList<>();

        while (pathFromZeroToThree.hasNext()) {
            list.add(pathFromZeroToThree.next());
        }

        assertTrue(list.contains(3));
        assertTrue(list.contains(1));
        assertTrue(list.contains(0));

        assertFalse(list.contains(2));
        assertFalse(list.contains(5));
        assertFalse(list.contains(4));
    }

    @Test
    public void testPathFromFour() {

        paths = new PathsWithBFS(graph, 4);

        assertTrue(paths.hasPathTo(5));
        assertFalse(paths.hasPathTo(0));
        assertFalse(paths.hasPathTo(1));
        assertFalse(paths.hasPathTo(2));
        assertFalse(paths.hasPathTo(3));

        Iterator<Integer> pathFromZeroToThree = paths.path(5).iterator();
        List<Integer> list = new ArrayList<>();

        while (pathFromZeroToThree.hasNext()) {
            list.add(pathFromZeroToThree.next());
        }

        assertTrue(list.contains(4));
        assertTrue(list.contains(5));

        assertFalse(list.contains(0));
        assertFalse(list.contains(1));
        assertFalse(list.contains(2));
        assertFalse(list.contains(3));
    }

}