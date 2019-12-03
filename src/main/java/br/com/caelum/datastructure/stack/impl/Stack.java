package br.com.caelum.datastructure.stack.impl;

import br.com.caelum.datastructure.deque.Deque;
import br.com.caelum.datastructure.list.impl.LinkedList;

public class Stack<E> implements br.com.caelum.datastructure.stack.Stack<E> {
    private final Deque<E> list = new LinkedList<>();

    @Override
    public void addLast(E element) {
        list.addLast(element);
    }

    @Override
    public E removeLast() {
        return list.removeLast();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
