package com.llollox.algorithms;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {

    @org.junit.Test
    public void myTest() {

        ArrayList<String> ab = new ArrayList<>();
        String a = "eIm";
        String sorted = sort(a);
        Assert.assertEquals("Iem", sorted);
    }

    private String sort(String s) {
        if (s == null) {
            return null;
        }
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return String.valueOf(array);
    }

    public void prova() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }

}
