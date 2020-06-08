package com.llollox.algorithms.problems.crack.sorting;

import java.util.ArrayList;
import java.util.BitSet;

public class FindDuplicates {
    /**
     * You have an array with all the numbers from 1 to N, where N is at most 32,000. The array may have duplicate entries and you do not know what N is.
     * With only 4 kilobytes of memory available, how would you print all duplicate elements in the array?
     *
     * Algorithm Time O(n) Space O(n/8)
     * Creo un bitset di 32000 element (4KB).
     * Scorro l’intero array.
     * Per ogni elemento, (considero il valore come l’indice nel bitset):
     * se è FALSE: setto il bitset a TRUE
     * se è TRUE: printo l’elemento duplicato
     */

    public ArrayList<Integer> printDuplicates(int[] array) {
        BitSet bitSet = new BitSet(32000);
        ArrayList<Integer> duplicates = new ArrayList<>();
        for (int i=0; i<array.length; i++) {
            int index = array[i] - 1;
            if (bitSet.get(index)) {
                print(duplicates, array[i]);
            }
            else {
                bitSet.set(index, true);
            }
        }
        return duplicates;
    }

    private void print(ArrayList<Integer> duplicates, int duplicate) {
        duplicates.add(duplicate);
    }
}
