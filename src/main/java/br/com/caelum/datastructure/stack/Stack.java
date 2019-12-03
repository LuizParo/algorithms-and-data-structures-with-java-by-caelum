package br.com.caelum.datastructure.stack;

public interface Stack<E> {

    void addLast(E element);

    E removeLast();

    int size();

    boolean isEmpty();
}
