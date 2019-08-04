package com.markbrown.shortest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndexedMinPQTest {

    @Test
    public void testMinQ() {
        IndexedMinPQ<Double> pq = new IndexedMinPQ<>(10);
        pq.insert(0, 5.0);
        pq.insert(1, 15.0);
        pq.insert(2, 4.0);
        pq.insert(3, 1.0);
        pq.insert(4, 10.0);
        pq.decreaseKey(4, 0.5);
        pq.decreaseKey(1, 3.0);

        assertEquals(4, pq.deleteMin(), 0);
        assertEquals(3, pq.deleteMin(), 0);
        assertEquals(1, pq.deleteMin(), 0);
        assertEquals(2, pq.deleteMin(), 0);
        assertEquals(0, pq.deleteMin(), 0);
        assertEquals(-1, pq.deleteMin(), 0);
    }
}