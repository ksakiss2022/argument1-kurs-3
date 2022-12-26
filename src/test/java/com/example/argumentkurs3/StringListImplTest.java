package com.example.argumentkurs3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    private StringListImpl expected;
    private StringListImpl actual;

    @BeforeEach
    public void setUt() {
     //   var strings = List.of("s1", "s2", "s3", "s4").toArray();
        expected = new StringListImpl(10);
        String string1 = "s1";
        String string2 = "s2";
        String string3 = "s3";
        String string4 = "s4";
        expected.add(string1);
        expected.add(string2);
        expected.add(string3);
        expected.add(string4);
        actual = new StringListImpl(10);
        actual.add(string1);
        actual.add(string2);
        actual.add(string3);
        actual.add(string4);
    }

    @Test
    void add() {
        StringListImpl stringList1 = new StringListImpl(10);
        String string1 = "s1";
        String string2 = "s2";
        String string3 = "s3";
        String string4 = "s4";
        stringList1.add(string1);
        stringList1.add(string2);
        stringList1.add(string3);
        stringList1.add(string4);
//        String[] array=new String[10];
//        array [0]="s1";
//        array [1]="s2";
//        array [2]="s3";
//        array [3]="s4";
        Assertions.assertEquals(expected,actual);

    }

    @Test
    void testAdd() {
        expected.add(1,"set");
    //    expected = new StringListImpl(10);
        String[] array = new String[10];
        array[0] = "s1";
        array[1] = "set";
        array[2] = "s2";
        array[3] = "s3";
        array[4] = "s4";

        actual.add(1, "set");
        Assertions.assertArrayEquals(array,actual.toArray());

    }

    @Test
    void set() {
        expected.set(1, "set");
        actual.set(1, "set");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void remove() {
        expected.remove(1);
        actual.remove(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testRemove() {
        expected.remove("s1");
        actual.remove("s1");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void contains() {
        Assertions.assertTrue(actual.contains("s1"));
    }

    @Test
    void indexOf() {
        Assertions.assertEquals(expected.indexOf("s1"), 0);
    }

    @Test
    void lastIndexOf() {
        Assertions.assertEquals(expected.indexOf("s1"), 0);
    }

    @Test
    void get() {
        Assertions.assertEquals(expected.indexOf("s1"), 0);
    }

    @Test
    void testEquals() {
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    void size() {
        Assertions.assertEquals(expected.size(), actual.size());
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(expected.isEmpty());
    }

    @Test
    void clear() {
        expected.clear();
        Assertions.assertTrue(expected.isEmpty());
    }

    @Test
    void toArray() {
        String[] strings1 = expected.toArray();
        String[] strings2 = new String[10];
        strings2[0] = "s1";
        strings2[1] = "s2";
        strings2[2] = "s3";
        strings2[4] = "s4";
        Assertions.assertArrayEquals(strings1,strings2);
    }

    @Test
    void shouldThrowIllegalArgumentExeptionWhenUseMethodAdd(){
        Assertions.assertThrows(IllegalArgumentException.class,()->expected.add(0,null));
        Assertions.assertThrows(IllegalArgumentException.class,()->expected.add(null));
    }
    @Test
    void shouldThrowArrayIndexOutOfBoundsExceptioWhenUseMethodSet(){
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,()->expected.set(11,"asd"));
    }
    @Test
    void shouldThrowIllegalArgumentExeptionWhenUseMethodSet(){
        Assertions.assertThrows(IllegalArgumentException.class,()->expected.set(0,null));
    }
    @Test
    void shouldThrowIllegalArgumentExeptionWhenUseMethodRemove(){
        Assertions.assertThrows(IllegalArgumentException.class,()->expected.remove(null));
    }
    @Test
    void shouldThrowIllegalArgumentExeptionWhenUseMethodContains(){
        Assertions.assertThrows(IllegalArgumentException.class,()->expected.contains(null));
    }
    @Test
    void shouldThrowIllegalArgumentExeptionWhenUseMethodEquals(){
        Assertions.assertThrows(IllegalArgumentException.class,()->expected.equals(null));
    }
}