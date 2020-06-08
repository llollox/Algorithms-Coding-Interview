package com.llollox.algorithms.problems.crack.sorting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.BitSet;
import java.util.Scanner;

public class MissingInt {

    int findMissingNumber(String filename) throws IllegalArgumentException, FileNotFoundException {
        int groupSize = 1000;
        int[] groups = new int[2 ^ 21];
        generateGroupsArray(loadScanner(filename), groupSize, groups);
        int groupWithMissingIndex = findGroupWithMissingNumber(groups);
        if (groupWithMissingIndex == -1) return -1;

        BitSet bitset = new BitSet(groupSize);
        int start = groupWithMissingIndex * groupSize;
        int end = start + 999;

        Scanner scanner = loadScanner(filename);
        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            if (value >= start && value <= end) {
                int index = value - start;
                if (bitset.get(index)) {
                    return value;
                } else {
                    bitset.set(index);
                }
            }
        }

        return -1;
    }

    // Scorre l’intero file e mi crea l’array dei gruppi
    void generateGroupsArray(Scanner scanner, int groupSize, int[] groups) {
        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            int group = value / groupSize;
            groups[group]++;
        }
    }

    // Scorre tutto l’array e cerca il primo indice, cui valore != 1000
    // -1 altrimenti se non trova nulla
    int findGroupWithMissingNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 1000) return i;
        }
        return -1;
    }

    private Scanner loadScanner(String filename) throws FileNotFoundException {
        return new Scanner(new FileReader(filename));
    }

}
