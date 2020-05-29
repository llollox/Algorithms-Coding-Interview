package com.llollox.algorithms.problems.crack.dynamic;

public class Coins {


    /*

        Solution 1.

        T O(r/25 * r/10 * r/5)
        2 * 4 * 7 = 56

        - Se ricevo un r == 0 significa che sono arrivato in fondo quindi ritorno 1
        - Se tutti i centesimi rimanenti sono a zero significa che posso solo aggiungere monetine da 1
          pertanto ho solo una possibilità e ritorno 1.
        - Per tutte le monetine rimanenti provo a calcolare tutte le possibili combinazioni e le sommo.

        coins(r, n10, n5) = Tutti i modi per fare r con al più n10 monete da 10 e n5 monete da 5.
            se (r == 0 || n10 == 0 && n5 == 0)
                return 1

         5: coins(5, 0, 1) = coins(5, 0, 0) + coins(0, 0, 0)


        10:
            - Monete da 10 [0..1]

                - 0: coins(10, 0, 2) = coins(10, 0, 0) + coins(5, 0, 0) + coins(0, 0, 0)

                - 1: coins(0, 0, 0)

        20:
            - Monete da 10: [0..2]

                - 0: Tutti i modi per fare 20 con monete da 5 e da 1.   coins(20, 0, 4)

                    - 4: coins(0, 0, 0) // 1        5 5 5 5
                    - 3: coins(5, 0, 0) // 1        5 5 5 11111
                    - 2: coins(10, 0, 0) // 1       5 5 11111 11111
                    - 1: coins(15, 0, 0) // 1       5 11111 11111 11111
                    - 0: coins(0, 0, 0) // 1        11111 11111 11111 11111


                - 1: coins(10, 0, 4) = coins(10, 0, 2)

                    - 0: coins(10, 0, 0) // 1       10 11111 11111
                    - 1: coins(5, 0, 0)  // 1       10 5 11111
                    - 2: coins(0, 0, 0) // 1        10 5 5

                - 2: coins(0, 0, 4) = 1   10,10
     */

    public int coins(int r) {
        if (r <= 0) {
            return 0;
        }

        return this.coinsHelper(r, r / 25, r / 10, r / 5);
    }

    private int coinsHelper(int r, int n25, int n10, int n5) {

        if (r == 0 || (n25 == 0 && n10 == 0 && n5 == 0)) {
            return 1;
        }

        int count = 0;

        for (int i = n25; i > 0; i--) {
            int diff = r - 25 * i;
            count += this.coinsHelper(diff, 0, diff / 10, diff / 5);
        }

        for (int i = n10; i > 0; i--) {
            int diff = r - 10 * i;
            count += this.coinsHelper(diff, 0, 0, diff / 5);
        }

        return count + (n5 + 1);
    }



    /*

        Solution2.
        T  O(log25(r) * log10(r) * log5(r)) = O(log^3(r))

        Resto 100

        Monete da 25:
            - 0: 100, senza monete da 25
            - 1: 75, senza monete da 25
            - 2: 50, senza monete da 25
            - 3: 25, senza monete da 25
            - 4: 0
     */


    public int coinsVector(int r) {
        if (r <= 0) {
            return 0;
        }

        int[] dimens = {25, 10, 5, 1};
        Counter c = new Counter();
        return this.coinsHelperVector(r, dimens, 0, c);
    }

    class Counter {
        public int k = 0;
    }

    public int coinsHelperVector(int r, int[] dimens, int index, Counter k) {

        k.k += 1;
        System.out.println(k.k + ": c(" + r + ", " + index + ")");

        if (r == 0 || index == dimens.length - 1) {
            return 1;
        }

        int dimen = dimens[index];

        int count = 0;

        for (int i = 0; i * dimen <= r; i++) {
            int rem = r - i * dimen;
            count += this.coinsHelperVector(rem, dimens, index + 1, k);
        }

        return count;
    }


    /*

        Solution. 3 Memoization
        T O(r/25 + r/10 + r/5)
     */

    public int coinsMemo(int r) {
        if (r <= 0) {
            return 0;
        } else if (r < 5) {
            return 1;
        }

        int[] dimens = {25, 10, 5, 1};
        int[][] memo = new int[r + 1][dimens.length - 1];
        return this.coinsMemo(r, dimens, 0, memo);
    }

    // Better because fill memo for each iteration
    private int coinsMemo(int r, int[] dimens, int index, int[][] memo) {
        if (r == 0 || index == dimens.length - 1) {
            return 1;
        }

        int dimen = dimens[index];

        int count = 0;

        for (int i = 0; i * dimen <= r; i++) {
            int rem = r - i * dimen;

            int v = memo[rem][index];
            if (v <= 0) {
                v = this.coinsMemo(rem, dimens, index + 1, memo);
                memo[rem][index] = v;
            }

            count += v;
        }

        return count;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    int coinsReImplemented(int r) {
        int[] dimens = {25, 10, 5, 1};
        return coinsHelper(r, 0, dimens);
    }

    private int coinsHelper(int r, int index, int[] dimens) {
        if (index == dimens.length - 1) {
            return 1;
        }

        int count = 0;
        for (int i=0; i * dimens[index] <= r; i++) {
            count += coinsHelper(r - dimens[index] * i, index + 1, dimens);
        }
        return count;
    }

    int coinsReImplementedMemo(int r) {
        int[] dimens = {25, 10, 5, 1};
        int[][] memo = new int[r + 1][dimens.length - 1];
        return coinsHelper(r, 0, dimens);
    }

    private int coinsHelperMemo(int r, int index, int[] dimens, int[][] memo) {
        if (index == dimens.length - 1) {
            return 1;
        }

        if (memo[r][index] > 0) {
            return memo[r][index];
        }

        int count = 0;
        for (int i=0; i * dimens[index] <= r; i++) {
            count += coinsHelper(r - dimens[index] * i, index + 1, dimens);
        }

        memo[r][index] = count;
        return count;
    }

    /*
        DP[index][r] =

           sum DP[r - i * dimens[index]][index - 1]
     */
    int coinsDP(int r) {
        if (r <= 0) {
            return 0;
        }

        int[] dimens = {1, 5, 10, 25};
        int[]DP = new int[r + 1];

        // Setto 1 per la prima riga.
        // Se ho solo la moneta da 1, ho un solo modo per fare qualunque numero
        for (int i=0; i<=r; i++) {
            DP[i] = 1;
        }

        for (int dimIndex=1; dimIndex<dimens.length; dimIndex++) {
            int[] newDP = new int[r + 1];

            int coin = dimens[dimIndex];
            for (int value=0; value<=r; value++) {
                int sum = 0;
                for (int c = 0; c * coin <= value; c++) {
                    sum += DP[value - c * coin];
                }

                newDP[value] = sum;
            }

            DP = newDP;
        }

        return DP[r];
    }
}
