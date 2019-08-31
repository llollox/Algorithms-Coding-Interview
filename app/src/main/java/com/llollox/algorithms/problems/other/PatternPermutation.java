package com.llollox.algorithms.problems.other;

import java.util.HashMap;

public class PatternPermutation {

    /*
        string s = "someInterviewQuestionsHaveStrings" // len N
        string p = "Ime"                               // len M
     */


    // Time O(N) Space O(M)
    public boolean isPatternPermutationOptmial(String s, String p) {
        if (s == null || p == null || s.isEmpty() || s.length() < p.length()) {
            return false;
        }

        if (p.isEmpty()) {
            return true;
        }

        int n = s.length();
        int m = p.length();

        HashMap<Character, Integer> sMap = this.toCharCountMap(s.substring(0, m));
        HashMap<Character, Integer> pMap = this.toCharCountMap(p);

        int numEqualCounts = 0;

        for (HashMap.Entry<Character, Integer> e : sMap.entrySet()) { // O(M)

            if (e.getValue().equals(pMap.get(e.getKey()))) {
                numEqualCounts += 1;
            }
        }

        if (numEqualCounts == m) {
            return true;
        }

        // S {s: 1, o: 1, m: 1}
        // P {I: 1, m: 1, e: 1}
        // numEqualCounts = 1

        // S {s: 0, o: 0, m: 1, e: 1, I: 1}
        // P {I: 1, m: 1, e: 1}
        // removedChar = 's'
        // addedchar = 'e'
        // numEqualCounts = 3

        for (int i=m; i < n; i++) {
            char removedChar = s.charAt(i - m); // o
            char addedChar = s.charAt(i); // I

            if (removedChar == addedChar) {
                continue;
            }

            // Decreasing part
            int sCharCount = getValueOrZero(sMap, removedChar); // 1
            int pCharCount = getValueOrZero(pMap, removedChar); // 0

            if (pCharCount > 0) {
                if (sCharCount == pCharCount + 1) {
                    numEqualCounts += 1;
                }
                else if (sCharCount == pCharCount) {
                    numEqualCounts -= 1;
                }
            }

            this.decrease(removedChar, sMap);


            // Increasing part
            int sCharCount2 = getValueOrZero(sMap, addedChar); // 0
            int pCharCount2 = getValueOrZero(pMap, addedChar); // 1

            if (pCharCount2 > 0) {
                if (sCharCount2 == pCharCount2 - 1) {
                    numEqualCounts += 1;
                }
                else if (sCharCount2 == pCharCount2) {
                    numEqualCounts -= 1;
                }
            }

            this.increase(addedChar, sMap);


            // Final check
            if (numEqualCounts == m) {
                return true;
            }
        }

        return false;
    }

    private int getValueOrZero(HashMap<Character, Integer> map, char c) {
        Integer value = map.get(c);
        if (value == null) {
            return 0;
        }
        return value;
    }

    private void increase(char c, HashMap<Character, Integer> map) {
        Integer count = map.get(c);
        if (count == null) {
            count = 0;
        }
        map.put(c, count + 1);
    }

    private void decrease(char c, HashMap<Character, Integer> map) {
        Integer count = map.get(c);
        if (count == null) {
            count = 0;
        }
        map.put(c, count - 1);
    }


    private boolean isAnagram(HashMap<Character, Integer> sCharCountMap, HashMap<Character, Integer> patternCharCountMap) {  // Time O(M) Space O(M)
        for (HashMap.Entry<Character, Integer> entry : sCharCountMap.entrySet()) {

            Integer pCharCount = patternCharCountMap.get(entry.getKey());

            if (!entry.getValue().equals(pCharCount)) {
                return false;
            }
        }

        return true;
    }


    public boolean isPatternPermutation(String s, String p) {
        if (s == null || p == null || s.isEmpty() || s.length() < p.length()) {
            return false;
        }

        if (p.isEmpty()) {
            return true;
        }

        int n = s.length();
        int m = p.length();

        StringBuilder sbS = new StringBuilder(s);
        HashMap<Character, Integer> patternCharCountMap = this.toCharCountMap(p);

        for (int i=0; i <= n - m; i++) { // O(N)
            if (isAnagram(patternCharCountMap, sbS.substring(i, i+m))) { // O(M)
                return true;
            }
        }

        return false;
    }

    private boolean isAnagram(HashMap<Character, Integer> patternCharCountMap, String s) {  // Time O(M) Space O(M)
        HashMap<Character, Integer> sCharCountMap = toCharCountMap(s);
        for (HashMap.Entry<Character, Integer> entry : sCharCountMap.entrySet()) {

            Integer pCharCount = patternCharCountMap.get(entry.getKey());

            if (!entry.getValue().equals(pCharCount)) {
                return false;
            }
        }

        return true;
    }

    private HashMap<Character, Integer> toCharCountMap(String s) {  // Time O(M) Space O(M)
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                count = 0;
            }
            count += 1;
            map.put(c, count);
        }

        return map;
    }

}
