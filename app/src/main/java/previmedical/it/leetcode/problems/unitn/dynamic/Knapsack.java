package previmedical.it.leetcode.problems.unitn.dynamic;

public class Knapsack {


    /*

        Tabella grande n * capacity.
        Nelle colonne della tabella ho i vari oggetti.
        Nelle righe ho la capacità. Da 0 a capacity.

        La prima riga e' tutta a zero perche con capacita' zero non ci sta nulla.
        La prima colonna e' zero perche se non prendo nessun oggetto, il profitto e' zero.


        S[i,j] e' il profitto massimo ottenuto considerando i primi i oggetti e con capacita' j.

        S[i,j] = max(S[i-1, j], S[i, j-w[i]] + p[i])


        w[i] = [4,2,3,4]
        p[i] = [10,7,8,6]
        c = 9


            0  1  2  3  4  5  6  7  8  9  c

     i  0   0  0  0  0  0  0  0  0  0  0

        1   0  0  0  0  10 10 10 10 10 10

        2   0  0  7  7  10 10 17 17 17 17

        3   0  0  7  8  10 15 17 18 18 25

        4   0  0  7  8  10 15 17 18 18 25


     */

    public int maxProfit(int[] weights, int[] profits, int capacity) {

        int n = weights.length;

        int[][] dp = new int[n+1][capacity+1];

        for (int i=1; i<=n; i++) {

            int weight = weights[i - 1];

            for (int j=1; j<=capacity; j++) {

                int c = j - weight;
                int newValue = c >= 0 ? dp[i-1][c] + profits[i - 1] : Integer.MIN_VALUE;

                dp[i][j] = Math.max(dp[i-1][j], newValue);
            }
        }

        return dp[n][capacity];
    }

}
