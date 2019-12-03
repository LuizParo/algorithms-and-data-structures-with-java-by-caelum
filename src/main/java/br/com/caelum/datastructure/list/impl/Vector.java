package br.com.caelum.datastructure.list.impl;

import br.com.caelum.datastructure.list.List;

import java.util.Arrays;

public final class Vector<E> implements List<E> {
    private E[] elements;
    private int size = 0;

    public Vector() {
        this.elements = (E[]) new Object[10];
    }

    @Override
    public void add(E element) {
        this.ensureCapacity();
        this.elements[size] = element;
        this.size++;
    }

    @Override
    public void add(int index, E element) {
        this.checkValidIndexForInsertion(index);
        this.ensureCapacity();

        final int numMoved = this.size - index;
        if (numMoved > 0) {
            System.arraycopy(this.elements, index, this.elements, index + 1, numMoved);
        }

        this.elements[index] = element;
        this.size++;
    }

    @Override
    public E get(int index) {
        this.checkValidIndex(index);
        return this.elements[index];
    }

    @Override
    public void remove(int index) {
        this.checkValidIndex(index);

        final int numMoved = this.size - index - 1;
        if (numMoved >= 0) {
            System.arraycopy(this.elements, index + 1, this.elements, index, numMoved);
        }

        this.elements[this.size - 1] = null;
        this.size--;
    }

    @Override
    public void remove(E element) {
        for (int index = 0; index < this.size; index++) {
            if (this.elements[index].equals(element)) {
                this.remove(index);
            }
        }
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        Arrays.fill(this.elements, null);
        this.size = 0;
    }

    @Override
    public int indexOf(E element) {
        for (int index = 0; index < this.size; index++) {
            if (this.elements[index].equals(element)) {
                return index;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        int lastIndex = -1;

        for (int index = 0; index < this.size; index++) {
            if (this.elements[index].equals(element)) {
                lastIndex = index;
            }
        }

        return lastIndex;
    }

    private void checkValidIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("invalid index: " + index);
        }
    }

    private void checkValidIndexForInsertion(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("invalid index: " + index);
        }
    }

    private void ensureCapacity() {
        if (this.size != this.elements.length) {
            return;
        }

        E[] newArray = (E[]) new Object[this.elements.length * 2];

        for (int i = 0; i < this.elements.length; i++) {
            newArray[i] = this.elements[i];
            this.elements[i] = null;
        }

        this.elements = newArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.elements);
    }
}
