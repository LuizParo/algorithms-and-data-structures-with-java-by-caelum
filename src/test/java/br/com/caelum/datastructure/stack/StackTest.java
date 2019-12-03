package br.com.caelum.datastructure.stack;

import br.com.caelum.model.Student;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public final class StackTest {
    private final Supplier<Stack<Student>> stackSupplier;
    private final Supplier<ExpectedException> expectedExceptionSupplier;

    public StackTest(Supplier<Stack<Student>> stackSupplier, Supplier<ExpectedException> expectedExceptionSupplier) {
        this.stackSupplier = stackSupplier;
        this.expectedExceptionSupplier = expectedExceptionSupplier;
    }

    private Stack<Student> newStack() {
        return stackSupplier.get();
    }

    private ExpectedException expectedException() {
        return this.expectedExceptionSupplier.get();
    }

    public void addLast_whenCalledWithElement_andStackIsEmpty_shouldAddItAsTheLastElementOfTheStack() {
        final Student student1 = new Student("john");

        final Stack<Student> stack = newStack();
        stack.addLast(student1);

        final Student lastStudent = stack.removeLast();
        assertThat(lastStudent, equalTo(student1));
    }

    public void addLast_whenCalledWithElement_andStackAlreadyHasElements_shouldAddItToTheEndOfTheStack() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Stack<Student> stack = newStack();
        stack.addLast(student1);
        stack.addLast(student2);
        stack.addLast(student3);

        final Student lastStudent = stack.removeLast();
        assertThat(lastStudent, equalTo(student3));
    }

    public void removeLast_whenCalled_andStackIsEmpty_shouldThrowAnError() {
        this.expectedException().expect(NoSuchElementException.class);

        final Stack<Student> stack = newStack();
        stack.removeLast();
    }

    public void removeLast_whenCalled_andStackIsNotEmpty_shouldRemoveTheLastElementOfTheStack() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Stack<Student> stack = newStack();
        stack.addLast(student1);
        stack.addLast(student2);
        stack.addLast(student3);

        final Student lastStudent = stack.removeLast();
        assertThat(stack.size(), equalTo(2));
        assertThat(lastStudent, equalTo(student3));
    }

    public void size_whenCalled_andStackIsEmpty_shouldReturnItsSizeAsZero() {
        final Stack<Student> stack = newStack();
        assertThat(stack.size(), equalTo(0));
    }

    public void size_whenCalled_andStackIsNotEmpty_shouldReturnItsSize() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Stack<Student> stack = newStack();
        stack.addLast(student1);
        stack.addLast(student2);
        stack.addLast(student3);

        assertThat(stack.size(), equalTo(3));
    }

    public void isEmpty_whenStackIsEmpty_shouldReturnTrue() {
        final Stack<Student> stack = newStack();
        assertThat(stack.isEmpty(), equalTo(TRUE));
    }

    public void isEmpty_whenStackIsNotEmpty_shouldReturnFalse() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Stack<Student> stack = newStack();
        stack.addLast(student1);
        stack.addLast(student2);
        stack.addLast(student3);

        assertThat(stack.isEmpty(), equalTo(FALSE));
    }
}