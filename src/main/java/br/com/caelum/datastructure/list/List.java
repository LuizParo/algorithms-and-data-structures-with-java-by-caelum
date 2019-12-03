package br.com.caelum.datastructure.list;

public interface List<E> {

    void add(E element);

    void add(int index, E element);

    E get(int index);

    void remove(int index);

    void remove(E element);

    boolean contains(E element);

    int size();

    void clear();

    int indexOf(E element);

    int lastIndexOf(E element);
}
