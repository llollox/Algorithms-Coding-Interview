package previmedical.it.leetcode.problems.crack.hard;

public class Count2s {
    /*
        Write a method to count the number of 2s between O and n.
     */

    public int count2s(int n) {
        int sum = 0;
        for(int i=0; i<=n; i++) {
            sum += getNumberOf2s(i);
        }
        return sum;
    }

    private int getNumberOf2s(int n) {
        String s = "" + n;
        int count = 0;
        for(int i =0; i<s.length(); i++) {
            if (s.charAt(i) == '2') {
                count += 1;
            }
        }
        return count;
    }

    public int count2sInRange(int n) {
        int count = 0;
        int len = String.valueOf(n).length();
        for (int digit = 0; digit < len; digit++) {
            count += count2sInRangeAtDigit(n, digit);
        }
        return count;
    }

    private int count2sInRangeAtDigit(int n, int d) { // d = 3
        int powerOf10 = (int) Math.pow(10, d); // 1000
        int nextPowerOf10 = powerOf10 * 10; // 10000
        int digit = (n / powerOf10) % 10;
        int roundDown = n - (n % nextPowerOf10);

        if (digit < 2) {
            return roundDown / 10;
        }
        else if (digit > 2) {
            return (roundDown + nextPowerOf10) / 10;
        }
        else {
            int right = n % powerOf10;
            return roundDown / 10 + right + 1;
        }
    }


}
