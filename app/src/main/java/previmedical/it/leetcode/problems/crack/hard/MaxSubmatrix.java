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

    public Matrix maxSubMatrixNaive(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        Matrix max = null;

        for (int row1=0; row1 < rowCount; row1++) {
            for (int col1=0; col1 < colCount; col1++) {

                for (int row2=row1; row2 < rowCount; row2++) {
                    for (int col2=col1; col2 < colCount; col2++) {

                        int sum = getSum(row1, col1, row2, col2, matrix);
                        if (max == null || max.sum < sum) {
                            max = new Matrix(row1, col1, row2, col2, sum);
                        }
                    }
                }
            }
        }

        return max;
    }


    private int getSum(int row1, int col1, int row2, int col2, int[][]matrix) {
        int sum = 0;
        for (int i=row1; i<= row2; i++) {
            for (int j=col1; j<=col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    // ***************************************************************************************************
    /*
        Time O(#COLS^2 * #ROWS)
        - Mi creo una matrice delle somme sumMatrix in cui:
            - sumMatrix[i][j] = la somma della riga i esima fino al valore j

        - Per ogni larghezza a partire da 1 fino ad #COLS:
            - Per ogni valore di j:
                - Scorro tutta la matrice da i = 0 fino ad #ROWS tenendo conto del massimo
                - Se arrivo a 0 allora resetto e riparto da capo con la nuova riga
     */

    public Matrix maxSubMatrixOptimal(int[][] matrix) {
        int[][] sumMatrix = this.buildSumMatrix(matrix);
        int rows = matrix.length; // R
        int cols = matrix[0].length; // C
        Matrix max = null;
        for (int l=0;l<cols; l++) {                   // C

            for (int j=0; j<cols - l; j++) {          // C
                int sum = 0;
                int startI = 0;
                for (int i=0; i<rows; i++) {          // R
                    sum += getRowSum(i, j, l, sumMatrix); // 1

                    if (sum <= 0) {
                        sum = 0;
                        startI = i + 1;
                    }
                    else if (max == null || max.sum < sum) {
                        max = new Matrix(startI, j, i, j + l, sum);
                    }
                }
            }
        }

        return max;
    }

    private int getRowSum(int i, int j, int l, int[][] sumMatrix) {
        int cols = sumMatrix[0].length;
        int total = sumMatrix[i][cols - 1];
        int sumBefore = j > 0 ? sumMatrix[i][j - 1] : 0;
        int sumAfter = j + l >= sumMatrix[0].length ? 0 : total - sumMatrix[i][j + l];
        return total - (sumBefore + sumAfter);
    }

    private int[][] buildSumMatrix(int[][] matrix) {
        int[][] sumMatrix = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {                  // R
            int sum = 0;
            for (int j=0; j<matrix[0].length; j++) {           // C
                sum += matrix[i][j];
                sumMatrix[i][j] = sum;
            }
        }
        return sumMatrix;
    }
}
