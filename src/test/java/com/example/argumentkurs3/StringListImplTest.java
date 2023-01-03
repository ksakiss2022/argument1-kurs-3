package com.example.argumentkurs3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class IntegerListImplTest {
    private IntegerListImpl integers1;
    private IntegerListImpl integers2;

    //    @BeforeEach
//    public void setUt() {
//     //   var Integers = List.of("s1", "s2", "s3", "s4").toArray();
//        integers1 = new IntegerListImpl(10);
//        Integer Integer1 = Integer.valueOf("s1");
//        Integer Integer2 = Integer.valueOf("s2");
//        Integer Integer3 = Integer.valueOf("s3");
//        Integer Integer4 = Integer.valueOf("s4");
//        integers1.add(Integer1);
//        integers1.add(Integer2);
//        integers1.add(Integer3);
//        integers1.add(Integer4);
//        integers2 = new IntegerListImpl(10);
//        integers2.add(Integer1);
//        integers2.add(Integer2);
//        integers2.add(Integer3);
//        integers2.add(Integer4);
//    }
    @BeforeEach
    public void setUt() {
        //   var Integers = List.of("s1", "s2", "s3", "s4").toArray();
        integers1 = new IntegerListImpl(4);
        integers1.add(3);
        integers1.add(1);
        integers1.add(2);
        integers1.add(4);
        integers2 = new IntegerListImpl(4);
        integers2.add(3);
        integers2.add(1);
        integers2.add(2);
        integers2.add(4);
    }

    @Test
    public void addInteger() {
        Assertions.assertTrue(integers1.equals(integers2));
    }

    @Test
    public void addByIndex() {
        integers1.add(1, 1);
        integers2.add(1, 1);
        Assertions.assertTrue(integers2.equals(integers1));
    }
//        IntegerListImpl IntegerList1 = new IntegerListImpl(10);
//        Integer Integer1 = Integer.valueOf("s1");
//        Integer Integer2 = Integer.valueOf("s2");
//        Integer Integer3 = Integer.valueOf("s3");
//        Integer Integer4 = Integer.valueOf("s4");
//        IntegerList1.add(Integer1);
//        IntegerList1.add(Integer2);
//        IntegerList1.add(Integer3);
//        IntegerList1.add(Integer4);
////        Integer[] array=new Integer[10];
////        array [0]="s1";
////        array [1]="s2";
////        array [2]="s3";
////        array [3]="s4";
//        Assertions.assertEquals(integers1,integers2);
//
//    }

//    @Test
//    void testAdd() {
//        integers1.add(1, Integer.valueOf("set"));
//    //    expected = new IntegerListImpl(10);
//        Integer[] array = new Integer[10];
//        array[0] = Integer.valueOf("s1");
//        array[1] = Integer.valueOf("set");
//        array[2] = Integer.valueOf("s2");
//        array[3] = Integer.valueOf("s3");
//        array[4] = Integer.valueOf("s4");
//
//        integers2.add(1, Integer.valueOf("set"));
//        Assertions.assertArrayEquals(array,integers2.toArray());
//
//    }

    @Test
    public void set() {
        integers1.set(1, 1);
        integers2.set(1, 1);
        Assertions.assertTrue(integers1.equals(integers2));
    }

    @Test
    void remove() {
        integers1.remove(1);
        integers2.remove(1);
        Assertions.assertTrue(integers1.equals(integers2));
    }

    @Test
    void testRemoveByInteger() {
        integers1.remove(1);
        integers2.remove(1);
        Assertions.assertTrue(integers1.equals(integers2));
    }

    @Test
    public void contains() {
        assert integers1.contains(1);
        assert !integers1.contains(500);
    }

    @Test
    void indexOf() {
        Assertions.assertEquals(integers1.indexOf(1), 1);
    }

    @Test
    void lastIndexOf() {
        Assertions.assertEquals(integers1.indexOf(1), 1);

    }

    @Test
    void get() {
        Assertions.assertEquals(integers1.indexOf(1), 1);
    }

    @Test
    void testEquals() {
        Assertions.assertTrue(integers1.equals(integers2));
    }

    @Test
    void size() {
        Assertions.assertEquals(integers1.size(), integers2.size());
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(integers1.isEmpty());
    }

    @Test
    void clear() {
        integers1.clear();
        Assertions.assertTrue(integers1.isEmpty());
    }

    @Test
    public void toArray() {
        Integer[] integers1 = this.integers1.toArray();
        Integer[] integers2 = new Integer[4];
        integers2[0] = 3;
        integers2[1] = 1;
        integers2[2] = 2;
        integers2[4] = 3;
        Assertions.assertArrayEquals(integers1, integers2);
    }

    @Test
    void shouldThrowIllegalArgumentExeptionWhenUseMethodAdd() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> integers1.add(0, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> integers1.add(null));
    }

    @Test
    void shouldThrowArrayIndexOutOfBoundsExceptioWhenUseMethodSet() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> integers1.set(11, Integer.valueOf("asd")));
    }

    @Test
    void shouldThrowIllegalArgumentExeptionWhenUseMethodSet() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> integers1.set(0, null));
    }

    @Test
    void shouldThrowIllegalArgumentExeptionWhenUseMethodRemove() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> integers1.remove(null));
    }

    @Test
    void shouldThrowIllegalArgumentExeptionWhenUseMethodContains() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> integers1.contains(null));
    }

    @Test
    void shouldThrowIllegalArgumentExeptionWhenUseMethodEquals() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> integers1.equals(null));
    }
}