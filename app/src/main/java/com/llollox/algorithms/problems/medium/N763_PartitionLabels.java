package com.llollox.algorithms.problems.medium;

import java.util.*;

public class N763_PartitionLabels {

    /*
        A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

        Example 1:
        Input: S = "ababcbacadefegdehijhklij"
        Output: [9,7,8]
        Explanation:
        The partition is "ababcbaca", "defegde", "hijhklij".
        This is a partition so that each letter appears in at most one part.

        A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

        Note:
        S will have length in range [1, 500].
        S will consist of lowercase letters ('a' to 'z') only.
     */

    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> results = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return results;
        }

        HashMap<Character, Integer> freq = getFrequencyMap(S);
        Set<Character> chars = new HashSet<>();

        int start = 0;
        int i = 0;
        while (i<S.length()) {
            char c = S.charAt(i);

            chars.add(c);

            freq.put(c, freq.get(c) - 1);

            if (freq.get(c) <= 0) {
                chars.remove(c);
            }

            if (chars.isEmpty()) {
                int size = (i - start) + 1;
                results.add(size);
                start = i + 1;
            }
            i+= 1;
        }

        if (start < i) {
            int size = i - start;
            results.add(size);
        }
        return results;
    }


    private HashMap<Character, Integer> getFrequencyMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length();i++) {
            char c = s.charAt(i);
            int occurrences = map.get(c) != null ? map.get(c) : 0;
            map.put(c, occurrences + 1);
        }
        return map;
    }

}
