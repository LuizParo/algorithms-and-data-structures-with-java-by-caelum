package br.com.caelum.datastructure.stack.impl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private br.com.caelum.datastructure.stack.StackTest dequeTest = new br.com.caelum.datastructure.stack.StackTest(Stack::new, () -> this.expectedException);

    @Test
    public void addLast_whenCalledWithElement_andStackIsEmpty_shouldAddItAsTheLastElementOfTheStack() {
        dequeTest.addLast_whenCalledWithElement_andStackIsEmpty_shouldAddItAsTheLastElementOfTheStack();
    }

    @Test
    public void addLast_whenCalledWithElement_andStackAlreadyHasElements_shouldAddItToTheEndOfTheStack() {
        dequeTest.addLast_whenCalledWithElement_andStackAlreadyHasElements_shouldAddItToTheEndOfTheStack();
    }

    @Test
    public void removeLast_whenCalled_andStackIsEmpty_shouldThrowAnError() {
        dequeTest.removeLast_whenCalled_andStackIsEmpty_shouldThrowAnError();
    }

    @Test
    public void removeLast_whenCalled_andStackIsNotEmpty_shouldRemoveTheLastElementOfTheStack() {
        dequeTest.removeLast_whenCalled_andStackIsNotEmpty_shouldRemoveTheLastElementOfTheStack();
    }

    @Test
    public void size_whenCalled_andStackIsEmpty_shouldReturnItsSizeAsZero() {
        dequeTest.size_whenCalled_andStackIsEmpty_shouldReturnItsSizeAsZero();
    }

    @Test
    public void size_whenCalled_andStackIsNotEmpty_shouldReturnItsSize() {
        dequeTest.size_whenCalled_andStackIsNotEmpty_shouldReturnItsSize();
    }

    @Test
    public void isEmpty_whenStackIsEmpty_shouldReturnTrue() {
        dequeTest.isEmpty_whenStackIsEmpty_shouldReturnTrue();
    }

    @Test
    public void isEmpty_whenStackIsNotEmpty_shouldReturnFalse() {
        dequeTest.isEmpty_whenStackIsNotEmpty_shouldReturnFalse();
    }
}