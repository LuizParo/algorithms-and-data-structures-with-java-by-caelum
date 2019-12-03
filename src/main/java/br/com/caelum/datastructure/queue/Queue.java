package br.com.caelum.datastructure.queue;

public interface Queue<E> {

    void addLast(E element);

    E removeFirst();

    int size();

    boolean isEmpty();
}
