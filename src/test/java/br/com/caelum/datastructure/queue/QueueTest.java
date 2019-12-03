package br.com.caelum.datastructure.queue;

import br.com.caelum.model.Student;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public final class QueueTest {
    private final Supplier<Queue<Student>> queueSupplier;
    private final Supplier<ExpectedException> expectedExceptionSupplier;

    public QueueTest(Supplier<Queue<Student>> queueSupplier, Supplier<ExpectedException> expectedExceptionSupplier) {
        this.queueSupplier = queueSupplier;
        this.expectedExceptionSupplier = expectedExceptionSupplier;
    }

    private Queue<Student> newQueue() {
        return queueSupplier.get();
    }

    private ExpectedException expectedException() {
        return this.expectedExceptionSupplier.get();
    }

    public void addLast_whenCalledWithElement_andQueueIsEmpty_shouldAddItAsTheLastElementOfTheQueue() {
        final Student student1 = new Student("john");

        final Queue<Student> queue = newQueue();
        queue.addLast(student1);

        final Student lastStudent = queue.removeFirst();
        assertThat(lastStudent, equalTo(student1));
    }

    public void addLast_whenCalledWithElement_andQueueAlreadyHasElements_shouldAddItToTheEndOfTheQueue() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Queue<Student> queue = newQueue();
        queue.addLast(student1);
        queue.addLast(student2);
        queue.addLast(student3);

        final Student firstStudent = queue.removeFirst();
        final Student middleStudent = queue.removeFirst();
        final Student lastStudent = queue.removeFirst();
        
        assertThat(firstStudent, equalTo(student1));
        assertThat(middleStudent, equalTo(student2));
        assertThat(lastStudent, equalTo(student3));
    }

    public void removeFirst_whenCalled_andQueueIsEmpty_shouldThrowAnError() {
        this.expectedException().expect(NoSuchElementException.class);

        final Queue<Student> queue = newQueue();
        queue.removeFirst();
    }

    public void removeFirst_whenCalled_andQueueIsNotEmpty_shouldRemoveTheFirstElementOfTheQueue() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Queue<Student> queue = newQueue();
        queue.addLast(student1);
        queue.addLast(student2);
        queue.addLast(student3);

        final Student firstStudent = queue.removeFirst();
        assertThat(queue.size(), equalTo(2));
        assertThat(firstStudent, equalTo(student1));
    }

    public void size_whenCalled_andQueueIsEmpty_shouldReturnItsSizeAsZero() {
        final Queue<Student> queue = newQueue();
        assertThat(queue.size(), equalTo(0));
    }

    public void size_whenCalled_andQueueIsNotEmpty_shouldReturnItsSize() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Queue<Student> queue = newQueue();
        queue.addLast(student1);
        queue.addLast(student2);
        queue.addLast(student3);

        assertThat(queue.size(), equalTo(3));
    }

    public void isEmpty_whenQueueIsEmpty_shouldReturnTrue() {
        final Queue<Student> queue = newQueue();
        assertThat(queue.isEmpty(), equalTo(TRUE));
    }

    public void isEmpty_whenQueueIsNotEmpty_shouldReturnFalse() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Queue<Student> queue = newQueue();
        queue.addLast(student1);
        queue.addLast(student2);
        queue.addLast(student3);

        assertThat(queue.isEmpty(), equalTo(FALSE));
    }
}