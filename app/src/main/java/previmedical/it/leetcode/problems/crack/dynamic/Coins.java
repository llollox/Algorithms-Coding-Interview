package previmedical.it.leetcode.problems.crack.dynamic;

public class Coins {


    /*

        Solution 1.   T = O(log25(r) * log10(r) + log10(r)) = O(log^2(r))

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

        for (int i=n25; i> 0; i--) {
            int diff = r - 25 * i;
            count += this.coinsHelper(diff, 0, diff / 10, diff / 5);
        }

        for (int i=n10; i> 0; i--) {
            int diff = r - 10 * i;
            count += this.coinsHelper(diff, 0, 0, diff / 5);
        }

        return count + (n5 + 1);
    }



    /*

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
        return this.coinsHelperVector(r, dimens, 0);
    }

    public int coinsHelperVector(int r, int[] dimens, int index) {
        if (r == 0 || index == dimens.length - 1) {
            return 1;
        }

        int dimen = dimens[index];

        int count = 0;

        for (int i=0; i * dimen <= r; i++) {
            int rem = r - i * dimen;
            count += this.coinsHelperVector(rem, dimens, index + 1);
        }

        return count;
    }
}
