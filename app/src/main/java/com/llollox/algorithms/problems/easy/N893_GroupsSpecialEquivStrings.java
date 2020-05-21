package com.llollox.algorithms.problems.easy;

import java.util.HashSet;

public class N893_GroupsSpecialEquivStrings {

    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> set = new HashSet<>();
        for (String s : A) {
            set.add(hash(s));
        }
        return set.size();
    }

    public String hash(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 2; j < chars.length; ) {
                if (chars[i] > chars[j]) {
                    char temp = chars[j];
                    chars[j] = chars[i];
                    chars[i] = temp;
                }
                j += 2;
            }
        }

        return String.valueOf(chars);
    }
}
