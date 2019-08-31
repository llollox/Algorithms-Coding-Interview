package com.llollox.algorithms.problems.medium;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String s1, String s2) {

        // P[i,j] e' la lcs tra s1[0..i] e s2[0..j]
        if (s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }

        return 1;
//        return lcs(s1, s2, s1.length() - 1, s2.length() - 1);
//        return lcs(s1, s2);

//        int n1 = s1.length();
//        int n2 = s2.length();
//        int maxLength = Math.max(n1, n2);

//        P[i, j] =
        // if s1[i] == s2[j] => P[i-1, j-1] + s1[i]
        // if s1[i] != s2[j] => {
            // a = P[i - 1, j - 1] + s2[j] // Prendo s2
            // b = P[i - 1, j - 1] + s1[i] // Prendo s1
            // c = P[i - 1, j - 1] // Non prendo nessuno
            // return Math.max(a, b, c)
        // }
    }



//    private String lcs(String s1, String s2) {
//
//        int n = s1.length();
//        int m = s2.length();
//
//        String[][] P = new String[n][m];
//
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//
//                if (i==0 || j==0) {
//                    P[i][j] = "";
//                }
//                else {
//                    char c1 = s1.charAt(i);
//                    char c2 = s2.charAt(j);
//
//                    if (c1 == c2) {
//                        P[i][j] = P[i - 1][j - 1] + c1;
//                    }
//                    else {
//                        P[i][j] = Math.max(P[i - 1][j].length(), P[i][j - 1]);
//                    }
//                }
//            }
//        }
//
//        return P[n-1][m-1];
//    }


//    private int lcs(String s1, String s2) {
//
//        int n = s1.length();
//        int m = s2.length();
//
//        int[][] P = new int[n][m];
//
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//
//                if (i==0 || j==0) {
//                    P[i][j] = 0;
//                }
//                else {
//                    char c1 = s1.charAt(i);
//                    char c2 = s2.charAt(j);
//
//                    if (c1 == c2) {
//                        P[i][j] = P[i - 1][j - 1] + 1;
//                    }
//                    else {
//                        P[i][j] = Math.max(P[i - 1][j], P[i][j - 1]);
//                    }
//                }
//            }
//        }
//
//        return P[n-1][m-1];
//    }


    private int lcs(String s1, String s2, int i, int j) {

        if (i < 0 || j < 0) {
            return 0;
        }

        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);

        if (c1 == c2) {
            return lcs(s1, s2, i - 1, j - 1) + 1;
        }
        else {
            int a = lcs(s1, s2, i - 1, j);
            int b = lcs(s1, s2, i, j - 1);
            return Math.max(a, b);
        }


    }
}
