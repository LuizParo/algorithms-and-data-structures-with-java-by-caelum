package br.com.caelum.datastructure.list.impl;

import br.com.caelum.datastructure.deque.DequeTest;
import br.com.caelum.datastructure.list.ListTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LinkedListTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final ListTest listTest = new ListTest(LinkedList::new, () -> this.expectedException);

    private final DequeTest dequeTest = new DequeTest(LinkedList::new, () -> this.expectedException);

    @Test
    public void add_whenCalledWithStudent_shouldAddItInTheEndOfTheList() {
        listTest.add_whenCalledWithStudent_shouldAddItInTheEndOfTheList();
    }

    @Test
    public void add_whenCalledWithMoreStudentsThanTheInitialArrayCapacityOf10_shouldAddItInTheEndOfTheList_withoutThrowingAnError() {
        listTest.add_whenCalledWithMoreStudentsThanTheInitialArrayCapacityOf10_shouldAddItInTheEndOfTheList_withoutThrowingAnError();
    }

    @Test
    public void add_whenCalledWithIndexAndStudent_shouldAddTheStudentInTheGivenIndex() {
        listTest.add_whenCalledWithIndexAndStudent_shouldAddTheStudentInTheGivenIndex();
    }

    @Test
    public void add_whenCalledWithIndexAndStudent_andTheLastInsertionSurpassedTheInitialArrayCapacityOf10_shouldAddTheStudentInTheGivenIndex_withoutThrowingAnyError() {
        listTest.add_whenCalledWithIndexAndStudent_andTheLastInsertionSurpassedTheInitialArrayCapacityOf10_shouldAddTheStudentInTheGivenIndex_withoutThrowingAnyError();
    }

    @Test
    public void add_whenCalledWithIndexEqualTheSizeOfTheList_shouldAddTheStudentToIt() {
        listTest.add_whenCalledWithIndexEqualTheSizeOfTheList_shouldAddTheStudentToIt();
    }

    @Test
    public void add_whenCalledWithNegativeIndex_shouldThrowAnException() {
        listTest.add_whenCalledWithNegativeIndex_shouldThrowAnException();
    }

    @Test
    public void add_whenCalledWithIndexGreaterThanTheSizeOfTheList_shouldThrowAnException() {
        listTest.add_whenCalledWithIndexGreaterThanTheSizeOfTheList_shouldThrowAnException();
    }

    @Test
    public void get_whenCalledWithIndex_shouldGetTheStudentLocatedInThatPositionOfTheList() {
        listTest.get_whenCalledWithIndex_shouldGetTheStudentLocatedInThatPositionOfTheList();
    }

    @Test
    public void get_whenCalledWithNegativeIndex_shouldThrowAnException() {
        listTest.get_whenCalledWithNegativeIndex_shouldThrowAnException();
    }

    @Test
    public void get_whenCalledWithIndexEqualTheSizeOfTheList_shouldThrowAnException() {
        listTest.get_whenCalledWithIndexEqualTheSizeOfTheList_shouldThrowAnException();
    }

    @Test
    public void get_whenCalledWithIndexGreaterThanTheSizeOfTheList_shouldThrowAnException() {
        listTest.get_whenCalledWithIndexGreaterThanTheSizeOfTheList_shouldThrowAnException();
    }

    @Test
    public void remove_whenCalledWithIndex_shouldRemoveStudentLocatedInThatPositionOfTheList() {
        listTest.remove_whenCalledWithIndex_shouldRemoveStudentLocatedInThatPositionOfTheList();
    }

    @Test
    public void remove_whenCalledWithNegativeIndex_shouldThrowAnException() {
        listTest.remove_whenCalledWithNegativeIndex_shouldThrowAnException();
    }

    @Test
    public void remove_whenCalledWithIndexEqualTheSizeOfTheList_shouldThrowAnException() {
        listTest.remove_whenCalledWithIndexEqualTheSizeOfTheList_shouldThrowAnException();
    }

    @Test
    public void remove_whenCalledWithIndexGreaterThanTheSizeOfTheList_shouldThrowAnException() {
        listTest.remove_whenCalledWithIndexGreaterThanTheSizeOfTheList_shouldThrowAnException();
    }

    @Test
    public void remove_whenCalledWithElement_shouldRemoveAllOccurrencesOfItFromTheList() {
        listTest.remove_whenCalledWithElement_shouldRemoveAllOccurrencesOfItFromTheList();
    }

    @Test
    public void remove_whenCalledWithElement_andItsLocatedInTheBeginningOfTheList_shouldRemoveItFromThere() {
        listTest.remove_whenCalledWithElement_andItsLocatedInTheBeginningOfTheList_shouldRemoveItFromThere();
    }

    @Test
    public void remove_whenCalledWithElement_andItsLocatedInTheEndOfTheList_shouldRemoveItFromThere() {
        listTest.remove_whenCalledWithElement_andItsLocatedInTheEndOfTheList_shouldRemoveItFromThere();
    }

    @Test
    public void contains_whenCalledWithExistingStudent_shouldReturnTrue() {
        listTest.contains_whenCalledWithExistingStudent_shouldReturnTrue();
    }

    @Test
    public void contains_whenCalledWithNonExistingStudent_shouldReturnFalse() {
        listTest.contains_whenCalledWithNonExistingStudent_shouldReturnFalse();
    }

    @Test
    public void size_whenCalled_shouldReturnTheCurrentSizeOfTheList() {
        listTest.size_whenCalled_shouldReturnTheCurrentSizeOfTheList();
    }

    @Test
    public void clear_whenCalledInTheList_shouldClearItFromAllItsElements() {
        listTest.clear_whenCalledInTheList_shouldClearItFromAllItsElements();
    }

    @Test
    public void indexOf_whenListContainsElement_shouldReturnItsFirstIndex() {
        listTest.indexOf_whenListContainsElement_shouldReturnItsFirstIndex();
    }

    @Test
    public void indexOf_whenListDoesNotContainElement_shouldReturnMinusOne() {
        listTest.indexOf_whenListDoesNotContainElement_shouldReturnMinusOne();
    }

    @Test
    public void lastIndexOf_whenListContainsElement_shouldReturnItsLastIndex() {
        listTest.lastIndexOf_whenListContainsElement_shouldReturnItsLastIndex();
    }

    @Test
    public void lastIndexOf_whenListDoesNotContainElement_shouldReturnMinusOne() {
        listTest.lastIndexOf_whenListDoesNotContainElement_shouldReturnMinusOne();
    }

    @Test
    public void addFirst_whenCalledWithElement_andDequeIsEmpty_shouldAddItAsTheFirstElementOfTheDeque() {
        dequeTest.addFirst_whenCalledWithElement_andDequeIsEmpty_shouldAddItAsTheFirstElementOfTheDeque();
    }

    @Test
    public void addFirst_whenCalledWithElement_andDequeIsEmpty_shouldAddItAsTheLastElementOfTheDeque() {
        dequeTest.addFirst_whenCalledWithElement_andDequeIsEmpty_shouldAddItAsTheLastElementOfTheDeque();
    }

    @Test
    public void addFirst_whenCalledWithElement_andDequeAlreadyHasElements_shouldAddItToTheBeginningOfTheDeque() {
        dequeTest.addFirst_whenCalledWithElement_andDequeAlreadyHasElements_shouldAddItToTheBeginningOfTheDeque();
    }

    @Test
    public void addLast_whenCalledWithElement_andDequeIsEmpty_shouldAddItAsTheFirstElementOfTheDeque() {
        dequeTest.addLast_whenCalledWithElement_andDequeIsEmpty_shouldAddItAsTheFirstElementOfTheDeque();
    }

    @Test
    public void addLast_whenCalledWithElement_andDequeIsEmpty_shouldAddItAsTheLastElementOfTheDeque() {
        dequeTest.addLast_whenCalledWithElement_andDequeIsEmpty_shouldAddItAsTheLastElementOfTheDeque();
    }

    @Test
    public void addLast_whenCalledWithElement_andDequeAlreadyHasElements_shouldAddItToTheEndOfTheDeque() {
        dequeTest.addLast_whenCalledWithElement_andDequeAlreadyHasElements_shouldAddItToTheEndOfTheDeque();
    }

    @Test
    public void removeFirst_whenCalled_andDequeIsEmpty_shouldThrowAnError() {
        dequeTest.removeFirst_whenCalled_andDequeIsEmpty_shouldThrowAnError();
    }

    @Test
    public void removeFirst_whenCalled_andDequeIsNotEmpty_shouldRemoveTheFirstElementOfTheDeque() {
        dequeTest.removeFirst_whenCalled_andDequeIsNotEmpty_shouldRemoveTheFirstElementOfTheDeque();
    }

    @Test
    public void removeLast_whenCalled_andDequeIsEmpty_shouldThrowAnError() {
        dequeTest.removeLast_whenCalled_andDequeIsEmpty_shouldThrowAnError();
    }

    @Test
    public void removeLast_whenCalled_andDequeIsNotEmpty_shouldRemoveTheLastElementOfTheDeque() {
        dequeTest.removeLast_whenCalled_andDequeIsNotEmpty_shouldRemoveTheLastElementOfTheDeque();
    }

    @Test
    public void size_whenCalled_andDequeIsEmpty_shouldReturnItsSizeAsZero() {
        dequeTest.size_whenCalled_andDequeIsEmpty_shouldReturnItsSizeAsZero();
    }

    @Test
    public void size_whenCalled_andDequeIsNotEmpty_shouldReturnItsSize() {
        dequeTest.size_whenCalled_andDequeIsNotEmpty_shouldReturnItsSize();
    }
}