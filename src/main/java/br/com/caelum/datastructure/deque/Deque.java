package br.com.caelum.datastructure.deque;

public interface Deque<E> {

    void addFirst(E element);

    void addLast(E element);

    E removeFirst();

    E removeLast();

    int size();
}
