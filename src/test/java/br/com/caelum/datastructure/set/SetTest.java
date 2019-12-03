package br.com.caelum.datastructure.set;

import br.com.caelum.model.Student;

import java.util.List;
import java.util.function.Supplier;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public final class SetTest {
    private final Supplier<Set<Student>> setSupplier;

    public SetTest(Supplier<Set<Student>> setSupplier) {
        this.setSupplier = setSupplier;
    }

    private Set<Student> newSet() {
        return setSupplier.get();
    }

    public void add_whenCalledWithStudent_shouldAddItIntoTheSet() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");

        final Set<Student> set = newSet();
        set.add(student1);
        set.add(student2);

        final List<Student> allStudents = set.getAll();
        assertThat(allStudents, hasSize(2));
        assertThat(allStudents, containsInAnyOrder(student1, student2));
    }

    public void remove_whenCalledWithExistingElement_shouldRemoveItFromTheSet() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Set<Student> set = newSet();
        set.add(student1);
        set.add(student2);
        set.add(student3);

        set.remove(student1);

        final List<Student> allStudents = set.getAll();
        assertThat(allStudents, hasSize(2));
        assertThat(allStudents, containsInAnyOrder(student2, student3));
        assertThat(allStudents, not(contains(student1)));
    }

    public void contains_whenCalledWithExistingElement_shouldReturnTrue() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");

        final Set<Student> set = newSet();
        set.add(student1);
        set.add(student2);

        assertThat(set.contains(student1), equalTo(TRUE));
        assertThat(set.contains(student2), equalTo(TRUE));
    }

    public void contains_whenCalledWithNonExistingElement_shouldReturnFalse() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Set<Student> set = newSet();
        set.add(student1);
        set.add(student2);

        assertThat(set.contains(student3), equalTo(FALSE));
    }

    public void getAll_whenSetIsEmpty_shouldReturnAnEmptyList() {
        final Set<Student> set = newSet();
        final List<Student> allStudents = set.getAll();

        assertThat(allStudents, emptyCollectionOf(Student.class));
    }

    public void getAll_whenSetIsNotEmpty_shouldReturnAListWithAllItsElements() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Set<Student> set = newSet();
        set.add(student1);
        set.add(student2);
        set.add(student3);

        final List<Student> allStudents = set.getAll();
        assertThat(allStudents, hasSize(3));
        assertThat(allStudents, containsInAnyOrder(student1, student2, student3));
    }

    public void size_whenCalled_shouldReturnTheCurrentSizeOfTheSet() {
        final Student student1 = new Student("john");
        final Student student2 = new Student("josh");
        final Student student3 = new Student("anna");

        final Set<Student> set = newSet();
        set.add(student1);
        set.add(student2);
        set.add(student3);

        assertThat(set.size(), equalTo(3));
    }
}