package edu.csu.leetcode.Top300;


import java.util.Iterator;
import java.util.LinkedList;

class PeekingIterator implements Iterator<Integer> {

    private LinkedList<Integer> queue;

    public PeekingIterator(Iterator<Integer> iterator) {
        queue = new LinkedList<>();
        while (iterator.hasNext()) {
            queue.add(iterator.next());
        }
    }

    public Integer peek() {
        return queue.peek();
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

