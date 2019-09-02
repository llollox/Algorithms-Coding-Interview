package com.llollox.algorithms.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class N611_ValidTriangleNumber {

    /*

        Given an array consists of non-negative integers, your task is to count the number of triplets
        chosen from the array that can make triangles if we take them as side lengths of a triangle.
        In order to be a valid triangle, the sum of the two shorter sides, must be greater than the longest side.

        Example 1:

        Input: [2,2,3,4]
        Output: 3

        Explanation:
        Valid combinations are:
        2,3,4 (using the first 2)
        2,3,4 (using the second 2)
        2,2,3



        Note:
        The length of the given array won't exceed 1000.
        The integers in the given array are in the range of [0, 1000].

     */


    public int numCombinations(int[] array) {
        if (array == null || array.length < 3) {
            return 0;
        }

        Arrays.sort(array);

        int[] memo = new int[array.length];
        for (int i=0; i<memo.length; i++) {
            memo[i] = -1;
        }

        return numCombinations(array, 0, new ArrayList<Integer>());
    }

    // memo[i] è il numero di combinazioni possibili

    // [2,2,3,4]
    private int numCombinations(int[] array, int index, ArrayList<Integer> sides) {
        if (sides.size() == 2) {
            int count = 0;
            int i = index;
            int sum = sides.get(0) + sides.get(1);

            while (i < array.length && sum > array[i]) {
                count += 1;
                i += 1;
            }

            return count;
        }

        if (index == array.length) {
            return 0;
        }

        sides.add(array[index]);
        int withElementI = numCombinations(array, index + 1, sides);
        sides.remove(sides.size() - 1);

        int withoutElementI = numCombinations(array, index + 1, sides);

        return withElementI + withoutElementI;
    }

    /*
        Approach 2:
        - Ordino l'array in ordine: [2, 2, 3, 4]
        - Creo tutte le coppie di indici i, j
        - Per ogni coppia parto da j + 1 e cerco di trovare quanti numeri la somma è > del valore i esimo.
     */

    public int numCombinationsIterative(int[] array) {
        if (array == null || array.length < 3) {
            return 0;
        }

        Arrays.sort(array);

        int count = 0;

        for (int i=0; i<array.length; i++) {
            for (int j = i + 1; j<array.length; j++) {

                int sum = array[i] + array[j];
                int k = j + 1;
                while (k < array.length && sum > array[k]) {
                    count += 1;
                    k += 1;
                }
            }
        }

        return count;
    }

    /*
        Approach 3:
                                               r
                                              l
        - Ordino l'array in ordine: [1, 1, 1, 2, 2, 3, 4]
        - Scorro l'array al contrario considerando. Per ogni n:
            - La somma dei due numeri precedenti dev'essere maggiore di n.
            - Parto con due indici all'inizio e fine dell'array rimanente
            - Fintanto che l < r
                - Calcolo la somma:
                    - Se è <= n:
                        l += 1;
                    - Se è > n:
                        count += 1;
                        r -= 1;
     */


    /*
            r
         l
               t
        [2,2,3,4]
     */

    // [2,2,3,4]
    public int numCombinationsOptimal(int[] array) {
        if (array == null || array.length < 3) {
            return 0;
        }

        Arrays.sort(array);

        int count = 0;

        for (int i=array.length - 1; i >= 2; i--) {

            int target = array[i];

            int left = 0;
            int right = i - 1;

            while (left < right) {

                int sum = array[left] + array[right];
                if (sum <= target) {
                    left += 1;
                }
                else {
                    count +=right - left;
                    right -=1;
                }
            }
        }

        return count;
    }

}
