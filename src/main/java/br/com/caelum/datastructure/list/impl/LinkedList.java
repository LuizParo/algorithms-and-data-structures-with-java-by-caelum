package br.com.caelum.datastructure.list.impl;

import br.com.caelum.datastructure.list.List;
import br.com.caelum.datastructure.deque.Deque;

import java.util.NoSuchElementException;

import static java.lang.String.format;
import static java.util.Locale.US;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public final class LinkedList<E> implements List<E>, Deque<E> {
    private Node<E> head;
    private Node<E> tail;

    private int size = 0;

    @Override
    public void add(E element) {
        if (this.size == 0) {
            this.addFirst(element);
            return;
        }

        final Node<E> newLastNode = new Node<>(element, this.tail, null);
        this.tail.setNext(newLastNode);
        this.tail = newLastNode;

        this.size++;
    }

    @Override
    public void add(int index, E element) {
        this.checkValidIndexForInsertion(index);

        if (index == 0) {
            this.addFirst(element);
            return;
        }

        if (index == this.size) {
            this.add(element);
            return;
        }

        final Node<E> previousNodeFromIndex = this.getNodeAt(index - 1);
        final Node<E> nextNodeFromIndex = previousNodeFromIndex.getNext();

        final Node<E> newNodeForIndex = new Node<>(element, previousNodeFromIndex, nextNodeFromIndex);

        previousNodeFromIndex.setNext(newNodeForIndex);
        nextNodeFromIndex.setPrevious(newNodeForIndex);

        this.size++;
    }

    @Override
    public E get(int index) {
        return this.getNodeAt(index).getElement();
    }

    @Override
    public void remove(int index) {
        this.checkValidIndex(index);

        if (index == 0) {
            this.removeFirst();
            return;
        }

        if (index == this.size - 1) {
            this.removeLast();
            return;
        }

        final Node<E> nodeToBeRemoved = this.getNodeAt(index - 1);
        final Node<E> previousNode = nodeToBeRemoved.getPrevious();
        final Node<E> nextNode = nodeToBeRemoved.getNext();

        previousNode.setNext(nextNode);
        nextNode.setPrevious(previousNode);

        this.size--;
    }

    @Override
    public void remove(E element) {
        Node<E> currentNode = this.head;

        while (nonNull(currentNode)) {
            if (this.head.getElement().equals(element)) {
                this.removeFirst();
                currentNode = currentNode.getNext();
                continue;
            }

            if (this.tail.getElement().equals(element)) {
                this.removeLast();
                currentNode = currentNode.getNext();
                continue;
            }

            if (currentNode.getElement().equals(element)) {
                final Node<E> nextNode = currentNode.getNext();
                final Node<E> previousNode = currentNode.getPrevious();

                if (nonNull(previousNode)) {
                    previousNode.setNext(nextNode);
                }

                if (nonNull(nextNode)) {
                    nextNode.setPrevious(previousNode);
                }

                this.size--;
            }

            currentNode = currentNode.getNext();
        }
    }

    @Override
    public boolean contains(E element) {
        Node<E> currentNode = this.head;

        while (nonNull(currentNode)) {
            if (currentNode.getElement().equals(element)) {
                return true;
            }

            currentNode = currentNode.getNext();
        }

        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int indexOf(E element) {
        Node<E> currentNode = this.head;

        for (int index = 0; index < this.size; index++) {
            if (currentNode.getElement().equals(element)) {
                return index;
            }
            currentNode = currentNode.getNext();
        }

        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        Node<E> currentNode = this.head;
        int lastIndex = -1;

        for (int index = 0; index < this.size; index++) {
            if (currentNode.getElement().equals(element)) {
                lastIndex = index;
            }
            currentNode = currentNode.getNext();
        }

        return lastIndex;
    }

    @Override
    public void addFirst(E element) {
        final Node<E> newFirstNode = new Node<>(element, null, this.head);

        if (this.size == 0) {
            this.head = newFirstNode;
            this.tail = newFirstNode;
        } else {
            this.head.setPrevious(newFirstNode);
            this.head = newFirstNode;
        }

        this.size++;
    }

    @Override
    public void addLast(E element) {
        this.add(element);
    }

    @Override
    public E removeFirst() {
        if (isNull(this.head)) {
            throw new NoSuchElementException();
        }

        final Node<E> previousHead = this.head;
        this.head = this.head.getNext();
        this.size--;

        if (nonNull(this.head)) {
            this.head.setPrevious(null);
        }

        if (this.size <= 1) {
            this.tail = this.head;
        }

        return previousHead.getElement();
    }

    @Override
    public E removeLast() {
        if (isNull(this.tail)) {
            throw new NoSuchElementException();
        }

        if (this.size == 1) {
            return this.removeFirst();
        }

        final Node<E> previousTailNode = this.tail;
        this.tail = tail.getPrevious();
        this.tail.setNext(null);
        this.size--;

        return previousTailNode.getElement();
    }

    @Override
    public String toString() {
        if (this.size == 0) {
            return "[]";
        }

        final StringBuilder builder = new StringBuilder("[");
        Node<E> current = this.head;

        for (int i = 0; i < this.size - 1; i++) {
            builder.append(current.getElement());
            builder.append(", ");

            current = current.getNext();
        }

        builder.append(current.getElement());
        builder.append("]");

        return builder.toString();
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

    private Node<E> getNodeAt(int index) {
        this.checkValidIndex(index);

        final int middleIndex = this.size / 2;
        Node<E> currentNode;

        if (index <= middleIndex) {
            currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
        } else {
            currentNode = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                currentNode = currentNode.getPrevious();
            }
        }

        return currentNode;
    }
}

class Node<E> {
    private E element;
    private Node<E> previous;
    private Node<E> next;

    Node(E element, Node<E> previous, Node<E> next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return format(US, "Node{element='%s'}", this.element);
    }
}