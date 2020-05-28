package com.llollox.algorithms.problems.crack.sorting;

public class SortedSearchNoSize {

    public static class Linky {
        private int[] array;

        public Linky(int[] array) {
            this.array = array;
        }

        public int get(int index) {
            if (index >= 0 && index < array.length) {
                return array[index];
            }
            return -1;
        }
    }

    int sortedSearchNoSize(Linky linky, int n) {
        if (linky == null) {
            return -1;
        }

        return sortedSearchNoSizeHelper(linky, n, 0, 1);
    }

    private int sortedSearchNoSizeHelper(Linky linky, int n, int start, int end) {
        if (start >= end) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midValue = linky.get(midIndex);

        if (midValue == n) {
            return midIndex;
        }

        if (n < midValue || midValue == -1) {
            return sortedSearchNoSizeHelper(linky, n, start, midIndex);
        }

        return sortedSearchNoSizeHelper(linky, n, midIndex, end * 2);
    }

}
