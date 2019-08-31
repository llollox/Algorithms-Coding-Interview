package com.llollox.algorithms.problems.crack.hard;

public class MaxSquareMatrix {

    /*
        Imagine you have a square matrix, where each cell (pixel) is either black or white.
        Design an algorithm to find the maximum subsquare such that all four borders are filled with black pixels.
     */

    /*
        Questions
        Does the matrix fits in memory? Yes
        What if the matrix is null or empty? return null;
        What if the two dimensions of the matrix are not the same? return null;
        What is the return type? (3 int: top left corner and dimension)

        Solution 1. O(N^4)
        - Per ogni cella dell matrice O(N^2)
          - Per ogni dimensione di quadrato da N fino a max trovata fin ora. (potenzialmente 1) O(N)
          - Provo a verificare se quello è un quadrato con i lati neri: O(N)
            4 * N, perchè provo tutti i lati
          - Tengo traccia di quella con dimensione massima


        Solution 2. Time O(N^3 * log n) Space O(N)
        - Per ogni riga, calcolo l'inizio e fine di tutti gli intervalli neri. O(N)
        - La dimensione massima che posso provare è il numero elementi non vuoti per ogni riga

        - Per ogni colonna, calcolo l'inizio e fine di tutti gli intervalli neri. O(N)
        - La dimensione massima che posso provare è il numero elementi non vuoti per ogni riga

        - Per ogni IR O(N), prendo tutte le possibili combinazioni di indici e dimensione,: O(N^2):
            - Supponiamo al passo t, di avere posizione i,j e lunghezza k
            - Verifico se questo è un quadrato: O(log n)
                - Verificare se esiste un intervallo lungo k nella riga i + k  O(log n)
                - Verificare se eiste un intervallo lungo k nella colonna j che inizia dall'elemento i O(log n)
                - Verificare se eiste un intervallo lungo k nella colonna j + k che inizia dall'elemento i O(log n)

        - Ogni volta che trovo il massimo M, cerco per quadrati di dimensione M + 1


        Solution 3. Time O(N^3) Space O(N^2)
        - Mi calcolo una matrice in cui ad ogni cella tengo traccia del numero di neri sotto e a destra.
        - In questo modo il calcolo per sapere se è un quadrato diventa in tempo O(1) perchè dati i,j, k:
            - Verifico che nella cella [i,j] ci siano almeno k neri sotto e a destra
            - Verifico che nella cella [i+k, j] ci siano almeno k neri a destra
            - Verifico che nella cella [j, j+k] ci siano almeno k neri sotto

        - Applico quindi l'algoritmo come sopra ma in questo modo avendo la verifica del quadrato in O(1),
          il costo computazionale diventa O(N^3)
     */


    public static class Square {
        public int i;
        public int j;
        public int length;

        public Square(int i, int j, int length) {
            this.i = i;
            this.j = j;
            this.length = length;
        }
    }

    private static class DP {
        int numBlackBelow;
        int numBlackRight;

        public DP(int numBlackBelow, int numBlackRight) {
            this.numBlackBelow = numBlackBelow;
            this.numBlackRight = numBlackRight;
        }
    }

    // 1 is WHITE
    // 0 is BLACK
    public Square maxSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length != matrix.length) {
            return null;
        }


        DP[][] dp = this.buildDP(matrix);
        Square maxSquare = null;
        int n = matrix.length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {

                if (matrix[i][j] == 1) {
                    continue;
                }

                int length = n - j;
                while (length >= getMinDimension(maxSquare)) {

                    if (isSquare(i, j, length, dp)) {
                        maxSquare = new Square(i, j,length);
                        break;
                    }

                    length -= 1;
                }

            }
        }

        return maxSquare;
    }

    private int getMinDimension(Square square) {
        return square == null ? 1 : square.length + 1;
    }

    private DP[][] buildDP(int[][] matrix) {
        DP[][] dp = new DP[matrix.length][matrix.length];

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                dp[i][j] = new DP(0, 0);
            }
        }

        for (int i = 0; i< matrix.length; i++) {
            this.setNumBlackRight(matrix, dp, i);
        }

        for (int j = 0; j< matrix.length; j++) {
            this.setNumBlackBelow(matrix, dp, j);
        }

        return dp;
    }

    private void setNumBlackRight(int[][] matrix, DP[][] dp, int i) {
        int numBlackRight = 0;
        for (int j = matrix.length - 1; j>= 0; j--) {

            if (matrix[i][j] == 1) {
                numBlackRight = 0;
            }
            else if (matrix[i][j] == 0) {
                numBlackRight += 1;
            }

            dp[i][j].numBlackRight = numBlackRight;
        }
    }

    private void setNumBlackBelow(int[][] matrix, DP[][] dp, int j) {
        int numBlackBelow = 0;
        for (int i = matrix.length - 1; i>= 0; i--) {

            if (matrix[i][j] == 1) {
                numBlackBelow = 0;
            }
            else if (matrix[i][j] == 0) {
                numBlackBelow += 1;
            }

            dp[i][j].numBlackBelow = numBlackBelow;
        }
    }

    private boolean isSquare(int i, int j, int length, DP[][] dp) {
        int n = dp.length;

        int bottomIndex = (i + length) - 1;
        int rightIndex = (j + length) - 1;

        if ((i + length) - 1 >= n || (j + length) - 1 >= n) {
            return false;
        }

        return dp[i][j].numBlackBelow >= length
                && dp[i][j].numBlackRight >= length
                && dp[bottomIndex][j].numBlackRight >= length
                && dp[i][rightIndex].numBlackBelow >= length;
    }
}
