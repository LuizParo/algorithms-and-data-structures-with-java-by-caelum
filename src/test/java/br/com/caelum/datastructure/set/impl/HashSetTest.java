package br.com.caelum.datastructure.set.impl;

import br.com.caelum.datastructure.set.SetTest;
import org.junit.Test;

public class HashSetTest {

    private final SetTest setTest = new SetTest(HashSet::new);

    @Test
    public void add_whenCalledWithStudent_shouldAddItIntoTheSet() {
        setTest.add_whenCalledWithStudent_shouldAddItIntoTheSet();
    }

    @Test
    public void remove_whenCalledWithExistingElement_shouldRemoveItFromTheSet() {
        setTest.remove_whenCalledWithExistingElement_shouldRemoveItFromTheSet();
    }

    @Test
    public void contains_whenCalledWithExistingElement_shouldReturnTrue() {
        setTest.contains_whenCalledWithExistingElement_shouldReturnTrue();
    }

    @Test
    public void contains_whenCalledWithNonExistingElement_shouldReturnFalse() {
        setTest.contains_whenCalledWithNonExistingElement_shouldReturnFalse();
    }

    @Test
    public void getAll_whenSetIsEmpty_shouldReturnAnEmptyList() {
        setTest.getAll_whenSetIsEmpty_shouldReturnAnEmptyList();
    }

    @Test
    public void getAll_whenSetIsNotEmpty_shouldReturnAListWithAllItsElements() {
        setTest.getAll_whenSetIsNotEmpty_shouldReturnAListWithAllItsElements();
    }

    @Test
    public void size_whenCalled_shouldReturnTheCurrentSizeOfTheSet() {
        setTest.size_whenCalled_shouldReturnTheCurrentSizeOfTheSet();
    }
}