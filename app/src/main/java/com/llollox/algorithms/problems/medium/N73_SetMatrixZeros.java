package com.llollox.algorithms.problems.medium;

public class N73_SetMatrixZeros {

    /*
        Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

        Example 1:

        Input:
        [
          [1,1,1],
          [1,0,1],
          [1,1,1]
        ]
        Output:
        [
          [1,0,1],
          [0,0,0],
          [1,0,1]
        ]
        Example 2:

        Input:
        [
          [0,1,2,0],
          [3,4,5,2],
          [1,3,1,5]
        ]
        Output:
        [
          [0,0,0,0],
          [0,4,5,0],
          [0,3,1,0]
        ]
     */

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                clearRow(matrix, i);
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                clearCol(matrix, j);
            }
        }
    }


    private void clearRow(int[][]matrix, int row) {
        int size = matrix[row].length;
        for (int j=0; j<size; j++) {
            matrix[row][j] = 0;
        }
    }

    private void clearCol(int[][]matrix, int col) {
        int size = matrix.length;
        for (int i=0; i<size; i++) {
            matrix[i][col] = 0;
        }
    }
}
