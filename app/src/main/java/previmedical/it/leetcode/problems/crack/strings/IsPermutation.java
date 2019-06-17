package previmedical.it.leetcode.problems.crack.strings;

import java.util.Arrays;

public class IsPermutation {

    /*
        Given two strings, write a method to decide if one is a permutation of the other.
     */

    public boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);

        char[] s2Array = s2.toCharArray();
        Arrays.sort(s2Array);

        return new String(s1Array).equals(new String(s2Array));
    }

}
