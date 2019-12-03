package br.com.caelum.datastructure.queue.impl;

import br.com.caelum.datastructure.list.impl.LinkedList;

public class Queue<E> implements br.com.caelum.datastructure.queue.Queue<E> {
    private final LinkedList<E> linkedList = new LinkedList<>();

    @Override
    public void addLast(E element) {
        linkedList.addLast(element);
    }

    @Override
    public E removeFirst() {
        return linkedList.removeFirst();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.size() == 0;
    }
}
