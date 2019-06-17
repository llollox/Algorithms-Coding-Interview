package previmedical.it.leetcode.problems.easy;

import android.util.Log;

public class N122_BestTimeToBuyAndSell2 {

    /*
        Say you have an array for which the ith element is the price of a given stock on day i.

        Design an algorithm to find the maximum profit.
        You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

        Note: You may not engage in multiple transactions at the same time
        (i.e., you must sell the stock before you buy again).

        Example 1:
        Input: [7,1,5,3,6,4]
        Output: 7
        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

        Example 2:
        Input: [1,2,3,4,5]
        Output: 4
        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time.
             You must sell before buying again.

        Example 3:
        Input: [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transaction is done, i.e. max profit = 0.

        [7,6,4,3,1,1000]
     */


    // Sommo solo quando il prezzo aumenta. Anche da oggi a domani.
    // Time O(n). Space O(1)

    public int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;

        for (int i=1;i<prices.length;i++) {

            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    public void test() {
        int[] array1 = {7,1,5,3,6,4};
        int output1 = this.maxProfit(array1);
        Log.w("TEST", output1 + " ==? 7");

        int[] array2 = {1,2,3,4,5};
        int output2 = this.maxProfit(array2);
        Log.w("TEST", output2 + " ==? 4");

        int[] array3 = {7,6,4,3,1};
        int output3 = this.maxProfit(array3);
        Log.w("TEST", output3 + " ==? 0");
    }
}
