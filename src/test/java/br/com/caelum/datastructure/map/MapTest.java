package br.com.caelum.datastructure.map;

import br.com.caelum.model.Student;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.function.Supplier;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MapTest {
    private final Supplier<Map<String, Student>> mapSupplier;
    private final Supplier<ExpectedException> expectedExceptionSupplier;

    public MapTest(Supplier<Map<String, Student>> mapSupplier, Supplier<ExpectedException> expectedExceptionSupplier) {
        this.mapSupplier = mapSupplier;
        this.expectedExceptionSupplier = expectedExceptionSupplier;
    }

    private Map<String, Student> newMap() {
        return mapSupplier.get();
    }

    private ExpectedException expectedException() {
        return this.expectedExceptionSupplier.get();
    }

    public void put_whenCalledWithKeyValuePair_shouldSaveTheEntryIntoTheMap() {
        final String name = UUID.randomUUID().toString();
        final Student student = new Student(name);

        final Map<String, Student> map = newMap();
        map.put(name, student);

        assertThat(map.get(name), equalTo(student));
    }

    public void get_whenCalledWithKey_andThereIsAValueAssociatedToIt_shouldReturnTheValue() {
        final String name1 = UUID.randomUUID().toString();
        final Student student1 = new Student(name1);

        final String name2 = UUID.randomUUID().toString();
        final Student student2 = new Student(name2);

        final Map<String, Student> map = newMap();
        map.put(name1, student1);
        map.put(name2, student2);

        assertThat(map.get(name1), equalTo(student1));
        assertThat(map.get(name2), equalTo(student2));
    }

    public void get_whenCalledWithKey_andThereIsNotAValueAssociatedToIt_shouldReturnThrowAnError() {
        final String name = UUID.randomUUID().toString();

        final ExpectedException expectedException = this.expectedException();
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage("key does not exist: " + name);

        final Map<String, Student> map = newMap();
        map.get(name);
    }

    public void remove_whenCalledWithKey_andItExistsOnTheMap_shouldRemoveItsAssociation() {
        final String name1 = UUID.randomUUID().toString();
        final Student student1 = new Student(name1);

        final String name2 = UUID.randomUUID().toString();
        final Student student2 = new Student(name2);

        final Map<String, Student> map = newMap();
        map.put(name1, student1);
        map.put(name2, student2);

        map.remove(name1);

        assertThat(map.containsKey(name1), equalTo(FALSE));
        assertThat(map.get(name2), equalTo(student2));
    }

    public void remove_whenCalledWithKey_andItDesNotExistOnTheMap_shouldThrowAnError() {
        final String name = UUID.randomUUID().toString();

        final ExpectedException expectedException = this.expectedException();
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage("key does not exist: " + name);

        final Map<String, Student> map = newMap();
        map.remove(name);
    }

    public void containsKey_whenCalledWithKey_andItExistsOnTheMap_shouldReturnTrue() {
        final String name1 = UUID.randomUUID().toString();
        final Student student1 = new Student(name1);

        final Map<String, Student> map = newMap();
        map.put(name1, student1);

        assertThat(map.containsKey(name1), equalTo(TRUE));
    }

    public void containsKey_whenCalledWithKey_andItDoesNotExistOnTheMap_shouldReturnFalse() {
        final String name1 = UUID.randomUUID().toString();
        final Student student1 = new Student(name1);

        final String name2 = UUID.randomUUID().toString();

        final Map<String, Student> map = newMap();
        map.put(name1, student1);

        assertThat(map.containsKey(name2), equalTo(FALSE));
    }

    public void size_whenCalled_shouldReturnTheCurrentSizeOfTheMap() {
        final String name1 = "john";
        final String name2 = "josh";
        final String name3 = "anna";

        final Student student1 = new Student(name1);
        final Student student2 = new Student(name2);
        final Student student3 = new Student(name3);

        final Map<String, Student> set = newMap();
        set.put(name1, student1);
        set.put(name2, student2);
        set.put(name3, student3);

        assertThat(set.size(), equalTo(3));
    }
}