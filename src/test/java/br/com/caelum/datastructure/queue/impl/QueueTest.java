package br.com.caelum.datastructure.queue.impl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QueueTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private br.com.caelum.datastructure.queue.QueueTest dequeTest = new br.com.caelum.datastructure.queue.QueueTest(Queue::new, () -> this.expectedException);

    @Test
    public void addLast_whenCalledWithElement_andQueueIsEmpty_shouldAddItAsTheLastElementOfTheQueue() {
        dequeTest.addLast_whenCalledWithElement_andQueueIsEmpty_shouldAddItAsTheLastElementOfTheQueue();
    }

    @Test
    public void addLast_whenCalledWithElement_andQueueAlreadyHasElements_shouldAddItToTheEndOfTheQueue() {
        dequeTest.addLast_whenCalledWithElement_andQueueAlreadyHasElements_shouldAddItToTheEndOfTheQueue();
    }

    @Test
    public void removeFirst_whenCalled_andQueueIsEmpty_shouldThrowAnError() {
        dequeTest.removeFirst_whenCalled_andQueueIsEmpty_shouldThrowAnError();
    }

    @Test
    public void removeFirst_whenCalled_andQueueIsNotEmpty_shouldRemoveTheFirstElementOfTheQueue() {
        dequeTest.removeFirst_whenCalled_andQueueIsNotEmpty_shouldRemoveTheFirstElementOfTheQueue();
    }

    @Test
    public void size_whenCalled_andQueueIsEmpty_shouldReturnItsSizeAsZero() {
        dequeTest.size_whenCalled_andQueueIsEmpty_shouldReturnItsSizeAsZero();
    }

    @Test
    public void size_whenCalled_andQueueIsNotEmpty_shouldReturnItsSize() {
        dequeTest.size_whenCalled_andQueueIsNotEmpty_shouldReturnItsSize();
    }

    @Test
    public void isEmpty_whenQueueIsEmpty_shouldReturnTrue() {
        dequeTest.isEmpty_whenQueueIsEmpty_shouldReturnTrue();
    }

    @Test
    public void isEmpty_whenQueueIsNotEmpty_shouldReturnFalse() {
        dequeTest.isEmpty_whenQueueIsNotEmpty_shouldReturnFalse();
    }
}