package br.com.caelum.datastructure.set.impl;

import br.com.caelum.datastructure.set.Set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public final class HashSet<E> implements Set<E> {
    private final List<List<E>> table = new ArrayList<>();
    private int size = 0;

    public HashSet() {
        for (int i = 0; i < 26; i++) {
            final List<E> list = new LinkedList<>();
            this.table.add(list);
        }
    }

    @Override
    public void add(E element) {
        if (this.contains(element)) {
            return;
        }

        this.verifyTableSize();

        final int index = getIndex(element);
        final List<E> list = this.table.get(index);
        list.add(element);

        this.size++;
    }

    @Override
    public void remove(E element) {
        if (!this.contains(element)) {
            return;
        }

        final int index = getIndex(element);
        final List<E> list = this.table.get(index);
        list.remove(element);

        this.size--;

        this.verifyTableSize();
    }

    @Override
    public boolean contains(E element) {
        final int index = getIndex(element);
        final List<E> list = this.table.get(index);

        return nonNull(list) && list.contains(element);
    }

    @Override
    public List<E> getAll() {
        return this.table.stream()
                         .flatMap(Collection::stream)
                         .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    @Override
    public int size() {
        return this.size;
    }

    private int getIndex(E element) {
        final int hash = Objects.hashCode(element);
        return Math.abs(hash) % this.table.size();
    }

    private void verifyTableSize() {
        final int capacity = this.table.size();
        final double load = (double) this.size / capacity;

        if (load > 0.75) {
            this.resizeTable(capacity * 2);
        } else if (load < 0.25) {
            this.resizeTable(Math.max(capacity / 2, 10));
        }
    }

    private void resizeTable(int newCapacity) {
        final List<E> elements = this.getAll();
        this.table.clear();
        this.size = 0;

        for (int i = 0; i < newCapacity; i++) {
            this.table.add(new LinkedList<>());
        }

        elements.forEach(this::add);
    }
}
