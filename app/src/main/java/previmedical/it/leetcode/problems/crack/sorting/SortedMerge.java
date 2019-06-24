package previmedical.it.leetcode.problems.crack.sorting;

public class SortedMerge {

    /*
        You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
        Write a method to merge B into A in sorted order.

        TIME O(n + m)
    */


    public int[] sortedMerge(int[] A, int[] B, int lengthA, int lengthB) {

        if (B.length == 0) {
            return A;
        }

        int indexA = lengthA - 1;
        int indexB = lengthB - 1;
        int indexMerged = lengthB + lengthA - 1;

        while (indexB >= 0) {

            if (indexA >= 0 && A[indexA] > B[indexB]) {
                A[indexMerged] = A[indexA];
                indexA--;
            } else {
                A[indexMerged] = B[indexB];
                indexB--;
            }
            indexMerged--; // move indices
        }

        return A;
    }
}
