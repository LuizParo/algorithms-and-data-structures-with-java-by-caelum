package br.com.caelum.datastructure.list;

import br.com.caelum.model.Student;
import org.junit.rules.ExpectedException;

import java.util.UUID;
import java.util.function.Supplier;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public final class ListTest {
    private final Supplier<List<Student>> listSupplier;
    private final Supplier<ExpectedException> expectedExceptionSupplier;

    public ListTest(Supplier<List<Student>> listSupplier, Supplier<ExpectedException> expectedExceptionSupplier) {
        this.listSupplier = listSupplier;
        this.expectedExceptionSupplier = expectedExceptionSupplier;
    }

    private List<Student> newList() {
        return listSupplier.get();
    }

    private ExpectedException expectedException() {
        return this.expectedExceptionSupplier.get();
    }

    public void add_whenCalledWithStudent_shouldAddItInTheEndOfTheList() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);

        final Student firstStudent = list.get(0);
        final Student lastStudent = list.get(1);

        assertThat(firstStudent, equalTo(student1));
        assertThat(lastStudent, equalTo(student2));
    }

    public void add_whenCalledWithMoreStudentsThanTheInitialArrayCapacityOf10_shouldAddItInTheEndOfTheList_withoutThrowingAnError() {
        final Student student1 = new Student(UUID.randomUUID().toString());
        final Student student2 = new Student(UUID.randomUUID().toString());
        final Student student3 = new Student(UUID.randomUUID().toString());
        final Student student4 = new Student(UUID.randomUUID().toString());
        final Student student5 = new Student(UUID.randomUUID().toString());
        final Student student6 = new Student(UUID.randomUUID().toString());
        final Student student7 = new Student(UUID.randomUUID().toString());
        final Student student8 = new Student(UUID.randomUUID().toString());
        final Student student9 = new Student(UUID.randomUUID().toString());
        final Student student10 = new Student(UUID.randomUUID().toString());
        final Student student11 = new Student(UUID.randomUUID().toString());

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        list.add(student7);
        list.add(student8);
        list.add(student9);
        list.add(student10);
        list.add(student11);

        final Student lastStudent = list.get(10);

        assertThat(lastStudent, equalTo(student11));
    }

    public void add_whenCalledWithIndexAndStudent_shouldAddTheStudentInTheGivenIndex() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final List<Student> list = newList();
        list.add(student1);
        list.add(0, student2);
        list.add(1, student3);

        final Student firstStudent = list.get(0);
        final Student middleStudent = list.get(1);
        final Student lastStudent = list.get(2);

        assertThat(firstStudent, equalTo(student2));
        assertThat(middleStudent, equalTo(student3));
        assertThat(lastStudent, equalTo(student1));
    }

    public void add_whenCalledWithIndexAndStudent_andTheLastInsertionSurpassedTheInitialArrayCapacityOf10_shouldAddTheStudentInTheGivenIndex_withoutThrowingAnyError() {
        final Student student1 = new Student(UUID.randomUUID().toString());
        final Student student2 = new Student(UUID.randomUUID().toString());
        final Student student3 = new Student(UUID.randomUUID().toString());
        final Student student4 = new Student(UUID.randomUUID().toString());
        final Student student5 = new Student(UUID.randomUUID().toString());
        final Student student6 = new Student(UUID.randomUUID().toString());
        final Student student7 = new Student(UUID.randomUUID().toString());
        final Student student8 = new Student(UUID.randomUUID().toString());
        final Student student9 = new Student(UUID.randomUUID().toString());
        final Student student10 = new Student(UUID.randomUUID().toString());
        final Student student11 = new Student(UUID.randomUUID().toString());

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        list.add(student7);
        list.add(student8);
        list.add(student9);
        list.add(student10);
        list.add(3, student11);

        final Student recoveredStudent = list.get(3);
        assertThat(recoveredStudent, equalTo(student11));
    }

    public void add_whenCalledWithIndexEqualTheSizeOfTheList_shouldAddTheStudentToIt() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);
        list.add(2, student3);

        final Student firstStudent = list.get(0);
        final Student middleStudent = list.get(1);
        final Student lastStudent = list.get(2);

        assertThat(firstStudent, equalTo(student1));
        assertThat(middleStudent, equalTo(student2));
        assertThat(lastStudent, equalTo(student3));
    }

    public void add_whenCalledWithNegativeIndex_shouldThrowAnException() {
        this.expectedException().expect(IndexOutOfBoundsException.class);
        this.expectedException().expectMessage("invalid index: " + -1);

        final List<Student> list = newList();
        list.add(new Student("john"));
        list.add(new Student("josh"));
        list.add(-1, new Student("anna"));
    }

    public void add_whenCalledWithIndexGreaterThanTheSizeOfTheList_shouldThrowAnException() {
        this.expectedException().expect(IndexOutOfBoundsException.class);
        this.expectedException().expectMessage("invalid index: " + 3);

        final List<Student> list = newList();
        list.add(new Student("john"));
        list.add(new Student("josh"));
        list.add(3, new Student("anna"));
    }

    public void get_whenCalledWithIndex_shouldGetTheStudentLocatedInThatPositionOfTheList() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);

        final Student firstStudent = list.get(0);
        final Student lastStudent = list.get(1);

        assertThat(firstStudent, equalTo(student1));
        assertThat(lastStudent, equalTo(student2));
    }

    public void get_whenCalledWithNegativeIndex_shouldThrowAnException() {
        this.expectedException().expect(IndexOutOfBoundsException.class);
        this.expectedException().expectMessage("invalid index: " + -1);

        final List<Student> list = newList();
        list.add(new Student("john"));
        list.add(new Student("josh"));

        list.get(-1);
    }

    public void get_whenCalledWithIndexEqualTheSizeOfTheList_shouldThrowAnException() {
        this.expectedException().expect(IndexOutOfBoundsException.class);
        this.expectedException().expectMessage("invalid index: " + 2);

        final List<Student> list = newList();
        list.add(new Student("john"));
        list.add(new Student("josh"));

        list.get(2);
    }

    public void get_whenCalledWithIndexGreaterThanTheSizeOfTheList_shouldThrowAnException() {
        this.expectedException().expect(IndexOutOfBoundsException.class);
        this.expectedException().expectMessage("invalid index: " + 3);

        final List<Student> list = newList();
        list.add(new Student("john"));
        list.add(new Student("josh"));

        list.get(3);
    }

    public void remove_whenCalledWithIndex_shouldRemoveStudentLocatedInThatPositionOfTheList() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);

        list.remove(0);

        assertThat(list.size(), equalTo(1));
        assertThat(list.get(0), equalTo(student2));
    }

    public void remove_whenCalledWithNegativeIndex_shouldThrowAnException() {
        this.expectedException().expect(IndexOutOfBoundsException.class);
        this.expectedException().expectMessage("invalid index: " + -1);

        final List<Student> list = newList();
        list.add(new Student("john"));
        list.add(new Student("josh"));

        list.remove(-1);
    }

    public void remove_whenCalledWithIndexEqualTheSizeOfTheList_shouldThrowAnException() {
        this.expectedException().expect(IndexOutOfBoundsException.class);
        this.expectedException().expectMessage("invalid index: " + 2);

        final List<Student> list = newList();
        list.add(new Student("john"));
        list.add(new Student("josh"));

        list.remove(2);
    }

    public void remove_whenCalledWithIndexGreaterThanTheSizeOfTheList_shouldThrowAnException() {
        this.expectedException().expect(IndexOutOfBoundsException.class);
        this.expectedException().expectMessage("invalid index: " + 3);

        final List<Student> list = newList();
        list.add(new Student("john"));
        list.add(new Student("josh"));

        list.remove(3);
    }

    public void remove_whenCalledWithElement_andItsLocatedInTheBeginningOfTheList_shouldRemoveItFromThere() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);
        list.add(student3);

        list.remove(student1);

        assertThat(list.size(), equalTo(2));
        assertThat(list.get(0), equalTo(student2));
        assertThat(list.get(1), equalTo(student3));
    }

    public void remove_whenCalledWithElement_andItsLocatedInTheEndOfTheList_shouldRemoveItFromThere() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);
        list.add(student3);

        list.remove(student3);

        assertThat(list.size(), equalTo(2));
        assertThat(list.get(0), equalTo(student1));
        assertThat(list.get(1), equalTo(student2));
    }

    public void remove_whenCalledWithElement_shouldRemoveAllOccurrencesOfItFromTheList() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student2);

        list.remove(student2);

        assertThat(list.size(), equalTo(2));
        assertThat(list.get(0), equalTo(student1));
        assertThat(list.get(1), equalTo(student3));
    }

    public void contains_whenCalledWithExistingStudent_shouldReturnTrue() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);

        assertThat(list.contains(student1), equalTo(TRUE));
        assertThat(list.contains(student2), equalTo(TRUE));
    }

    public void contains_whenCalledWithNonExistingStudent_shouldReturnFalse() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);

        assertThat(list.contains(student3), equalTo(FALSE));
    }

    public void size_whenCalled_shouldReturnTheCurrentSizeOfTheList() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);
        list.add(student3);

        assertThat(list.size(), equalTo(3));
    }

    public void clear_whenCalledInTheList_shouldClearItFromAllItsElements() {
        this.expectedException().expect(IndexOutOfBoundsException.class);
        this.expectedException().expectMessage("invalid index: 0");

        final Student student1 = new Student(UUID.randomUUID().toString());
        final Student student2 = new Student(UUID.randomUUID().toString());
        final Student student3 = new Student(UUID.randomUUID().toString());
        final Student student4 = new Student(UUID.randomUUID().toString());
        final Student student5 = new Student(UUID.randomUUID().toString());
        final Student student6 = new Student(UUID.randomUUID().toString());
        final Student student7 = new Student(UUID.randomUUID().toString());
        final Student student8 = new Student(UUID.randomUUID().toString());
        final Student student9 = new Student(UUID.randomUUID().toString());
        final Student student10 = new Student(UUID.randomUUID().toString());
        final Student student11 = new Student(UUID.randomUUID().toString());

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        list.add(student7);
        list.add(student8);
        list.add(student9);
        list.add(student10);
        list.add(student11);

        list.clear();
        assertThat(list.size(), equalTo(0));

        list.get(0);
    }

    public void indexOf_whenListContainsElement_shouldReturnItsFirstIndex() {
        final Student student1 = new Student(UUID.randomUUID().toString());
        final Student student2 = new Student(UUID.randomUUID().toString());
        final Student student3 = new Student(UUID.randomUUID().toString());
        final Student student4 = new Student(UUID.randomUUID().toString());
        final Student student5 = new Student(UUID.randomUUID().toString());
        final Student student6 = new Student(UUID.randomUUID().toString());
        final Student student7 = new Student(UUID.randomUUID().toString());
        final Student student8 = new Student(UUID.randomUUID().toString());
        final Student student9 = new Student(UUID.randomUUID().toString());
        final Student student10 = new Student(UUID.randomUUID().toString());

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student2);
        list.add(student6);
        list.add(student7);
        list.add(student8);
        list.add(student9);
        list.add(student10);

        assertThat(list.indexOf(student2), equalTo(1));
    }

    public void indexOf_whenListDoesNotContainElement_shouldReturnMinusOne() {
        final Student student1 = new Student(UUID.randomUUID().toString());
        final Student student2 = new Student(UUID.randomUUID().toString());
        final Student student3 = new Student(UUID.randomUUID().toString());
        final Student student4 = new Student(UUID.randomUUID().toString());
        final Student student5 = new Student(UUID.randomUUID().toString());
        final Student student6 = new Student(UUID.randomUUID().toString());
        final Student student7 = new Student(UUID.randomUUID().toString());
        final Student student8 = new Student(UUID.randomUUID().toString());
        final Student student9 = new Student(UUID.randomUUID().toString());
        final Student student10 = new Student(UUID.randomUUID().toString());

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        list.add(student7);
        list.add(student8);
        list.add(student9);

        assertThat(list.indexOf(student10), equalTo(-1));
    }

    public void lastIndexOf_whenListContainsElement_shouldReturnItsLastIndex() {
        final Student student1 = new Student(UUID.randomUUID().toString());
        final Student student2 = new Student(UUID.randomUUID().toString());
        final Student student3 = new Student(UUID.randomUUID().toString());
        final Student student4 = new Student(UUID.randomUUID().toString());
        final Student student5 = new Student(UUID.randomUUID().toString());
        final Student student6 = new Student(UUID.randomUUID().toString());
        final Student student7 = new Student(UUID.randomUUID().toString());
        final Student student8 = new Student(UUID.randomUUID().toString());
        final Student student9 = new Student(UUID.randomUUID().toString());
        final Student student10 = new Student(UUID.randomUUID().toString());

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student2);
        list.add(student6);
        list.add(student7);
        list.add(student8);
        list.add(student9);
        list.add(student10);

        assertThat(list.lastIndexOf(student2), equalTo(5));
    }

    public void lastIndexOf_whenListDoesNotContainElement_shouldReturnMinusOne() {
        final Student student1 = new Student(UUID.randomUUID().toString());
        final Student student2 = new Student(UUID.randomUUID().toString());
        final Student student3 = new Student(UUID.randomUUID().toString());
        final Student student4 = new Student(UUID.randomUUID().toString());
        final Student student5 = new Student(UUID.randomUUID().toString());
        final Student student6 = new Student(UUID.randomUUID().toString());
        final Student student7 = new Student(UUID.randomUUID().toString());
        final Student student8 = new Student(UUID.randomUUID().toString());
        final Student student9 = new Student(UUID.randomUUID().toString());
        final Student student10 = new Student(UUID.randomUUID().toString());

        final List<Student> list = newList();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        list.add(student7);
        list.add(student8);
        list.add(student9);

        assertThat(list.lastIndexOf(student10), equalTo(-1));
    }
}