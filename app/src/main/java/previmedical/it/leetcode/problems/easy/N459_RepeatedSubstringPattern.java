package previmedical.it.leetcode.problems.easy;


import android.util.Log;

public class N459_RepeatedSubstringPattern {

    // Given a non-empty string check if it can be constructed by taking a
    // substring of it and appending multiple copies of the substring together.
    // You may assume the given string consists of lowercase English letters
    // only and its length will not exceed 10000.

    // Example 1:
    // Input: "abab"
    // Output: True
    // Explanation: It's the substring "ab" twice.

    // Example 2:
    // Input: "aba"
    // Output: False

    // Example 3:
    // Input: "abcabcabcabc"
    // Output: True
    // Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

    // Parto col primo carattere e cerco la prossima occorrenza del primo carattere.
    // Quando la trovo allora testo il pattern.
    // Se non va a buon fine allora provo a cercare la prossima occorrenza del primo carattere.
    // (Fino alla metà).

    // abab
    // i = 2

    public boolean repeatedSubstringPattern(String s) {

        if (s.length() == 1) {
            return false;
        }

//        char first = s.charAt(0);
//
//        for (int i=1; i<s.length()/2 + 1; i++) {
//
//            if (first == s.charAt(i)) {
//
//                String pattern = s.substring(0, i); // vado fino ad i-1
//
//                if (s.length() % pattern.length() == 0) { // Verifico che possa starci nella stringa
//                    if (this.testPattern(s, pattern)) {
//                        return true;
//                    }
//                }
//            }
//        }
//
//        return false;



        // s = "abcabcabc";
        // mid = 4
        // lastchar = 'c'


//        int mid = s.length() / 2;
//        char lastchar = s.charAt(s.length() - 1);
//        while (mid > 0) {
//            if (s.length() % mid == 0) {
//                String pattern = s.substring(0, mid);
//                boolean equal = true;
//                for (int i = mid; i < s.length(); i += mid) {
//                    if (!pattern.equals(s.substring(i, i + mid))) {
//                        equal = false;
//                        break;
//                    }
//                }
//                if (equal) return true;
//            }
//            mid = s.lastIndexOf(lastchar, mid - 2) + 1;
//        }
        return false;
    }

    private boolean testPattern(String s, String pattern) {
        for (int i=pattern.length(); i<s.length(); i++) {

            int k = i % pattern.length();
            if (s.charAt(i) != pattern.charAt(k)) {
                return false;
            }
        }
        return true;
    }

    public void test() {
        String input = "abcabcabcabc";
        boolean output = this.repeatedSubstringPattern(input);
        Log.w("TEST", "" + output);
    }
}
