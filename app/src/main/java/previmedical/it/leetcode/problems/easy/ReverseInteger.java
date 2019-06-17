package previmedical.it.leetcode.problems.easy;

public class ReverseInteger {

    public int reverseDigits(int n) {

        int reversed = 0;

        boolean isPositive = n >= 0;

        while (n != 0) {

            int rest = Math.abs(n % 10);

            if (reversed == 0) {
                if (rest > 0) {
                    reversed = rest;
                }
            }
            else {

                // Multiply by 10 and check for overflow
                int reversedBackup = reversed;
                for (int i=0; i<9;i++) {
                    reversed = reversed + reversedBackup;

                    if (reversed < 0) {
                        return 0;
                    }
                }

                reversed = reversed + rest;

                if (reversed < 0) {
                    return 0;
                }
            }

            n = n / 10;
        }

        return isPositive ? reversed : -reversed;
    }
}
