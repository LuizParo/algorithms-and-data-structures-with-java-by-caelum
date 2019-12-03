package br.com.caelum.datastructure.deque;

import br.com.caelum.model.Student;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public final class DequeTest {
    private final Supplier<Deque<Student>> dequeSupplier;
    private final Supplier<ExpectedException> expectedExceptionSupplier;

    public DequeTest(Supplier<Deque<Student>> dequeSupplier, Supplier<ExpectedException> expectedExceptionSupplier) {
        this.dequeSupplier = dequeSupplier;
        this.expectedExceptionSupplier = expectedExceptionSupplier;
    }

    private Deque<Student> newDeque() {
        return dequeSupplier.get();
    }

    private ExpectedException expectedException() {
        return this.expectedExceptionSupplier.get();
    }

    public void addFirst_whenCalledWithElement_andDequeIsEmpty_shouldAddItAsTheFirstElementOfTheDeque() {
        final Student student1 = new Student("john");

        final Deque<Student> deque = newDeque();
        deque.addFirst(student1);

        final Student firstStudent = deque.removeFirst();
        assertThat(firstStudent, equalTo(student1));
    }

    public void addFirst_whenCalledWithElement_andDequeIsEmpty_shouldAddItAsTheLastElementOfTheDeque() {
        final Student student1 = new Student("john");

        final Deque<Student> deque = newDeque();
        deque.addFirst(student1);

        final Student lastStudent = deque.removeLast();
        assertThat(lastStudent, equalTo(student1));
    }

    public void addFirst_whenCalledWithElement_andDequeAlreadyHasElements_shouldAddItToTheBeginningOfTheDeque() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Deque<Student> deque = newDeque();
        deque.addLast(student1);
        deque.addLast(student2);

        deque.addFirst(student3);

        final Student firstStudent = deque.removeFirst();
        assertThat(firstStudent, equalTo(student3));
    }

    public void addLast_whenCalledWithElement_andDequeIsEmpty_shouldAddItAsTheFirstElementOfTheDeque() {
        final Student student1 = new Student("john");

        final Deque<Student> deque = newDeque();
        deque.addLast(student1);

        final Student firstStudent = deque.removeFirst();
        assertThat(firstStudent, equalTo(student1));
    }

    public void addLast_whenCalledWithElement_andDequeIsEmpty_shouldAddItAsTheLastElementOfTheDeque() {
        final Student student1 = new Student("john");

        final Deque<Student> deque = newDeque();
        deque.addLast(student1);

        final Student lastStudent = deque.removeLast();
        assertThat(lastStudent, equalTo(student1));
    }

    public void addLast_whenCalledWithElement_andDequeAlreadyHasElements_shouldAddItToTheEndOfTheDeque() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Deque<Student> deque = newDeque();
        deque.addFirst(student1);
        deque.addFirst(student2);
        deque.addLast(student3);

        final Student lastStudent = deque.removeLast();
        assertThat(lastStudent, equalTo(student3));
    }

    public void removeFirst_whenCalled_andDequeIsEmpty_shouldThrowAnError() {
        this.expectedException().expect(NoSuchElementException.class);

        final Deque<Student> deque = newDeque();
        deque.removeFirst();
    }

    public void removeFirst_whenCalled_andDequeIsNotEmpty_shouldRemoveTheFirstElementOfTheDeque() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Deque<Student> deque = newDeque();
        deque.addLast(student1);
        deque.addLast(student2);
        deque.addLast(student3);

        final Student firstStudent = deque.removeFirst();
        assertThat(deque.size(), equalTo(2));
        assertThat(firstStudent, equalTo(student1));
    }

    public void removeLast_whenCalled_andDequeIsEmpty_shouldThrowAnError() {
        this.expectedException().expect(NoSuchElementException.class);

        final Deque<Student> deque = newDeque();
        deque.removeLast();
    }

    public void removeLast_whenCalled_andDequeIsNotEmpty_shouldRemoveTheLastElementOfTheDeque() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Deque<Student> deque = newDeque();
        deque.addLast(student1);
        deque.addLast(student2);
        deque.addLast(student3);

        final Student lastStudent = deque.removeLast();
        assertThat(deque.size(), equalTo(2));
        assertThat(lastStudent, equalTo(student3));
    }

    public void size_whenCalled_andDequeIsEmpty_shouldReturnItsSizeAsZero() {
        final Deque<Student> deque = newDeque();
        assertThat(deque.size(), equalTo(0));
    }

    public void size_whenCalled_andDequeIsNotEmpty_shouldReturnItsSize() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Deque<Student> deque = newDeque();
        deque.addLast(student1);
        deque.addLast(student2);
        deque.addLast(student3);

        assertThat(deque.size(), equalTo(3));
    }
}