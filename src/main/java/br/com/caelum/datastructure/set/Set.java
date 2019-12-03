package br.com.caelum.datastructure.set;

import java.util.List;

public interface Set<E> {

    void add(E element);

    void remove(E element);

    boolean contains(E element);

    List<E> getAll();

    int size();
}
