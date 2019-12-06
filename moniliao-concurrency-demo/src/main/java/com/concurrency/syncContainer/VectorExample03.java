package com.concurrency.syncContainer;

import java.util.*;

public class VectorExample03 {

    // java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> v1) { // foreach
        for(Integer i : v1) {
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    // java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> v1) { // iterator
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    private static void test4(List<Integer> v1) { // iterator
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    // success
    private static void test3(Vector<Integer> v1) { // for
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(3)) {
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) {

        // Vector<Integer> vector = new Vector<>();
        List<Integer> vector = new ArrayList<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        //test4(vector);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(Arrays.asList(list));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("1")) {
                iterator.remove();
            }
        }
        System.out.println(Arrays.asList(list));
    }
}
