package previmedical.it.leetcode.problems.crack.moderate;

import java.util.ArrayList;
import java.util.List;

public class PondSizes {

    /*

        You have an integer matrix representing a plot of land,
        where the value at that location represents the height above sea level.
        A value of zero indicates water.
        A pond is a region of water connected vertically, horizontally, or diagonally.
        The size of the pond is the total number of connected water cells.
        Write a method to compute the sizes of all ponds in the matrix.

        EXAMPLE
        Input:

        0210
        0101
        1101
        0101

        Output: 2, 4, 1 (in any order)

     */


    public List<Integer> getPondSizes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }

        ArrayList<Integer> pondSizes = new ArrayList<>();

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                if(matrix[i][j] == 0) {
                    int pondSize = getPondSize(matrix, i, j);
                    pondSizes.add(pondSize);
                }
            }
        }

        return pondSizes;
    }

    private int getPondSize(int[][] matrix, int i, int j) {
        if (i < matrix.length - 1) {
            int count = 0;
            if (matrix[i + 1][j] == 0) {
                markAsVisited(matrix, i+1,j);
                count += getPondSize(matrix, i + 1, j);
            }

            if (j >= 1 && matrix[i + 1][j - 1] == 0) {
                markAsVisited(matrix, i+1,j - 1);
                count += getPondSize(matrix, i + 1, j - 1);
            }

            if (j < matrix.length - 1 && matrix[i + 1][j + 1] == 0) {
                markAsVisited(matrix, i+1,j + 1);
                count += getPondSize(matrix, i + 1, j + 1);
            }

            return count + 1;
        }
        else {
            return 1;
        }
    }

    private void markAsVisited(int[][] matrix, int i, int j) {
        matrix[i][j] = Integer.MIN_VALUE;
    }

}
