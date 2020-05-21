package com.llollox.algorithms.problems.crack.strings;

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

    /*
        L'approccio si basa sul far saltare il puntatore di n posizioni alla volta.
        int start = 0
        int end = n - 1
        se start >= end - 1 -> ho finito perche' sono arrivato ad una matrice vuota o con un elemento solo
        altrimenti:
            [start,start] -> [start, end]
            [start,end] -> [end, end]
            [end, end] -> [end, start]
            [end,start] -> [start, start]

            // next = [start,end]
            // [start,end] = [start, start]

            // copy = [end, end]
            // [end, end] = next
            // next = copy

            // copy = [end, start]
            // [end, start] = next
            // next = copy

            // [start, start] = next



        Ad ogni iterazione start += 1 & end -= 1
        1   2   3   4   5       1   1   1   1   1
        1   2   3   4   5       2   2   2   2   2
        1   2   3   4   5       3   3   3   3   3
        1   2   3   4   5       4   4   4   4   4
        1   2   3   4   5       5   5   5   5   5
     */

    public int[][] rotateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return matrix;
        }

        int n = matrix.length;
        for (int start=0; start<n/2; start++) {
            int end = n - (start + 1);
            if (start >= end) {
                break;
            }

            for (int j=start; j<end; j++) {
                int top = matrix[start][start + j];

                // left -> top
                matrix[start][start + j] = matrix[end - j][start];

                // bottom -> left
                matrix[end - j][start] = matrix[end][end - j];

                // right -> bottom
                matrix[end][end - j] = matrix[start + j][end];

                // right -> top
                matrix[start + j][end] = top;
            }
        }

        return matrix;
    }
}
