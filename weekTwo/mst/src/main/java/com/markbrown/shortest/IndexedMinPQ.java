package com.markbrown.shortest;

public class IndexedMinPQ<K extends Comparable<K>> {
    
    private int[] queue;
    private int[] pos;
    private K[] keys;
    private int currIndex;
    private int maxSize;

    public IndexedMinPQ(int maxSize) {
        this.queue = new int[maxSize];
        this.pos = new int[maxSize];
        this.keys = (K[]) new Comparable[maxSize];
        this.maxSize = maxSize;

        for (int i = 0; i < maxSize; i++) {
            pos[i] = -1;
        }
    }

    private void swim(int i) {
        while (i != 0 && (i - 1) / 2 >= 0) {
            int j = (i - 1) / 2;
            if (keys[queue[j]].compareTo(keys[queue[i]]) > 0) {
                int temp = queue[i];
                queue[i] = queue[j];
                queue[j] = temp;

                pos[queue[i]] = i;
                pos[queue[j]] = j;

                i = j;
            } else break;
        }
    }

    private void sink(int i) {
        while ((i * 2) + 1 < currIndex) {
            int j = (i * 2) + 1;
            if (j + 1 < currIndex && keys[queue[j]].compareTo(keys[queue[j + 1]]) > 0) j++;
            if (keys[queue[i]].compareTo(keys[queue[j]]) > 0) {
                int temp = queue[i];
                queue[i] = queue[j];
                queue[j] = temp;

                pos[queue[i]] = i;
                pos[queue[j]] = j;

                i = j;
            } else break;
        }
    }

    public void insert(int i, K key) {
        if (i >= maxSize) throw new IllegalArgumentException();
        if (contains(i)) throw new IllegalArgumentException("Element already in queue");
        queue[currIndex] = i;
        pos[i] = currIndex;
        keys[i] = key;
        currIndex++;
        swim(pos[i]);
    }

    public int deleteMin() {
        if (currIndex == 0) return -1;
        int min = queue[0];
        queue[0] = queue[--currIndex];
        queue[currIndex] = 0;
        pos[min] = -1;
        pos[queue[0]] = currIndex == 0 ? -1 : 0;
        keys[min] = null;
        sink(0);
        return min;
    }

    public void decreaseKey(int i, K key) {
        if (!contains(i)) throw new IllegalArgumentException("Element not present in queue");
        keys[i] = key;
        swim(pos[i]);
    }

    public boolean contains(int i) {
        return pos[i] != -1;
    }

    public int size() {
        return currIndex;
    }

    public boolean isEmpty() {
        return currIndex == 0;
    }

}