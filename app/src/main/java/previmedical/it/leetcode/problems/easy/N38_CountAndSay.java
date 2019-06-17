package previmedical.it.leetcode.problems.easy;

import android.util.Log;

public class N38_CountAndSay {

    /*
        The count-and-say sequence is the sequence of integers with the first five terms as following:

        1.     1
        2.     11
        3.     21
        4.     1211
        5.     111221
        1 is read off as "one 1" or 11.
        11 is read off as "two 1s" or 21.
        21 is read off as "one 2, then one 1" or 1211.

        Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

        Note: Each term of the sequence of integers will be represented as a string.

        Example 1:
        Input: 1
        Output: "1"

        Example 2:
        Input: 4
        Output: "1211"
     */

    // Calcolo di volta in volta il successivo.
    // Time complexity sum i=1 to n of m, where m is the length of the string to calculate the next one.

    public String countAndSay(int n) {
        switch (n) {
            case 1: return "1";
            case 2: return "11";
            case 3: return "21";
            case 4: return "1211";
            case 5: return "111221";
            case 6: return "312211";
            default: {

                String current = "312211";
                StringBuilder sb = new StringBuilder();

                for (int i=0; i<n - 6;i++) {

                    int start = 0;
                    int end = 0;

                    while (start < current.length()) {
                        while (end < current.length() && current.charAt(start) == current.charAt(end)) {
                            end++;
                        }

                        int times = end - start;
                        sb.append(times);
                        sb.append(current.charAt(start));
                        start = end;
                    }

                    current = sb.toString();
                    sb.delete(0, sb.length());
                }

                return current;
            }
        }
    }

    public void test() {
        String output1 = this.countAndSay(1);
        Log.w("TEST", output1 + " ==? 1");

        String output2 = this.countAndSay(4);
        Log.w("TEST", output2 + " ==? 1211");

        String output3 = this.countAndSay(7);
        Log.w("TEST", output3 + " ==? 13112221");

        String output4 = this.countAndSay(8);
        Log.w("TEST", output4 + " ==? 1113213211");
    }
}
