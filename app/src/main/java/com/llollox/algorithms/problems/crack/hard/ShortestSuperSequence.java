package com.llollox.algorithms.problems.crack.hard;

import java.util.HashMap;

public class ShortestSuperSequence {

    int[] shortestSuperSequence(int[] longer, int[] shorter) {
        if (longer == null || shorter == null || shorter.length == 0 || longer.length < shorter.length) {
            return null;
        }

        int shorterStart = -1;
        int shorterEnd = -1;

        HashMap<Integer, Integer> targetMap = countOccurrences(shorter, 0, shorter.length - 1);
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;

        for (int end=0; end<longer.length; end++) {

            int valueToAdd = longer[end];
            if (targetMap.containsKey(valueToAdd)) {
                increment(map, valueToAdd);
            }

            while(containsAllElements(map, targetMap) && start <= end) {
                int currDiff = end - start;
                int minDiff = shorterEnd - shorterStart;
                if (shorterEnd == -1 || currDiff < minDiff) {
                    shorterStart = start;
                    shorterEnd = end;
                }

                int valueToRemove = longer[start];
                if (targetMap.containsKey(valueToRemove)) {
                    decrement(map, valueToRemove);
                }
                start++;
            }
        }

        if (shorterEnd == -1) {
            return null;
        }
        else {
            return new int[]{shorterStart, shorterEnd};
        }
    }

    int[] shortestSuperSequenceOptmial(int[] longer, int[] shorter) {
        if (longer == null || shorter == null || shorter.length == 0 || longer.length < shorter.length) {
            return null;
        }

        int shorterStart = -1;
        int shorterEnd = -1;

        HashMap<Integer, Integer> targetMap = countOccurrences(shorter, 0, shorter.length - 1);
        HashMap<Integer, Integer> map = new HashMap<>(targetMap);
        HashMap<Integer, Integer> savedMap = new HashMap<>();

        int start = 0;

        for (int end=0; end<longer.length; end++) {

            int valueToAdd = longer[end];
            if (targetMap.containsKey(valueToAdd)) {
                decrement(map, valueToAdd, savedMap);
            }

            while(map.isEmpty() && start <= end) {
                int currDiff = end - start;
                int minDiff = shorterEnd - shorterStart;
                if (shorterEnd == -1 || currDiff < minDiff) {
                    shorterStart = start;
                    shorterEnd = end;
                }

                int valueToRemove = longer[start];
                if (targetMap.containsKey(valueToRemove)) {
                    increment(map, valueToRemove, savedMap);
                }
                start++;
            }
        }

        if (shorterEnd == -1) {
            return null;
        }
        else {
            return new int[]{shorterStart, shorterEnd};
        }
    }


    private boolean containsAllElements(
            HashMap<Integer, Integer> map,
            HashMap<Integer, Integer> target) {
        if (map.size() != target.size()) {
            return false;
        }

        for (HashMap.Entry<Integer, Integer> entry : target.entrySet()) {
            int number = entry.getKey();
            int occurrences = entry.getValue();
            int currOccurrences = map.getOrDefault(number, 0);
            if (currOccurrences < occurrences) {
                return false;
            }
        }

        return true;
    }

    private void increment(HashMap<Integer, Integer> map, int key) {
        int occurrences = map.getOrDefault(key, 0) + 1;
        map.put(key, occurrences);
    }

    private void increment(HashMap<Integer, Integer> map, int key, HashMap<Integer, Integer> savedMap) {
        int savedOcc = savedMap.getOrDefault(key, 0) - 1;
        if (savedOcc > - 1) {
            savedMap.put(key, savedOcc);
        }
        else {
            int occurrences = map.getOrDefault(key, 0) + 1;
            map.put(key, occurrences);
        }
    }

    private void decrement(HashMap<Integer, Integer> map, int key) {
        int occurrences = map.getOrDefault(key, 1) - 1;
        if (occurrences > 0) {
            map.put(key, occurrences);
        }
        else {
            map.remove(key);
        }
    }

    private void decrement(HashMap<Integer, Integer> map, int key, HashMap<Integer, Integer> savedMap) {
        if (!map.containsKey(key)) {
            savedMap.put(key, savedMap.getOrDefault(key, 0) + 1);
            return;
        }
        int occurrences = map.getOrDefault(key, 1) - 1;
        if (occurrences > 0) {
            map.put(key, occurrences);
        }
        else {
            map.remove(key);
        }
    }

    HashMap<Integer, Integer> countOccurrences(int[] array, int start, int end) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=start; i<= end; i++) {
            int value = array[i];
            int occurrences = map.getOrDefault(value, 0) + 1;
            map.put(value, occurrences);
        }
        return map;
    }

}
