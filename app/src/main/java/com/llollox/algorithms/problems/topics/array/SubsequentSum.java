package com.llollox.algorithms.problems.topics.array;

import java.util.HashMap;

public class SubsequentSum {

    int numSubsequentSum(int[] array, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int currSum = 0;

        for (int v : array) {
            currSum += v;

            if (currSum == sum) {
                count += 1;
            }

            count += map.getOrDefault(currSum - sum, 0);

            increment(map, currSum);
        }

        return count;
    }

    private void increment(HashMap<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        }
        else {
            map.put(key, 1);
        }
    }
}
