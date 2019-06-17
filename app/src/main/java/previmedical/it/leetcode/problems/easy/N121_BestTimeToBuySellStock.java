package previmedical.it.leetcode.problems.easy;

import android.util.Log;

public class N121_BestTimeToBuySellStock {

    /*

        Say you have an array for which the ith element is the price of a given stock on day i.

        If you were only permitted to complete at most one transaction
        (i.e., buy one and sell one share of the stock),
        design an algorithm to find the maximum profit.

        Note that you cannot sell a stock before you buy one.

        Example 1:
        Input: [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
                     Not 7-1 = 6, as selling price needs to be larger than buying price.

        Example 2:
        Input: [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transaction is done, i.e. max profit = 0.

     */




    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i=0; i<prices.length; i++) {
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public void test() {
        int[] array1 = {7,1,5,3,6,4};
        int output1 = this.maxProfit(array1);
        Log.w("test","output1: " + output1 + " ==? 5");

        int[] array2 = {7,6,4,3,1};
        int output2 = this.maxProfit(array2);
        Log.w("test","output2: " + output2 + " ==? 0");
    }
}
