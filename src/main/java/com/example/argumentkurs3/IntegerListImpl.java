package com.example.argumentkurs3;

import java.util.Arrays;
import java.util.Random;

public class IntegerListImpl implements IntegerList {
    private Integer[] integerList;
    private int size;

    public IntegerListImpl(Integer[] integerList) {
        this.integerList = integerList;
    }

    public IntegerListImpl() {
        this.integerList = new Integer[10];
    }

    public IntegerListImpl(int initSize) {
        this.integerList = new Integer[initSize];

    }

    @Override
    public Integer add(Integer item) {
        growIfNeeded();
        validateItem(item);
        integerList[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        growIfNeeded();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            integerList[size++] = item;

            return item;
        }
        System.arraycopy(integerList, index, integerList, index + 1, size - index);
        integerList[index] = item;
        size++;
        return item;
    }


    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        integerList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);

        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = integerList[index];
        if (index != size) {
            System.arraycopy(integerList, index + 1, integerList, index, size - index);
        }
        size--;
        return item;
    }


    @Override
    public boolean contains(Integer item) {
        checkItem(item);
        return IntegerListImpl.binarySearch(Arrays.copyOf(integerList, integerList.length), item) > -1;

    }

    private void checkItem(Integer item) {
    }


    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integerList, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemExeption();
        }
    }

    //    private void validateSize() {
//        if (size == integerList.length) {
//            throw new StorageIsFullExeption();
//        }
//    }
    private void growIfNeeded() {
        if (size == integerList.length) {
            grow();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexExeption();
        }
    }

    //    private void sort(Integer[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            int temp = arr[i];
//            int j = i;
//            while (i > 0 && arr[j - 1] >= temp) {
//                arr[i] = arr[j - 1];
//                j--;
//            }
//            arr[j] = temp;
//        }
//    }
    private void sort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }


    public static void main(String[] args) {
        Integer[] integers1 = IntegerListImpl.toRondomArray();
        Integer[] integers2 = IntegerListImpl.toRondomArray();
        Integer[] integers3 = IntegerListImpl.toRondomArray();
        long start1 = System.currentTimeMillis();
        sortInsertion(integers1);
        System.out.println("сортировка вситавки" + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        sortSelection(integers2);
        System.out.println("сортировка выбором" + (System.currentTimeMillis() - start2));
        long start3 = System.currentTimeMillis();
        sortBubble(integers3);
        System.out.println("сортировка пузырьком" + (System.currentTimeMillis() - start3));
    }

    // сортировка пузырьками
    private static void sortBubble(Integer[] integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            for (int j = 0; j < integers.length - 1 - i; j++) {
                if (integers[j] > integers[j + 1]) {
                    swapElements(integers, j, j + 1);
                }
            }
        }
    }

    private static Integer[] toRondomArray() {
        Integer[] integers = new Integer[100000];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = new Random().nextInt(1000);
        }
        return integers;
    }

    //сортировка вставкой
    private static void sortInsertion(Integer[] integers) {
        for (int i = 1; i < integers.length; i++) {
            int temp = integers[i];
            int j = i;
            while (j > 0 && integers[j - 1] >= temp) {
                integers[j] = integers[j - 1];
                j--;
            }
            integers[j] = temp;
        }
    }

    // сортировка выбором
    private static void sortSelection(Integer[] sort) {
        for (int i = 0; i < sort.length - 1; i++) {
            for (int j = 0; j < sort.length - 1 - i; j++) {
                if (sort[j] > sort[j + 1]) {
                    swapElements(sort, j, j + 1);

                }
            }
        }

    }

    private static int binarySearch(Integer[] integers, Integer item) {
        IntegerListImpl.sortInsertion(integers);
        return Arrays.binarySearch(integers, item);
    }

    private void grow() {
        integerList = Arrays.copyOf(integerList, size + size / 2);
    }

}
