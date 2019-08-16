package previmedical.it.leetcode.problems.other;

public class NumSubsets {

    /*
    Given an array of positive, non duplicated, sorted integers, and a number,
    return the number of all subsets that adds up to that value.

    [2, 4, 6, 10], sum = 16
    Output. 2 because {[2,4,10], [6,10]}

     */

    public int numSubsets(int[] array, int sum) {
        return numSubsets(array, sum, 0);
    }

    private int numSubsets(int[] array, int sum, int index) {
        if (sum == 0) {
            return 1;
        }
        else if (sum < 0|| index == array.length) {
            return 0;
        }
        else {
            int value = array[index];
            return numSubsets(array, sum - value, index + 1) +
                    numSubsets(array, sum, index + 1);
        }
    }

    public int numSubsetsWithMemoization(int[] array, int sum) {
        int[][] matrix = new int[array.length][sum + 1];
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<sum + 1; j++) {
                matrix[i][j] = -1;
            }
        }
        return numSubsetsWithMemoization(array, sum, 0, matrix);
    }

    private int numSubsetsWithMemoization(int[] array, int sum, int index, int[][] matrix) {
        if (sum == 0) {
            return 1;
        }
        else if (sum < 0|| index == array.length) {
            return 0;
        }
        else {
            int value = array[index];

            if (matrix[index][sum] == -1) {
                matrix[index][sum] = numSubsetsWithMemoization(array, sum, index + 1, matrix);
            }

            if (sum >= value) {
                if (matrix[index][sum - value] == -1) {
                    matrix[index][sum - value] = numSubsetsWithMemoization(array, sum - value, index + 1, matrix);
                }

                return matrix[index][sum - value] + matrix[index][sum];
            }
            else {
                return matrix[index][sum];
            }
        }
    }

}
