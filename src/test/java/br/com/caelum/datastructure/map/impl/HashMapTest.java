package br.com.caelum.datastructure.map.impl;

import br.com.caelum.datastructure.map.MapTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HashMapTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final MapTest mapTest = new MapTest(HashMap::new, () -> this.expectedException);

    @Test
    public void put_whenCalledWithKeyValuePair_shouldSaveTheEntryIntoTheMap() {
        mapTest.put_whenCalledWithKeyValuePair_shouldSaveTheEntryIntoTheMap();
    }

    @Test
    public void get_whenCalledWithKey_andThereIsAValueAssociatedToIt_shouldReturnTheValue() {
        mapTest.get_whenCalledWithKey_andThereIsAValueAssociatedToIt_shouldReturnTheValue();
    }

    @Test
    public void get_whenCalledWithKey_andThereIsNotAValueAssociatedToIt_shouldReturnThrowAnError() {
        mapTest.get_whenCalledWithKey_andThereIsNotAValueAssociatedToIt_shouldReturnThrowAnError();
    }

    @Test
    public void remove_whenCalledWithKey_andItExistsOnTheMap_shouldRemoveItsAssociation() {
        mapTest.remove_whenCalledWithKey_andItExistsOnTheMap_shouldRemoveItsAssociation();
    }

    @Test
    public void remove_whenCalledWithKey_andItDesNotExistOnTheMap_shouldThrowAnError() {
        mapTest.remove_whenCalledWithKey_andItDesNotExistOnTheMap_shouldThrowAnError();
    }

    @Test
    public void containsKey_whenCalledWithKey_andItExistsOnTheMap_shouldReturnTrue() {
        mapTest.containsKey_whenCalledWithKey_andItExistsOnTheMap_shouldReturnTrue();
    }

    @Test
    public void containsKey_whenCalledWithKey_andItDoesNotExistOnTheMap_shouldReturnFalse() {
        mapTest.containsKey_whenCalledWithKey_andItDoesNotExistOnTheMap_shouldReturnFalse();
    }

    @Test
    public void size_whenCalled_shouldReturnTheCurrentSizeOfTheMap() {
        mapTest.size_whenCalled_shouldReturnTheCurrentSizeOfTheMap();
    }
}