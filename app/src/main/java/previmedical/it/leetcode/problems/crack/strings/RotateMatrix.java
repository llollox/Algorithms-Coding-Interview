package previmedical.it.leetcode.problems.crack.strings;

public class RotateMatrix {

    /*
        Given an image represented by an NxN matrix, where each pixel in the image is 4bytes,
        write a method to rotate the image by 90 degrees. Can you do this in place?

        1   2   3         7   4   1
        4   5   6   ->    8   5   2
        7   8   9         9   6   3


        1: [0][0]   ->  [0][2]
        2: [0][1]   ->  [1][2]
        3: [0][2]   ->  [2][2]

        4: [1][0]   ->  [0][1]
        5: [1][1]   ->  [1][1]
        6: [1][2]   ->  [2][1]

        7: [2][0]   ->  [0][0]
        8: [2][1]   ->  [1][0]
        9: [2][2]   ->  [2][0]


        i -> j
        j -> N - i

        7   2   1
        4   5   6
        9   8   3


        1   2   3   4   5       1   1   1   1   1
        1   2   3   4   5       2   2   2   2   2
        1   2   3   4   5       3   3   3   3   3
        1   2   3   4   5       4   4   4   4   4
        1   2   3   4   5       5   5   5   5   5


        [0,0]   [0,5]
        [0,5]   [5,5]
        [5,5]   [5,0]
        [5,0]   [0,0]

        [1,0]   [0,4]
        [0,4]   [4,5]
        [4,5]   [5,1]
        [5,1]   [1,0]

     */

    public int[][] rotateMatrix(int[][] matrix) {

        int n = matrix.length;

        for (int j=0; j<n; j++) {

            int first = matrix[j][0];

            int k = (n - 1) - j;

            int second = matrix[0][k];

            int third = matrix[k][n - 1];

            int fourth = matrix[n - 1][(n - 1) - k];


            matrix[j][0] = fourth;
            matrix[0][k] = first;
            matrix[k][n - 1] = second;
            matrix[n - 1][(n - 1) - k] = third;
        }

        return matrix;
    }
}
