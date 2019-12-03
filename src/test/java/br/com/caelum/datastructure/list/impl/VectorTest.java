package br.com.caelum.datastructure.list.impl;

import br.com.caelum.datastructure.list.ListTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class VectorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ListTest listTest = new ListTest(Vector::new, () -> this.expectedException);

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
}