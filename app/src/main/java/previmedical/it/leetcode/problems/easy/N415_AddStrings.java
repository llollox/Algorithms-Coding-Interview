package previmedical.it.leetcode.problems.easy;

import android.util.Log;

public class N415_AddStrings {

    /*
        Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

        Note:

        The length of both num1 and num2 is < 5100.
        Both num1 and num2 contains only digits 0-9.
        Both num1 and num2 does not contain any leading zero.
        You must not use any built-in BigInteger library or convert the inputs to integer directly.
     */

    /*
        Solution.

        O(s) where s is the length of the longest string.

        Start from the end of both strings with two pointers.
        s1index = s1.length - 1 & s2index = s2.length - 1;

        Decrease the pointer until the end of each string and
        I try to sum two digits each time taking into account of the carry.

        I use a SB in order to avoid new instance of strings each iteration.
     */

    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();

        int indexS1 = num1.length()-1;
        int indexS2 = num2.length()-1;

        int current = 0;


        while (indexS1 >= 0 || indexS2 >= 0 || current > 0) {

            if (indexS1 >= 0) {
                current += this.map(num1.charAt(indexS1));
            }

            if (indexS2 >= 0) {
                current += this.map(num2.charAt(indexS2));
            }

            int digit = current % 10;
            sb.append(digit);

            current = current / 10;

            indexS1--;
            indexS2--;
        }

        sb.reverse();

        return sb.toString();
    }

    private int map(char c) {
        switch (c) {
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            default: throw new RuntimeException("Unknown char");
        }
    }

    public void test() {
        String output1 = this.addStrings("0", "0");
        Log.w("TEST", output1);
    }
}
