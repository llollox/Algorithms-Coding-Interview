package com.llollox.algorithms.problems.crack.strings;

import java.util.BitSet;

public class ZeroMatrix {

    /*
        Zero Matrix: Write an algorithm such that if an element
        in an MxN matrix is 0, its entire row and column are set to 0.
     */

    /*
        Creo due bitset, 1 per le righe ed 1 per le colonne
        Scorro tutta la matrice e quando trovo 1 zero setto a True
        i bitset di riga e colonna corrispondenti.

        Cancello tutte le righe e colonne dove il bitset è a True
     */

    // Time O(n * m) Space O(n + m)
    public int[][] nullify(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        BitSet rowsBitSet = new BitSet(rows);
        BitSet colsBitSet = new BitSet(cols);

        for (int r=0; r<rows;r++) {
            for(int c=0; c<cols; c++) {
                if (matrix[r][c] == 0) {
                    rowsBitSet.set(r, true);
                    colsBitSet.set(c, true);
                }
            }
        }

        for (int r=0; r<rows; r++) {
            if (rowsBitSet.get(r)) {
                nullifyRow(matrix, r);
            }
        }

        for (int c=0; c<cols; c++) {
            if (colsBitSet.get(c)) {
                nullifyCol(matrix, c);
            }
        }

        return matrix;
    }

    // Nullify Improved
    // T: O(n * m) S: O(1)
    public int[][] nullifyImproved(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        int firstNullableRow = -1;
        int firstNullableCol = -1;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (matrix[r][c] == 0) {
                    firstNullableRow = r;
                    firstNullableCol = c;
                    break;
                }
            }
        }

        if (firstNullableCol == -1) {
            return matrix; // no zero found;
        }

        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[firstNullableRow][c] = 0;
                    matrix[r][firstNullableCol] = 0;
                }
            }
        }

        for (int r=0; r<rows; r++) {
            if (matrix[r][firstNullableCol] == 0 && r != firstNullableRow) {
                nullifyRow(matrix, r);
            }
        }

        for (int c=0; c<cols; c++) {
            if (matrix[firstNullableRow][c] == 0) {
                nullifyCol(matrix, c);
            }
        }

        nullifyRow(matrix, firstNullableRow);

        return matrix;
    }

    private void nullifyCol(int[][] matrix, int c) {
        int rows = matrix.length;
        for (int i = 0; i<rows; i++) {
            matrix[i][c] = 0;
        }
    }

    private void nullifyRow(int[][] matrix, int r) {
        int cols = matrix[0].length;
        for (int j = 0; j<cols; j++) {
            matrix[r][j] = 0;
        }
    }
}
