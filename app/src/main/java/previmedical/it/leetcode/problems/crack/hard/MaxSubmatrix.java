package previmedical.it.leetcode.problems.crack.hard;

public class MaxSubmatrix {
    /*
        Given an NxN matrix of positive and negative integers,
        write code to find the sub matrix with the largest possible sum.
     */

    /*
        Questions:
        - Does it fit in memory? Yes
        - What if the matrix is null or empty? Return 0
        - What if the sum overflows? It doesn't happen, if it does use a BigInteger
     */

    /*
        Approach 1: O(N^6)
        - For each cell into the matrix: O(N^2)
            - For each dimension staring with 2 to N  O(N^2) // Perche potrebbe essere anche non quadrata
            - Calculate the sum                       O(N^2)
            - Take note of the max


        Approach 2 Sliding window: O(N^4) Space O(N^2)

        Come faccio a calcolare la somma di una sotto matrice in O(1), dati i, j, k, e la somma della matrice prima?
        - Mi creo una matrice di appoggio in cui ogni elemento mi salvo:
            - la sommatoria dei numeri che incontro partendo da i in colonna verso giu

        - Per sapere la somma della nuova matrice: (considero che la nuova matrice sia quella subito a dx) O(1)
            - Sottraggo dalla somma tutti gli elementi del bordo sinistro
            - Aggiungo la somma degli elementi del bordo destro

        - For each cell into the matrix: O(N^2)
            - For each dimension staring with 2 to N  O(N^2)
            - Calculate the sum                       O(1)
            - Take note of the max                    O(1)
     */


    public static class Matrix {
        public int topLeftI;
        public int topLeftJ;
        public int bottomRightI;
        public int bottomRightJ;
        public int sum;

        public Matrix(int topLeftI, int topLeftJ, int bottomRightI, int bottomRightJ, int sum) {
            this.topLeftI = topLeftI;
            this.topLeftJ = topLeftJ;
            this.bottomRightI = bottomRightI;
            this.bottomRightJ = bottomRightJ;
            this.sum = sum;
        }
    }

    public Matrix maxSubMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[][] sumMatrix = this.buildSumMatrix(matrix);

        Matrix max = null;

        for (int row1=0; row1 < rowCount; row1++) {
            for (int col1=0; col1 < colCount; col1++) {

                for (int row2=row1; row2 < rowCount; row2++) {
                    for (int col2=col1; col2 < colCount; col2++) {

                        int sum = getSum(row1, col1, row2, col2, sumMatrix);
                        if (max == null || max.sum < sum) {
                            max = new Matrix(row1, col1, row2, col2, sum);
                        }
                    }
                }
            }
        }

        return max;
    }
//
//    private int calculateSum(int i, int j, int rowLength, int colLength, int[][] sumMatrix) {
//
//
//    }
//
//    private int getColSum(int j, int start, int end, int[][] subMatrix) {
//        int total = subMatrix[0][j];
//        int sumFromStart = subMatrix[start][j];
//        int sumBeforeStart = total - sumFromStart;
//        int sumAfterEnd = end >= subMatrix.length ? 0 : subMatrix[end][j];
//        return total - (sumBeforeStart + sumAfterEnd);
//    }
//
//    private int getNextSum(int i, int j, int rowLength, int colLength, int[][] sumMatrix, int prevSum) {
//        int remove = this.getColSum(j - 1, i, (i + rowLength) - 1, sumMatrix);
//        int add = this.getColSum(j, i, (i + rowLength) - 1, sumMatrix);
//        return prevSum - remove + add;
//    }

    private int getSum(int row1, int col1, int row2, int col2, int[][] sumMatrix) {

    }

    private int[][] buildSumMatrix(int[][] matrix) {
        int[][] sumMatrix = new int[matrix.length][matrix[0].length];

        for (int j=0; j<matrix[0].length; j++) {
            for (int i=matrix.length - 1; i >= 0; i--) {

                int left = j > 0 ? sumMatrix[i][j - 1] : 0;
                int top= i > 0 ? sumMatrix[i- 1][j] : 0;
                int overlap = i > 0 && j> 0 ? sumMatrix[i-1][j-1] : 0;
                sumMatrix[i][j]=left + top - overlap + matrix[i][j];
            }
        }

        return sumMatrix;
    }
}
