package com.llollox.algorithms.problems.crack.sorting;

public class SortedMatrixSearch {

    public static class Coordinate {
        int row;
        int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public Coordinate findElement(int[][] matrix, int n) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows > cols) {
            return bsOnRows(matrix, n, rows, cols);
        } else {
            return bsOnCols(matrix, n, rows, cols);
        }
    }

    private Coordinate bsOnRows(int[][] matrix, int n, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] <= n && matrix[i][cols - 1] >= n) {
                int result = bs(matrix[i], n, 0, cols);
                if (result >= 0) {
                    return new Coordinate(i, result);
                }
            }
        }
        return null;
    }

    private Coordinate bsOnCols(int[][] matrix, int n, int rows, int cols) {
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] <= n && matrix[rows - 1][j] >= n) {
                int result = bsCol(matrix, n, j, 0, rows);
                if (result >= 0) {
                    return new Coordinate(result, j);
                }
            }
        }
        return null;
    }


    private int bsCol(int[][] matrix, int n, int col, int start, int end) {
        if (start >= end) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midValue = matrix[midIndex][col];

        if (midValue == n) {
            return midIndex;
        } else if (n < midValue) {
            return bsCol(matrix, n, col, start, midIndex);
        } else {
            return bsCol(matrix, n, col, midIndex + 1, end);
        }
    }

    private int bs(int[] array, int n, int start, int end) {
        if (start >= end) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];

        if (midValue == n) {
            return midIndex;
        } else if (n < midValue) {
            return bs(array, n, start, midIndex);
        } else {
            return bs(array, n, midIndex + 1, end);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    Coordinate findElementImproved(int[][] matrix, int n) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int value = matrix[row][col];

            if (value == n) {
                return new Coordinate(row, col);
            } else if (value > n) {
                col--;
            } else {
                row++;
            }
        }

        return null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // TO BE COMPLETED
//    Coordinate int findCoordinates(int[][] matrix, int n) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return null;
//        }
//
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//    }
//
//    private Coordinate bsDiagonal(int[][] matrix, int n, int rowStart, int rowEnd, int colStart, int colEnd) {
//
//    }
//
//    private int findDiagonalIntersection(int[][] matrix, int n) {
//        int diagonal = 0;
//        while (diagonal < rows - 1
//                && diagonal < cols - 1
//                && matrix[diagonal][diagonal] <= n
//                && matrix[diagonal + 1][diagonal + 1] >= n) {
//            diagonal++;
//        }
//
//        if (diagonal == rows -1 || diagonal == cols - 1) {
//            return -1;
//        }
//    }

}
