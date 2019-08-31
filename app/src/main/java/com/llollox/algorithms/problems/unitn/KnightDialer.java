package com.llollox.algorithms.problems.unitn;

import java.util.LinkedList;
import java.util.Queue;

public class KnightDialer {

    public int knightDialer(int start, int numHops) {

        if (numHops == 0) {
            return 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        for (int i=0;i<numHops-1; i++) {
            int size = queue.size();
            for (int j=0; j<size; j++) {

                for (int hop: this.nextHops(queue.poll())) {
                    queue.add(hop);
                }
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            count += this.countNextHops(queue.poll());
        }

        return count;
    }


    public int knightDialerMemoization(int start, int numHops) {

        int[][] dp = new int[numHops][10];

        return this.knightDialerMemoization(start, numHops, dp);
    }


    public int knightDialerMemoization(int start, int numHops, int[][] dp) {

        if (numHops == 0) {
            return 1;
        }

        if (dp[numHops - 1][start] > 0) {
            return dp[numHops - 1][start];
        }

        int count = 0;

        for (int hop : this.nextHops(start)) {
            count += this.knightDialerMemoization(hop, numHops - 1, dp);
        }

        dp[numHops - 1][start] = count;

        return count;
    }

    public int knightDialerDp(int start, int numHops) {

        int[] prev = {1,1,1,1,1,1,1,1,1,1};
        int[] current = new int[10];

        for (int i=0; i<numHops; i++) {

            for (int j=0; j<10; j++) {

                for (int hop: this.nextHops(j)) {
                    current[j] += prev[hop];
                }

            }

            prev = current;
        }

        return current[start];
    }


    public int knightDialerRecursive(int start, int numHops) {

        if (numHops == 0) {
            return 1;
        }

        int count = 0;
        for (int hop : this.nextHops(start)) {
            count += this.knightDialerRecursive(hop, numHops -1);
        }

        return count;
    }


//
//    def count_sequences(start_position, num_hops):
//            # Start off with a 10x10 identity matrix
//    accum = [[1 if i == j else 0 for i in range(10)] for j in range(10)]
//
//            # bin(num_hops) starts with "0b", slice it off with [2:]
//            for bit_num, bit in enumerate(reversed(bin(num_hops)[2:])):
//            if bit_num == 0:
//            import copy
//            power_of_2 = copy.deepcopy(NEIGHBORS_MATRIX)
//        else:
//    power_of_2 = matrix_multiply(power_of_2, power_of_2)
//
//        if bit == '1':
//    accum = matrix_multiply(accum, power_of_2)
//
//    return matrix_multiply(accum, [[1]]*10)[start_position][0]

    public int knightDialerMatrix(int start, int numHops) {

        int[][] accum = new int[10][10];

        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                accum[i][j] = i == j ? 1 : 0;
            }
        }

        return 1;
    }






/*
        3 * 2 X 2 * 3 = 3 * 3

        1  2   X   1  2  3    =>    1 * 1 + 2 * 4    1 * 2 + 2 * 5    1 * 3 + 2 * 6
        3  4       4  5  6    =>    3 * 1 + 4 * 5    3 * 2 + 4 * 5    3 * 3 + 4 * 6
        5  6                  =>    5 * 1 + 6 * 4    5 * 2 + 6 * 5    5 * 3 + 6 * 6



 */

    private int[][] matrixMultiplication(int[][] A, int[][] B) {

        int Arows = A.length;

        int Brows = B.length;
        int Bcols = B[0].length;

        int[][] result = new int[Arows][Bcols];

        for (int row=0; row<Arows; row++) {
            for (int col=0; col< Bcols; col++) {
                for (int i = 0; i< Brows; i++) {
                    result[row][col] += A[row][i] * B[i][col];
                }
            }
        }

        return result;
    }





    private int countNextHops(int current) {
        switch (current) {
            case 4: return 3;
            case 6: return 3;
            case 5: return 0;
            default: return 2;
        }
    }

    private int[] nextHops(int current) {
        switch (current) {
            case 1: return new int[]{6, 8};
            case 2: return new int[]{7, 9};
            case 3: return new int[]{4, 8};
            case 4: return new int[]{3, 9, 0};
            case 5: return new int[]{};
            case 6: return new int[]{1, 7, 0};
            case 7: return new int[]{2, 6};
            case 8: return new int[]{1, 3};
            case 9: return new int[]{4, 2};
            case 0: return new int[]{4, 6};
            default: throw new RuntimeException("Unknown hop");
        }
    }

}
