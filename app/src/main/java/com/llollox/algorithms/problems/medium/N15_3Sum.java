package com.llollox.algorithms.problems.medium;

import java.util.*;

public class N15_3Sum {

    /*
        Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
        Find all unique triplets in the array which gives the sum of zero.

        Note:
        The solution set must not contain duplicate triplets.

        Example:
        Given array nums = [-1, 0, 1, 2, -1, -4],

        A solution set is:
        [
            [-1, 0, 1],
            [-1, -1, 2]
        ]
     */


    /*
        Solution: O(N^2)
            - Per ogni valore nell'array n: Time O(N) Space O(1)
            - Cerco i due elementi che sommati fanno -n  Time O(N) Space O(N)
     */

    private static class SumIndexes {
        int a;
        int b;
        int c;

        public SumIndexes(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SumIndexes that = (SumIndexes) o;

            ArrayList<Integer> values = new ArrayList<>();
            values.add(a);
            values.add(b);
            values.add(c);

            int indexOfA = values.indexOf(that.a);
            if (indexOfA >= 0) {
                values.remove(indexOfA);
            }

            int indexOfB = values.indexOf(that.b);
            if (indexOfB >= 0) {
                values.remove(indexOfB);
            }

            int indexOfC = values.indexOf(that.c);
            if (indexOfC >= 0) {
                values.remove(indexOfC);
            }

            return values.isEmpty();
        }

        @Override
        public int hashCode() {
            Integer sum = a * b * c;
            return sum.hashCode();
        }
    }

    public List<List<Integer>> findIndexesToSum(int[] array) {
        if (array == null || array.length < 3) {
            return new ArrayList<>();
        }

        Set<SumIndexes> indexes = new HashSet<>();

        for (int sumIndex = 0; sumIndex < array.length; sumIndex++) {
            this.addIndexesToSum(array, sumIndex, indexes);
        }

        ArrayList<List<Integer>> results = new ArrayList<>();
        for (SumIndexes sumIndexes : indexes) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(sumIndexes.a);
            result.add(sumIndexes.b);
            result.add(sumIndexes.c);
            results.add(result);
        }

        return results;
    }

    private void addIndexesToSum(int[] array, int sumIndex, Set<SumIndexes> indexes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = -array[sumIndex];

        for (int i=0; i<array.length; i++) {
            if (i == sumIndex) {
                continue;
            }

            int val = array[i];

            Integer complementaryIndex = map.get(val);
            if (complementaryIndex == null) {
                map.put(sum - val, i);
            }
            else {
                SumIndexes sumIndexes = new SumIndexes(array[complementaryIndex], val, -sum);
                indexes.add(sumIndexes);
            }
        }
    }

    /*
        Solution 2
        [-1, 0, 1, 2, -1, -4]

        Questions:
        - Does the array fit in memory? Yes
        - Can I choose the same element multiple times? No



        - Time O(N^2) Space O(N)
        - Ordino l'array O(n log n)
        - Per ogni valore dell'array O(n)
            - Considero l'array che comincia all'indice successivo di questo elemento
            - Trovare tutte le coppie di indici la cui somma è uguale ad un certo valore O(n)
                - Parto con due indici, uno all'inizio ed uno alla fine dell'array e
                    - se la differenza è < 0 start += 1
                    - se la differenza è > 0 end -= 1
                    - se la differenza e == 0 allora ho trovato una tripla
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            int start = i + 1;
            int end = nums.length - 1;
            int target = -nums[i];

            if((i >= 1 && nums[i - 1] == nums[i]) || nums[i] > 0) continue;

            while(start < end) {
                int sum = nums[start] + nums[end];
                if(sum < target) start++;
                else if(sum > target) end--;
                else {

                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    res.add(temp);

                    while(start < end && nums[start] == nums[start + 1]) start++;
                    while(start < end && nums[end] == nums[end - 1]) end--;
                    start++;end--;

                }
            }
        }
        return res;
    }
}
