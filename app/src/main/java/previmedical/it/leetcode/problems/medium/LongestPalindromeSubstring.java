package previmedical.it.leetcode.problems.medium;

public class LongestPalindromeSubstring {


    public String expandingOptimized(String s) {

        if (s == null || s.isEmpty()) {
            return "";
        }

        int n = s.length();

        if (n == 1) {
            return s.substring(0, 1);
        }

        String longest = "";


        int mid = (n - 1)/2;

        String expand = this.calculateLongestPolindrome(s, mid, n);
        if (longest.length() < expand.length()) {
            longest = expand;
        }

        boolean even = n % 2 == 0;

        if (even) {
            String expand1 = this.calculateLongestPolindrome(s, mid + 1, n);
            if (longest.length() < expand1.length()) {
                longest = expand1;
            }
        }

        int offset = even ? 1 : 0;
        for (int i=1; i <= mid; i++) {

            if (longest.length() >= 2*(mid - i) + 2) { // maxPossiblePalindrome
                break;
            }

            String expandI = this.calculateLongestPolindrome(s, mid - i, n);
            if (longest.length() < expandI.length()) {
                longest = expandI;
            }

            String expandK = this.calculateLongestPolindrome(s, mid + i + offset, n);
            if (longest.length() < expandK.length()) {
                longest = expandK;
            }

        }

        return longest;
    }

    // Private functions ***********************************************************************************************
    private String calculateLongestPolindrome(String s, int center, int n) {

        String expandSingle = this.expandAroundCenter(s, center, center, n);

        if (center == n - 1) {
            return expandSingle;
        }
        else {
            String expandCouple = this.expandAroundCenter(s, center, center + 1, n);
            if (expandCouple.length() > expandSingle.length()) {
                return expandCouple;
            }
            else {
                return expandSingle;
            }
        }
    }

    private String expandAroundCenter(String s, int left, int right, int n) {

        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(++left, right);
    }


    public String expanding(String s) {

        int n = s.length();
        String longest = "";

        for (int i = 0; i<n; i++) {
            String expandOut = this.expandAroundCenter(s, i, i, n);
            String expandIn = i == n - 1 ? "" : this.expandAroundCenter(s, i, i + 1, n);

            if (expandIn.length() > expandOut.length()) {
                if (expandIn.length() > longest.length()) {
                    longest = expandIn;
                }
            }
            else {
                if (expandOut.length() > longest.length()) {
                    longest = expandOut;
                }
            }
        }

        return longest;
    }

    public String withMatrix(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String longest = s.substring(0, 1);

        int n = s.length();
        boolean[][] matrix = new boolean[n][n];

        for (int k=1; k < n; k++) {

            for (int i = 0; i < n - k; i++) {

                int j = i + k;

                if (j == i + 1) {
                    matrix[i][j] = s.charAt(i) == s.charAt(j);
                }
                else {
                    matrix[i][j] = ((i + 1 == j - 1) || matrix[i + 1][j - 1]) && s.charAt(i) == s.charAt(j);
                }

                if (longest.length() < k + 1 && matrix[i][j]) {
                    longest = s.substring(i,j + 1);
                }
            }
        }

        return longest;
    }
}
