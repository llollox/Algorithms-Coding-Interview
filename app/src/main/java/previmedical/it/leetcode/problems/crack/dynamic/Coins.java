package previmedical.it.leetcode.problems.crack.dynamic;

public class Coins {


    public int coins(int r) {
        if (r <= 0) {
            return 0;
        }

        return this.coinsHelper(r, r / 25, r / 10, r / 5);
    }

    private int coinsHelper(int r, int n25, int n10, int n5) {

        if (r == 0 || (n10 == 0 && n5 == 0)) {
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
}
