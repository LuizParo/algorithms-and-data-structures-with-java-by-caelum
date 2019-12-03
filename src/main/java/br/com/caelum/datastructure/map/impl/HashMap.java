package br.com.caelum.datastructure.map.impl;

import br.com.caelum.datastructure.map.Map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class HashMap<K, V> implements Map<K, V> {
    private final List<List<Entry<K, V>>> entries = new ArrayList<>();
    private int size = 0;

    public HashMap() {
        for (int i = 0; i < 100; i++) {
            this.entries.add(new LinkedList<>());
        }
    }

    @Override
    public void put(K key, V value) {
        if (this.containsKey(key)) {
            this.remove(key);
        }

        verifyEntriesSize();

        final List<Entry<K, V>> list = this.getListAtIndex(key);
        list.add(new Entry<>(key, value));

        this.size++;
    }

    @Override
    public V get(K key) {
        final List<Entry<K, V>> list = this.getListAtIndex(key);

        return list.stream()
                   .filter(entry -> entry.getKey().equals(key))
                   .map(Entry::getValue)
                   .findFirst()
                   .orElseThrow(() -> new NoSuchElementException("key does not exist: " + key));
    }

    @Override
    public void remove(K key) {
        final List<Entry<K, V>> list = this.getListAtIndex(key);

        if (!list.removeIf(entry -> entry.getKey().equals(key))) {
            throw new NoSuchElementException("key does not exist: " + key);
        }

        verifyEntriesSize();
        this.size--;
    }

    @Override
    public boolean containsKey(K key) {
        final List<Entry<K, V>> list = this.getListAtIndex(key);

        return list.stream()
                   .filter(entry -> entry.getKey().equals(key))
                   .map(Entry::getValue)
                   .findFirst()
                   .isPresent();
    }

    @Override
    public int size() {
        return this.size;
    }

    private List<Entry<K, V>> getListAtIndex(K key) {
        final int index = Math.abs(key.hashCode()) % this.entries.size();
        return this.entries.get(index);
    }

    private void verifyEntriesSize() {
        final int capacity = this.entries.size();
        final double load = (double) this.size / capacity;

        if (load > 0.75) {
            this.resizeEntries(capacity * 2);
        } else if (load < 0.25) {
            this.resizeEntries(Math.max(capacity / 2, 10));
        }
    }

    private void resizeEntries(int newCapacity) {
        final List<Entry<K, V>> entries = this.entries.stream()
                                                      .flatMap(Collection::stream)
                                                      .collect(collectingAndThen(toList(), Collections::unmodifiableList));
        this.entries.clear();
        this.size = 0;

        for (int i = 0; i < newCapacity; i++) {
            this.entries.add(new LinkedList<>());
        }

        entries.forEach(entry -> this.put(entry.getKey(), entry.getValue()));
    }
}

class Entry<K, V> {
    private final K key;
    private final V value;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
